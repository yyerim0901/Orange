package com.project.orange.controller;

import com.project.orange.entity.challenge.Challenges;
import com.project.orange.service.ChallengeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class ChallengeController {

    @Autowired
    private ChallengeService challengeService;

    @GetMapping("/api/challenge/{challengeId}")
    public ResponseEntity<Challenges> selectOne(@PathVariable Long challengeId){
        Optional<Challenges> challenge = challengeService.selectOne(challengeId);
        if(challenge != null){
            return new ResponseEntity<Challenges>(challenge.get(), HttpStatus.OK);
        }
        else{
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/api/challenge/list")
    public ResponseEntity<List<Challenges>> selectAll(){
        List<Challenges> list = challengeService.selectAll();
        if(list != null && !list.isEmpty()){
            return new ResponseEntity<List<Challenges>>(list, HttpStatus.OK);
        }
        else{
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
    }
}
