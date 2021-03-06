package com.project.orange.controller.challenge;

import com.project.orange.entity.challenge.Periods;
import com.project.orange.service.challenge.PeriodService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/period")
public class PeriodController {
    @Autowired
    private PeriodService periodService;

    @ApiOperation(value="기간 목록", notes = "<big>챌린지</big>의 <big>선택 가능한 기간의 목록</big> 반환")
    @GetMapping("/list")
    public ResponseEntity<List<Periods>> selectAll(){
        List<Periods> list;
        list = periodService.selectAll();
        if (list == null || list.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
    }
}
