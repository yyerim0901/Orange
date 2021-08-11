package com.project.orange.service.challenge;

import com.project.orange.entity.challenge.BattleMatching;
import com.project.orange.entity.challenge.Challenges;
import com.project.orange.entity.notification.Notifications;
import com.project.orange.entity.user.Users;
import com.project.orange.entity.user.UsersChallenges;

import java.util.List;
import java.util.Optional;

public interface ChallengeService {
    public Optional<Challenges> save(Challenges challenge);
    public Optional<Challenges> selectByChallengeId(Long challengeId);
    public List<Challenges> selectAll();
    public List<Challenges> selectAllSortedByTotalPoint();
    public List<Challenges> selectAllSortedByStartDate();
    public List<Challenges> selectAllByRandom(int number);
    // registerNewChallenge : 새로운 Challenge 등록 -> Challenge의 BattleMatching 결과 리턴
    public Optional<BattleMatching> registerNewChallenge(Challenges challenge);
    public Optional<UsersChallenges> registerNewUserToChallenge(Long challengeId, Long userId);
    public boolean isUserAlreadyInChallenge(Long challengeId, Long userId);
    public List<Notifications> notifyMatchMaking(BattleMatching battleMatching);
    public void deleteById(Long id);
}
