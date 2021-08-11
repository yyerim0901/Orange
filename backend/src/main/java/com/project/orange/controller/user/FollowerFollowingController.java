package com.project.orange.controller.user;

import com.project.orange.repository.user.FollowFollowingRepository;
import com.project.orange.service.user.FollowerFollowingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/follow")
public class FollowerFollowingController {

    @Autowired
    public FollowerFollowingService followerFollowingService;

//    @GetMapping("/check/{userId}")
//    public ResponseEntity<String> checkMainUser(@PathVariable Long userId){
//
//        String loginUserId = SecurityContextHolder.getContext().getAuthentication().getName();
//        followerFollowingService.checkFollowing((Long)loginUserId, userId);
//    }

//    @GetMapping("/follow/{fromUserId}/{toUserId}")
//    public void follow(@PathVariable Long fromUserId, @PathVariable Long toUserId){
//        followerFollowingService.save(fromUserId,toUserId);
//    }
//
//    @GetMapping("/unfollow/{fromUserId}/{toUserId}")
//    public void unFollow(@PathVariable Long fromUserId, @PathVariable Long toUserId){
//        followerFollowingService.deleteByFollowingIdAndFollowerId(fromUserId,toUserId);
//    }


}
