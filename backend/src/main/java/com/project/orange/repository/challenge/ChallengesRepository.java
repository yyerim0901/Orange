package com.project.orange.repository.challenge;

import com.project.orange.entity.challenge.Challenges;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChallengesRepository extends JpaRepository<Challenges, Long> {
}
