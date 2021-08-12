package com.project.orange.controller.notification;

import com.project.orange.entity.notification.Notifications;
import com.project.orange.service.nofitication.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/notification")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @GetMapping("/select/{userId}")
    public ResponseEntity<List<Notifications>> selectAllByUserId(@PathVariable Long userId){
        List<Notifications> list;
        list = notificationService.selectAllByUserId(userId);
        if (list == null || list.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
    }

    // Todo : delete url에 대한 권한 확인 작업 필요
    @DeleteMapping("/delete/{notificationId}")
    public ResponseEntity<Map<String, String>> delete(@PathVariable Long notificationId){
        Map<String, String> response = new HashMap<>();
        try {
            notificationService.deleteByNotificationId(notificationId);
            response.put("result", "success");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (Exception e){
            response.put("result", "failed");
            return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
        }
    }
}
