package com.project.orange.service;

import com.project.orange.entity.challenge.BattleMatching;
import com.project.orange.entity.challenge.Challenges;
import com.project.orange.repository.challenge.BattleMatchingRepository;
import com.project.orange.repository.challenge.ChallengesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ChallengeServiceImpl implements ChallengeService{

    @Autowired
    private ChallengesRepository challengesRepository;
    @Autowired
    private BattleMatchingRepository battleMatchingRepository;

    @Override
    public Optional<Challenges> selectByChallengeId(Long challengeId) {
        return challengesRepository.findById(challengeId);
    }

    @Override
    public List<Challenges> selectAll() {
        return challengesRepository.findAll();
    }

    @Override
    public Optional<BattleMatching> registerNewChallenge(Challenges challenge) {
        // 전달받은 Challenge 객체로 DB 저장
        Challenges currentChallenge = challengesRepository.save(challenge);

        // 현재 저장한 Challenge 정보
        Long currentChallengeId = currentChallenge.getChallengeId();
        Long currentPeriodId = currentChallenge.getPeriodId();

        // 현재 저장한 Challenge와 같은 도전 기간을 갖는 Challenge의 List
        List<Challenges> samePeriodChallengesList = challengesRepository.findAllByPeriodId(currentPeriodId);
        // matching이 아직 이루어지지 않은 Challenge를 저장할 List
        List<Challenges> matchmakingPool = new ArrayList<>();

        // BattleMatching 테이블에 존재하지 않는 Challenge만 선별
        for(Challenges each : samePeriodChallengesList){
            if(battleMatchingRepository.findByBlueTeamId(currentChallengeId).isPresent() &&
                battleMatchingRepository.findByRedTeamId(currentChallengeId).isPresent()){
                matchmakingPool.add(each);
            }
        }

        BattleMatching savedBattleMatching = null;
        if(!matchmakingPool.isEmpty()){
            // matchmaking pool에서 랜덤으로 Challenge 하나 선택, opponenet Challenge로 선정
            int selectedIdx = (int) Math.random() * matchmakingPool.size();
            Challenges opponentChallenge = challengesRepository.getById(matchmakingPool.get(selectedIdx).getChallengeId());

            // matchmaking 결과를 DB에 저장
            BattleMatching newBattleMatching = new BattleMatching();
            newBattleMatching.setBlueTeam(currentChallenge);
            newBattleMatching.setRedTeam(opponentChallenge);
            savedBattleMatching = battleMatchingRepository.save(newBattleMatching);
        }

        return Optional.ofNullable(savedBattleMatching);
    }

    @Override
    public void deleteById(Long challengeId) {
        challengesRepository.deleteById(challengeId);
    }
}
