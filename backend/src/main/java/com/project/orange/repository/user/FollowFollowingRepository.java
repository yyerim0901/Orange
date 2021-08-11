package com.project.orange.repository.user;

import com.project.orange.entity.user.FollowerFollowing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface FollowFollowingRepository extends JpaRepository<FollowerFollowing, Long> {
//    @Modifying
//    @Transactional
//    void deleteByFollowingFollowerId(Long fromUserId, Long toUserId); //언팔
//    int countByFollowerIdAndFollowingUserId(Long fromUserId, Long toUserId);
}
