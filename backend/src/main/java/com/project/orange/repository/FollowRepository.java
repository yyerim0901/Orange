package com.project.orange.repository;

import com.project.orange.entity.FollowerFollowing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FollowRepository extends JpaRepository<FollowerFollowing, Long> {
}
