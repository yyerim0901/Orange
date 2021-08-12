package com.project.orange.repository.user;

import com.project.orange.entity.badge.Badges;
import com.project.orange.entity.user.BadgesUsers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BadgesUsersRepository extends JpaRepository<BadgesUsers, Long> {
    // 뱃지 있는지 검색을 위한 인터페이스
    public List<BadgesUsers> findByUserAndBadge(Long user, Long badge);
}
