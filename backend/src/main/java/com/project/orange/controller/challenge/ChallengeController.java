package com.project.orange.controller.challenge;

import com.project.orange.entity.challenge.BattleMatching;
import com.project.orange.entity.challenge.Challenges;
import com.project.orange.entity.notification.Notifications;
import com.project.orange.entity.user.UsersChallenges;
import com.project.orange.service.challenge.ChallengeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/challenge")
public class ChallengeController {

    @Autowired
    private ChallengeService challengeService;

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
    public ResponseEntity<List<Challenges>> selectAllSoretedByTotalPointDesc(){
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
    public ResponseEntity<String>  registerNewUserToChallenge(@RequestBody Map<String, Long> parameters){
        Long challengeId = parameters.get("challengeId");
        Long userId = parameters.get("userId");
        Optional<Challenges> targetChallenge = challengeService.selectByChallengeId(challengeId);
        if(targetChallenge.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        if(challengeService.isUserAlreadyInChallenge(challengeId, userId)){
            return new ResponseEntity<>("Already In Challenge",HttpStatus.OK);
        } else {
            Optional<UsersChallenges> newUser = challengeService.registerNewUserToChallenge(challengeId, userId);
            if(newUser.isEmpty()){
                return new ResponseEntity<>("Failed", HttpStatus.NO_CONTENT);
            } else {
                Long managerId = targetChallenge.get().getManagerId();
                return new ResponseEntity<>("Success", HttpStatus.OK);
            }
        }
    }

    @PostMapping("/register/new-challenge")
    public ResponseEntity<String> registerNewChallenge(@RequestBody Challenges challenge){
        Optional<BattleMatching> matchMakingResult;
        matchMakingResult = challengeService.registerNewChallenge(challenge);

        if(matchMakingResult.isPresent()){
            // Todo : notification 연동
            List<Notifications> notificationsList = challengeService.notifyMatchMaking(matchMakingResult.get());
            if(notificationsList != null && !notificationsList.isEmpty()) {
                return new ResponseEntity<>("matched", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Notification Error", HttpStatus.NO_CONTENT);
            }
        }
        else {
            return new ResponseEntity<>("unmatched", HttpStatus.OK);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<String> modify(@RequestBody Challenges challenge){
        Optional<Challenges> modifiedChallenge = challengeService.save(challenge);
        if(modifiedChallenge.isEmpty()){
            return new ResponseEntity<>("failed", HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>("success", HttpStatus.OK);
        }
    }
}
