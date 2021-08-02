package com.project.orange.repository;

import com.project.orange.entity.BattleMatching;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BattleMatchingRepository extends JpaRepository<BattleMatching, Long> {
}
