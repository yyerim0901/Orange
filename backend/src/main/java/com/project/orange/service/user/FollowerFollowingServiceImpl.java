//package com.project.orange.service.user;
//
//import com.project.orange.entity.user.FollowerFollowing;
//import com.project.orange.repository.user.FollowFollowingRepository;
//import com.project.orange.repository.user.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class FollowerFollowingServiceImpl implements FollowerFollowingService {
//
//    @Autowired
//    FollowFollowingRepository followFollowingRepository;
//
//    @Autowired
//    UserService userService;
//
//    @Autowired
//    UserRepository userRepository;
//
//    @Override
//    public void save(Long fromUserId, Long toUserId){
//        FollowerFollowing fw = new FollowerFollowing();
//
//        fw.setFrom(userRepository.findByUserId(fromUserId));
//        fw.setTo(userRepository.findByUserId(toUserId));
//
//        followFollowingRepository.save(fw);
//    }
//
//    @Override
//    public void deleteByFollowingIdAndFollowerId(Long fromUserId, Long toUserId){
//        followFollowingRepository.deleteByFollowingFollowerId(fromUserId,toUserId);
//    }
//
//    @Override
//    public boolean checkFollowing(Long fromUserId, Long toUserId) { // 팔로우가 되어있는지를 확인하기위해
//        if(followFollowingRepository.countByFollowerIdAndFollowingUserId(fromUserId, toUserId) == 0)
//            return false; // 팔로우 안되어있음
//        return true; // 되어있음
//    }
//
//}
