package com.project.orange.service;

import com.project.orange.entity.challenge.BattleMatching;
import com.project.orange.entity.challenge.Challenges;
import com.project.orange.repository.challenge.BattleMatchingRepository;
import com.project.orange.repository.challenge.ChallengesRepository;
import com.project.orange.service.challenge.ChallengeService;
import com.project.orange.service.challenge.PeriodService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ChallengeServiceTest {

    @Autowired
    private ChallengeService challengeService;
    @Autowired
    private PeriodService periodService;

    @Autowired
    private ChallengesRepository challengesRepository;
    @Autowired
    private BattleMatchingRepository battleMatchingRepository;

    @Test
    void registerNewChallengeTest(){
        //given
        Long periodId = 1L;
        Long categoryId = 1L;
        int minMembers = 1;
        int maxMembers = 10;
        int totalPoint = 100;
        int currentMembers = 1;
        LocalDateTime now = LocalDateTime.now();
        int plusDate = periodService.selectOne(periodId).get().getPeriodDays();
        assertEquals(plusDate, 15);
        String profileImagePath = "testPath";

        Long blueTeamManagerId = 1L;
        String blueTeamTitle = "blueTeamTitle";
        String blueTeamDescribe = "blueTeamDescribe";

        Long redTeamManagerId = 2L;
        String redTeamTitle = "redTeamTitle";
        String redTeamDescribe = "redTeamDescribe";

        Challenges blueTeam = Challenges.builder()
                .managerId(blueTeamManagerId)
                .challengeTitle(blueTeamTitle)
                .challengeDescribe(blueTeamDescribe)
                .categoryId(categoryId)
                .periodId(periodId)
                .startDate(now)
                .endDate(now.plusDays(plusDate))
                .totalPoint(totalPoint)
                .minMembers(minMembers)
                .maxMembers(maxMembers)
                .currentMembers(currentMembers)
                .imagePath(profileImagePath)
                .build();

        Challenges redTeam = Challenges.builder()
                .managerId(redTeamManagerId)
                .challengeTitle(redTeamTitle)
                .challengeDescribe(redTeamDescribe)
                .categoryId(categoryId)
                .periodId(periodId)
                .startDate(now)
                .endDate(now.plusDays(plusDate))
                .totalPoint(totalPoint)
                .minMembers(minMembers)
                .maxMembers(maxMembers)
                .currentMembers(currentMembers)
                .imagePath(profileImagePath)
                .build();

        //when
        Optional<BattleMatching> matchMakingResult1 = challengeService.registerNewChallenge(blueTeam);
        assertEquals(matchMakingResult1.isEmpty(), true);

        Optional<BattleMatching> matchMakingResult2 = challengeService.registerNewChallenge(redTeam);
        assertEquals(matchMakingResult2.isPresent(), true);

        //then
//        battleMatchingRepository.deleteAll();
//        challengesRepository.deleteAll();
    }
}
