package com.project.orange.service;

import com.project.orange.entity.challenge.Challenges;
import com.project.orange.repository.challenge.ChallengesRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ChallengeServiceImpl implements ChallengeService{

    @Autowired
    private ChallengesRepository challengesRepository;

    @Override
    public Optional<Challenges> selectOne(Long challengeId) {
        return challengesRepository.findById(challengeId);
    }

    @Override
    public List<Challenges> selectAll() {
        return challengesRepository.findAll();
    }
}
