package com.project.orange.service.badge;

import com.project.orange.entity.badge.BadgeTypes;

import java.util.List;
import java.util.Optional;

public interface BadgeTypesService {
    public Optional<BadgeTypes> selectOne(Long badgeId);
    public List<BadgeTypes> selectAll();
}
