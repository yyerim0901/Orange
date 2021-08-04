package com.project.orange.controller.challenge;

import com.project.orange.entity.challenge.BattleMatching;
import com.project.orange.service.challenge.BattleMatchingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/battle-matching")
public class BattleMatchingController {

    @Autowired
    private BattleMatchingService battleMatchingService;

    @GetMapping("/select/{id}")
    public ResponseEntity<BattleMatching> selectOne(@PathVariable Long id){
        Optional<BattleMatching> battleMatching;
        battleMatching = battleMatchingService.selectOne(id);
        if(battleMatching != null){
            return new ResponseEntity<>(battleMatching.get(), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("select/list")
    public ResponseEntity<List<BattleMatching>> selectAll(){
        List<BattleMatching> list;
        list = battleMatchingService.selectAll();
        if (list == null || list.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
    }
}
