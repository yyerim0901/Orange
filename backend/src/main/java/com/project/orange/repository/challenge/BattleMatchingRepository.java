package com.project.orange.repository.challenge;

import com.project.orange.entity.challenge.BattleMatching;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BattleMatchingRepository extends JpaRepository<BattleMatching, Long> {
}
