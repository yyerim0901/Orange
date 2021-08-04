package com.project.orange.service.challenge;

import com.project.orange.entity.challenge.BattleMatching;
import com.project.orange.entity.challenge.Challenges;
import com.project.orange.entity.notification.Notifications;
import com.project.orange.entity.user.UsersChallenges;
import com.project.orange.repository.challenge.BattleMatchingRepository;
import com.project.orange.repository.challenge.ChallengesRepository;
import com.project.orange.repository.notification.NotificationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.project.orange.management.Constants.*;

@Service
@Transactional
public class ChallengeServiceImpl implements ChallengeService{

    @Autowired
    private ChallengesRepository challengesRepository;
    @Autowired
    private BattleMatchingRepository battleMatchingRepository;
    @Autowired
    private NotificationsRepository notificationsRepository;

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

        // 타이머? 어떻게? -> 스케줄러 ??
        // 멤버 모집 기간 (피드 비활성화) -> battleMatching 에서 ChallengeId 검색
        // 제목/ 소개/ 시작일 -> 날짜/ 남은 일수 -> D-3!/ 남은 인원 : (3/10)

        // 현재 저장한 Challenge 정보
        Long currentChallengeId = currentChallenge.getChallengeId();
        Long currentPeriodId = currentChallenge.getPeriodId();

        // 현재 저장한 Challenge 와 같은 도전 기간을 갖는 Challenge 의 List
        List<Challenges> samePeriodChallengesList = challengesRepository.findAllByPeriodId(currentPeriodId);
        // matching 이 아직 이루어지지 않은 Challenge 를 저장할 List
        List<Challenges> matchmakingPool = new ArrayList<>();

        // BattleMatching 테이블에 존재하지 않는 Challenge 만 선별
        for(Challenges each : samePeriodChallengesList){
            if(battleMatchingRepository.findByBlueTeamChallengeId(currentChallengeId).isEmpty() &&
                    battleMatchingRepository.findByRedTeamChallengeId(currentChallengeId).isEmpty()){
                matchmakingPool.add(each);
            }
        }

        BattleMatching savedBattleMatching = null;
        if(!matchmakingPool.isEmpty()){
            // matchmaking pool 에서 랜덤으로 Challenge 하나 선택, opponent Challenge 로 선정
            int selectedIdx = (int) (Math.random() * matchmakingPool.size());
            Challenges opponentChallenge = challengesRepository.getById(matchmakingPool.get(selectedIdx).getChallengeId());

            // matchmaking 결과를 DB에 저장
            BattleMatching newBattleMatching = new BattleMatching();
            newBattleMatching.setBlueTeam(currentChallenge);
            newBattleMatching.setRedTeam(opponentChallenge);
            savedBattleMatching = battleMatchingRepository.save(newBattleMatching);

            // notification 생성을 위해 두 챌린지를 List 에 담음
            List<Challenges> matchedChallenges = new ArrayList<>();
            matchedChallenges.add(currentChallenge);
            matchedChallenges.add(opponentChallenge);

            // 생성될 notification 을 담을 List
            List<Notifications> notificationsForChallengeMembers = new ArrayList<>();

            // 두 챌린지에 소속된 모든 User 에 대한 notification 생성
            for(Challenges eachChallenge : matchedChallenges){
                for(UsersChallenges eachUsersChallenges : eachChallenge.getUsersChallengesList()){
                    Notifications notification = new Notifications();
                    notification.setUser(eachUsersChallenges.getUser());
                    notification.setNotificationTitle(challengeMatchingAcceptedTitle);
                    notification.setNotificationContent(eachChallenge.getChallengeTitle() +
                                                        challengeMatchingAcceptedContent);

                    notificationsForChallengeMembers.add(notification);
                }
            }

            // 생성한 notification 을 DB에 저장
            notificationsRepository.saveAll(notificationsForChallengeMembers);
        }

        return Optional.ofNullable(savedBattleMatching);
    }

    @Override
    public void deleteById(Long challengeId) {
        challengesRepository.deleteById(challengeId);
    }
}
