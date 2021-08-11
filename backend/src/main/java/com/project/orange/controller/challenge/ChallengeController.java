package com.project.orange.controller.challenge;

import com.project.orange.entity.challenge.BattleMatching;
import com.project.orange.entity.challenge.Challenges;
import com.project.orange.entity.notification.Notifications;
import com.project.orange.entity.user.UsersChallenges;
import com.project.orange.service.challenge.ChallengeService;
import com.project.orange.service.nofitication.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static com.project.orange.management.Constants.challengeNewMemberRegisteredContent;
import static com.project.orange.management.Constants.challengeNewMemberRegisteredTitle;

@RestController
@RequestMapping("/api/challenge")
public class ChallengeController {

    @Autowired
    private ChallengeService challengeService;

    @Autowired
    private NotificationService notificationService;

    @GetMapping("/{challengeId}")
    public ResponseEntity<Challenges> selectOne(@PathVariable Long challengeId){
        Optional<Challenges> challenge;
        challenge = challengeService.selectByChallengeId(challengeId);
        if(challenge.isPresent()){
            return new ResponseEntity<>(challenge.get(), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/list")
    public ResponseEntity<List<Challenges>> selectAll(){
        List<Challenges> list;
        list = challengeService.selectAll();
        if (list == null || list.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
    }

    @GetMapping("/ranking/point")
    public ResponseEntity<List<Challenges>> selectAllSortedByTotalPointDesc(){
        List<Challenges> list;
        list = challengeService.selectAllSortedByTotalPoint();
        if (list == null || list.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
    }

    @GetMapping("/ranking/startdate")
    public ResponseEntity<List<Challenges>> selectAllSortedByStartDate(){
        List<Challenges> list;
        list = challengeService.selectAllSortedByStartDate();
        if (list == null || list.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
    }

    @GetMapping("/list/random/{number}")
    public ResponseEntity<List<Challenges>> selectAllByRandom(@PathVariable int number){
        List<Challenges> list;
        list = challengeService.selectAllByRandom(number);
        if (list == null || list.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
    }

    @PostMapping("/register/new-user")
    public ResponseEntity<Map<String, String>>  registerNewUserToChallenge(@RequestBody Map<String, Long> parameters){
        Long challengeId = parameters.get("challengeId");
        Long userId = parameters.get("userId");
        Optional<Challenges> targetChallenge = challengeService.selectByChallengeId(challengeId);
        Map<String, String> response = new HashMap<>();
        if(targetChallenge.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        if(challengeService.isUserAlreadyInChallenge(challengeId, userId)){
            response.put("result", "Already In Challenge");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            Optional<UsersChallenges> newUser = challengeService.registerNewUserToChallenge(challengeId, userId);
            if(newUser.isEmpty()){
                response.put("result", "Failed");
                return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
            } else {
                Long managerId = targetChallenge.get().getManagerId();
                Optional<Notifications> notification;
                notification = notificationService.sendNotificationTo(
                        managerId,
                        challengeNewMemberRegisteredTitle,
                        challengeNewMemberRegisteredContent
                );
                if(notification.isPresent()) {
                    response.put("result", "Success");
                    return new ResponseEntity<>(response, HttpStatus.OK);
                } else {
                    response.put("result", "Notification Error");
                    return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
                }
            }
        }
    }

    @PostMapping("/register/new-challenge")
    public ResponseEntity<Map<String, String>> registerNewChallenge(@RequestBody Challenges challenge){
        Optional<BattleMatching> matchMakingResult;
        matchMakingResult = challengeService.registerNewChallenge(challenge);
        Map<String, String> response = new HashMap<>();
        if(matchMakingResult.isPresent()){
            // Todo : notification 연동
            List<Notifications> notificationsList = challengeService.notifyMatchMaking(matchMakingResult.get());
            if(notificationsList != null && !notificationsList.isEmpty()) {
                response.put("result", "matched");
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                response.put("result", "Notification Error");
                return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
            }
        }
        else {
            response.put("result", "unmatched");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Map<String, String>> modify(@RequestBody Challenges challenge){
        Optional<Challenges> modifiedChallenge = challengeService.save(challenge);
        Map<String, String> response = new HashMap<>();
        if(modifiedChallenge.isEmpty()){
            response.put("result", "failed");
            return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
        } else {
            response.put("result", "success");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }
}
