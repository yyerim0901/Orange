package com.project.orange.repository;

import com.project.orange.entity.UsersChallenges;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersChallengesRepository extends JpaRepository<UsersChallenges, Long> {
}
