package com.project.orange.repository;

import com.project.orange.entity.Badges;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BadgeRepository extends JpaRepository<Badges, Long> {
}
