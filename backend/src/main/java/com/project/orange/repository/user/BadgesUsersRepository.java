package com.project.orange.repository.user;

import com.project.orange.entity.user.BadgesUsers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BadgesUsersRepository extends JpaRepository<BadgesUsers, Long> {
}
