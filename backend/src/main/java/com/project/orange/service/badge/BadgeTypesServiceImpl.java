package com.project.orange.service.badge;

import com.project.orange.entity.badge.BadgeTypes;
import com.project.orange.repository.badge.BadgeTypesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BadgeTypesServiceImpl implements BadgeTypesService {

    @Autowired
    private BadgeTypesRepository badgeTypesRepository;

    @Override
    public Optional<BadgeTypes> selectOne(Long badgeTypesId) { return badgeTypesRepository.findById(badgeTypesId); }

    @Override
    public List<BadgeTypes> selectAll() { return badgeTypesRepository.findAll(); }
}
