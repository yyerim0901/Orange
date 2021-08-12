package com.project.orange.controller.user;

import com.project.orange.entity.user.Users;
import com.project.orange.repository.user.FollowFollowingRepository;
import com.project.orange.repository.user.UserRepository;
import com.project.orange.service.user.FollowerFollowingService;
import com.project.orange.service.user.UserService;
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

    @Autowired
    public UserService userService;

    @Autowired
    public UserRepository userRepository;

    @GetMapping("/check/{userId}")
    public ResponseEntity<String> checkMainUser(@PathVariable Long userId){

        String loginUserId = SecurityContextHolder.getContext().getAuthentication().getName(); //여기서 email을 얻어옴
        Users userInfo = userRepository.findByEmail(loginUserId);

        followerFollowingService.checkFollowing(userInfo.getUserId(), userId);
        ////////////얘는 뭘 return 해야하지,,?
        return null;
    }

    @GetMapping("/follow/{fromUserId}/{toUserId}")
    public void follow(@PathVariable Long fromUserId, @PathVariable Long toUserId){
        followerFollowingService.save(fromUserId,toUserId);
    }

    @GetMapping("/unfollow/{fromUserId}/{toUserId}")
    public void unFollow(@PathVariable Long fromUserId, @PathVariable Long toUserId){
        followerFollowingService.deleteByFollowingIdAndFollowerId(fromUserId,toUserId);
    }


}
