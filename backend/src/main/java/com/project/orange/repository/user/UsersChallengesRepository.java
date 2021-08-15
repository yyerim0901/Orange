package com.project.orange.repository.user;

import com.project.orange.entity.user.UsersChallenges;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersChallengesRepository extends JpaRepository<UsersChallenges, Long> {
    public Optional<UsersChallenges> findByUserUserIdAndChallengeChallengeId(Long userId, Long challengeId);
}
