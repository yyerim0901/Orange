package com.project.orange.controller;

import com.project.orange.entity.badge.BadgeTypes;
import com.project.orange.service.BadgeTypesService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BadgeTypesController {
    @Autowired
    private BadgeTypesService badgeTypesService;

    @ApiOperation(value = "뱃지타입 목록", notes = "<big>뱃지</big>의 <big>타입 목록</big> 반환")
    @GetMapping("/api/badgetype/list")
    public ResponseEntity<List<BadgeTypes>> selectAll(){
        List<BadgeTypes> list = badgeTypesService.selectAll();
        if(list != null && !list.isEmpty()) {
            return new ResponseEntity<List<BadgeTypes>>(list, HttpStatus.OK);
        }
        else {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
    }
}
