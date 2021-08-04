package com.project.orange.service.badge;

import com.project.orange.entity.badge.Badges;

import java.util.List;
import java.util.Optional;

public interface BadgesService {
    public Optional<Badges> selectOne(Long badge);
    public List<Badges> selectAll();
}
