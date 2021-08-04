package com.project.orange.service;

import com.project.orange.entity.badge.Badges;
import com.project.orange.repository.badge.BadgeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BadgesServiceImpl implements BadgesService{

    @Autowired
    private BadgeRepository badgeRepository;

    @Override
    public Optional<Badges> selectOne(Long badgeId) { return badgeRepository.findById(badgeId); }

    @Override
    public List<Badges> selectAll() { return badgeRepository.findAll(); }
}
