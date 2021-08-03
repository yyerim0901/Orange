package com.project.orange.repository.badge;

import com.project.orange.entity.badge.Badges;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BadgeRepository extends JpaRepository<Badges, Long> {
}
