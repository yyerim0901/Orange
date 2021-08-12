package com.project.orange.service.user;

import com.project.orange.entity.user.BadgesUsers;
import com.project.orange.repository.user.BadgesUsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.project.orange.management.Constants.HandsInHandsBadgeId;
import static com.project.orange.management.Constants.HereComesANewChallengerBadgeId;

@Service
@Transactional
public class BadgesUsersServiceImpl implements BadgesUsersService{

    @Autowired
    private BadgesUsersRepository badgesUsersRepository;

    @Override
    public List<BadgesUsers> selectAllByUserId(Long user) {
        return badgesUsersRepository.findAllByUser(user);
    }

    @Override
    public Optional<BadgesUsers> badgeAward(Long userId, Long badgeId) {
        List<BadgesUsers> firstTimeChallengeJoin = new ArrayList<>();
        firstTimeChallengeJoin = badgesUsersRepository.findByUserAndBadge(userId, badgeId);

        if(firstTimeChallengeJoin.isEmpty()) {
            BadgesUsers handsInHandsBadge = BadgesUsers.builder()
                    .badge(badgeId)
                    .user(userId)
                    .badgeCount(1)
                    .build();

            return Optional.of(badgesUsersRepository.save(handsInHandsBadge));
        } else {
            return Optional.empty();
        }
    }
}
