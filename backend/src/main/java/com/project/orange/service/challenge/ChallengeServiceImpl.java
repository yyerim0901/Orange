package com.project.orange.service.challenge;

import com.project.orange.entity.challenge.BattleMatching;
import com.project.orange.entity.challenge.Challenges;
import com.project.orange.entity.notification.Notifications;
import com.project.orange.entity.user.Users;
import com.project.orange.entity.user.UsersChallenges;
import com.project.orange.repository.challenge.BattleMatchingRepository;
import com.project.orange.repository.challenge.ChallengesRepository;
import com.project.orange.repository.notification.NotificationsRepository;
import com.project.orange.repository.user.UserRepository;
import com.project.orange.repository.user.UsersChallengesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.project.orange.management.Constants.*;

@Service
@Transactional
public class ChallengeServiceImpl implements ChallengeService{

    // field injection (생성자 주입으로 바꾸는게 더 깔끔하다!)
    @Autowired
    private ChallengesRepository challengesRepository;
    @Autowired
    private BattleMatchingRepository battleMatchingRepository;
    @Autowired
    private NotificationsRepository notificationsRepository;
    @Autowired
    private UsersChallengesRepository usersChallengesRepository;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EntityManager entityManager;

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
        // entity manager 를 autowire 로 불러와서 flush 혹은 clear
        Challenges currentChallenge = challengesRepository.save(challenge);
        entityManager.flush(); // DB에 반영 (transaction 마지막에 flush 해줌)
        entityManager.clear(); //
        // Todo : userschallenges에서 이 챌린지 생성한 사용자를 manger 로 등록할 것!!!
        UsersChallenges manager;
        manager = UsersChallenges.builder()
                .user(userRepository.findById(currentChallenge.getManagerId()).get())
                .challenge(currentChallenge)
                .build();

        UsersChallenges currentChallengeManager = usersChallengesRepository.save(manager);

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
            if(each.getChallengeId() != currentChallengeId &&
                    battleMatchingRepository.findByBlueTeamChallengeId(currentChallengeId).isEmpty() &&
                    battleMatchingRepository.findByRedTeamChallengeId(currentChallengeId).isEmpty()){
                matchmakingPool.add(each);
            }
        }

        BattleMatching savedBattleMatching = null;
        if(!matchmakingPool.isEmpty()){
            // matchmaking pool 에서 랜덤으로 Challenge 하나 선택, opponent Challenge 로 선정
            int selectedIdx = (int) (Math.random() * matchmakingPool.size());
            Challenges opponentChallenge;
            opponentChallenge = challengesRepository.findById(matchmakingPool.get(selectedIdx).getChallengeId()).get();
            System.out.println("@#@#@#@#@#@#@#@#@#@#@#@#@#@#@#@#@#@#@#@#@#@#@#@#@#@#@#@#@#@#@#@#@#@#@#@#");
            currentChallenge = challengesRepository.findById(currentChallengeId).get(); // 영속성 컨텍스트 안에 이미 있어서 DB를 거친게 아니고 그냥 있는걸 가져옴
            System.out.println("@#@#@#@#@#@#@#@#@#@#@#@#@#@#@#@#@#@#@#@#@#@#@#@#@#@#@#@#@#@#@#@#@#@#@#@#");
            // matchmaking 결과를 DB에 저장
            BattleMatching newBattleMatching = new BattleMatching();
            newBattleMatching.setBlueTeam(currentChallenge);
            newBattleMatching.setRedTeam(opponentChallenge);
            savedBattleMatching = battleMatchingRepository.save(newBattleMatching);

            // notification 생성을 위해 두 챌린지를 List 에 담음
//            List<List<UsersChallenges>> matchedChallenges = new ArrayList<>();
//            matchedChallenges.add(currentChallenge.getUsersChallengesList());
//            matchedChallenges.add(opponentChallenge.getUsersChallengesList());

            // 생성될 notification 을 담을 List
            List<Notifications> notificationsForChallengeMembers;
            notificationsForChallengeMembers = new ArrayList<>();

            List<Challenges> matchedChallenges = new ArrayList<>();
            matchedChallenges.add(opponentChallenge);
            matchedChallenges.add(currentChallenge);

            System.out.println("@#@#@#@#@#@#@#@#@#@#@#@#@#@#@#@#@#@#@#@#@#@#@#@#@#@#@#@#@#@#@#@#@#@#@#@#");
            System.out.println(currentChallenge.getUsersChallengesList() == null);
            System.out.println(opponentChallenge.getUsersChallengesList() == null);
            System.out.println("@#@#@#@#@#@#@#@#@#@#@#@#@#@#@#@#@#@#@#@#@#@#@#@#@#@#@#@#@#@#@#@#@#@#@#@#");
            System.out.println(opponentChallenge.getUsersChallengesList().toString());
            System.out.println("@#@#@#@#@#@#@#@#@#@#@#@#@#@#@#@#@#@#@#@#@#@#@#@#@#@#@#@#@#@#@#@#@#@#@#@#");

            // 두 챌린지에 소속된 모든 User 에 대한 notification 생성
            // fetch join ??? -> 한번에 받아온다? JPQL ! N+1 문제 ! <<< 면접 단골 ㄷㄷㄷ
            for(Challenges eachChallenge : matchedChallenges){
                List<UsersChallenges> usersChallengesList = eachChallenge.getUsersChallengesList();
                for(UsersChallenges eachUsersChallenges : usersChallengesList){
                    Notifications notification = new Notifications();
                    notification.setUser(eachUsersChallenges.getUser());
                    notification.setNotificationTitle(challengeMatchingAcceptedTitle);
                    notification.setNotificationContent(eachChallenge.getChallengeTitle() +
                                                        challengeMatchingAcceptedContent);

                    notificationsForChallengeMembers.add(notification);
                }
            }

//            for(UsersChallenges uc : currentChallenge.getUsersChallengesList()){
//                Notifications notification = new Notifications();
//                notification.setUser(uc.getUser());
//                notification.setNotificationTitle(challengeMatchingAcceptedTitle);
//                notification.setNotificationContent(currentChallenge.getChallengeTitle() +
//                        challengeMatchingAcceptedContent);
//
//                notificationsForChallengeMembers.add(notification);
//            }
//
//            for(UsersChallenges uc : opponentChallenge.getUsersChallengesList()){
//                Notifications notification = new Notifications();
//                notification.setUser(uc.getUser());
//                notification.setNotificationTitle(challengeMatchingAcceptedTitle);
//                notification.setNotificationContent(opponentChallenge.getChallengeTitle() +
//                        challengeMatchingAcceptedContent);
//
//                notificationsForChallengeMembers.add(notification);
//            }
//
//
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
