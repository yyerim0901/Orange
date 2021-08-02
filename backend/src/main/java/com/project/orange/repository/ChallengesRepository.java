package com.project.orange.repository;

import com.project.orange.entity.Challenges;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChallengesRepository extends JpaRepository<Challenges, Long> {
}
