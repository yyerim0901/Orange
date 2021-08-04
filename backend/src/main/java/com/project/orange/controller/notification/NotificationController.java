package com.project.orange.controller.notification;

import com.project.orange.entity.notification.Notifications;
import com.project.orange.service.nofitication.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/notification")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @GetMapping("/select/{userId}")
    public ResponseEntity<List<Notifications>> selectAllByUserId(@PathVariable Long userId){
        List<Notifications> list = notificationService.selectAllByUserId(userId);
        if(list != null && !list.isEmpty()){
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    // Todo : delete url에 대한 권한 확인 작업 필요
    @DeleteMapping("/delete/{notificationId}")
    public ResponseEntity<String> delete(@PathVariable Long notificationId){
        try {
            notificationService.deleteByNotificationId(notificationId);
            return new ResponseEntity<>("success", HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>("failed", HttpStatus.NO_CONTENT);
        }
    }
}
