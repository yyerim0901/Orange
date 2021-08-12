package com.project.orange.controller.report;

import com.project.orange.entity.report.Reports;
import com.project.orange.service.report.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/report")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping("/select/list")
    public ResponseEntity<List<Reports>> selectAll(){
        List<Reports> list;
        list = reportService.selectAll();
        if (list == null || list.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
    }

    @GetMapping("/selectByReportCategory/{reportCategory}")
    public ResponseEntity<List<Reports>> selectByReportCategory(@PathVariable Long reportCategory){
        List<Reports> list;
        list = reportService.selectAllByReportCategory(reportCategory);
        if (list == null || list.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
    }

    @PostMapping("/insert")
    public ResponseEntity<Map<String, String>> insert(@RequestBody Reports report){
        Map<String, String> response = new HashMap<>();
        try{
            reportService.insert(report);
            response.put("result", "success");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (Exception e){
            response.put("result", "failed");
            return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
        }
    }
}
