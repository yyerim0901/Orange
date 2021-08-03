package com.project.orange.service;

import com.project.orange.entity.challenge.Challenges;
import com.project.orange.repository.challenge.ChallengesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
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

    @Override
    public Challenges insert(Challenges challenge) {
        return challengesRepository.save(challenge);
    }

    @Override
    public void deleteById(Long challengeId) {
        challengesRepository.deleteById(challengeId);
    }
}
