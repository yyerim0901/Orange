package com.project.orange.controller;

import com.project.orange.entity.challenge.BattleMatching;
import com.project.orange.service.BattleMatchingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class BattleMatchingController {

    @Autowired
    private BattleMatchingService battleMatchingService;

    @GetMapping("/api/battle-matching/{id}")
    public ResponseEntity<BattleMatching> selectOne(@PathVariable Long id){
        Optional<BattleMatching> battleMatching = battleMatchingService.selectOne(id);
        if(battleMatching != null){
            return new ResponseEntity<BattleMatching>(battleMatching.get(), HttpStatus.OK);
        }
        else{
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/api/battle-matching/list")
    public ResponseEntity<List<BattleMatching>> selectAll(){
        List<BattleMatching> list = battleMatchingService.selectAll();
        if(list != null && !list.isEmpty()){
            return new ResponseEntity<List<BattleMatching>>(list, HttpStatus.OK);
        }
        else{
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
    }
}
