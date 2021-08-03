package com.project.orange.service;

import com.project.orange.entity.challenge.BattleMatching;
import com.project.orange.entity.challenge.Challenges;

import java.util.List;
import java.util.Optional;

public interface ChallengeService {
    public Optional<Challenges> selectByChallengeId(Long challengeId);
    public List<Challenges> selectAll();
    public Optional<BattleMatching> registerNewChallenge(Challenges challenge);
    public void deleteById(Long id);
}
