package com.project.orange.repository.challenge;

import com.project.orange.entity.challenge.Periods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeriodsRepository extends JpaRepository<Periods, Long> {
}
