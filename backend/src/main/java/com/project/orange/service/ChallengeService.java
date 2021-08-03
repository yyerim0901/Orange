package com.project.orange.service;

import com.project.orange.entity.challenge.Challenges;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public interface ChallengeService {
    public Optional<Challenges> selectOne(Long challengeId);
    public List<Challenges> selectAll();
}
