package com.project.orange.service;

import com.project.orange.entity.challenge.Challenges;

import java.util.List;
import java.util.Optional;

public interface ChallengeService {
    public Optional<Challenges> selectOne(Long challengeId);
    public List<Challenges> selectAll();
    public Challenges insert(Challenges challenge);
    public void deleteById(Long id);
}
