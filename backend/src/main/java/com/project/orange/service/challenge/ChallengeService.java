package com.project.orange.service.challenge;

import com.project.orange.entity.challenge.BattleMatching;
import com.project.orange.entity.challenge.Challenges;

import java.util.List;
import java.util.Optional;

public interface ChallengeService {
    public Optional<Challenges> selectByChallengeId(Long challengeId);
    public List<Challenges> selectAll();
    // registerNewChallenge : 새로운 Challenge 등록 -> Challenge의 BattleMatching 결과 리턴
    public Optional<BattleMatching> registerNewChallenge(Challenges challenge);
    public void deleteById(Long id);
}
