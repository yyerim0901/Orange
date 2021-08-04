package com.project.orange.repository.badge;

import com.project.orange.entity.badge.BadgeTypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BadgeTypesRepository extends JpaRepository<BadgeTypes, Long> {
}
