package com.project.orange.controller.badge;

import com.project.orange.entity.badge.Badges;
import com.project.orange.service.badge.BadgesService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/badge")
public class BadgesController {
    @Autowired
    private BadgesService badgesService;

    @ApiOperation(value = "뱃지 목록", notes = "<big>모든 뱃지</big>의 <big>목록</big> 반환")
    @GetMapping("/list")
    public ResponseEntity<List<Badges>> selectAll(){
        List<Badges> list = badgesService.selectAll();
        if(list != null && !list.isEmpty()) {
            return new ResponseEntity<List<Badges>>(list, HttpStatus.OK);
        }
        else {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
    }
}
