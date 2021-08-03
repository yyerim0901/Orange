package com.project.orange.repository.user;

import com.project.orange.entity.user.FollowerFollowing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FollowFollowingRepository extends JpaRepository<FollowerFollowing, Long> {
}
