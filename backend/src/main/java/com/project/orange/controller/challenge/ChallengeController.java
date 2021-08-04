package com.project.orange.controller.challenge;

import com.project.orange.entity.challenge.BattleMatching;
import com.project.orange.entity.challenge.Challenges;
import com.project.orange.service.challenge.ChallengeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ChallengeController {

    @Autowired
    private ChallengeService challengeService;

    @GetMapping("/api/challenge/{challengeId}")
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

    @GetMapping("/api/challenge/list")
    public ResponseEntity<List<Challenges>> selectAll(){
        List<Challenges> list;
        list = challengeService.selectAll();
        if (list == null || list.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
    }

    @PostMapping("/api/challenge/register")
    public ResponseEntity<String> register(@RequestBody Challenges challenge){
        Optional<BattleMatching> matchMakingResult;
        matchMakingResult = challengeService.registerNewChallenge(challenge);

        if(matchMakingResult.isPresent()){
            // Todo : notification 연동
            return new ResponseEntity<>("matched", HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("unmatched", HttpStatus.OK);
        }

    }
}
