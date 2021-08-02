package com.project.orange.repository;

import com.project.orange.entity.BadgesUsers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BadgesUsersRepository extends JpaRepository<BadgesUsers, Long> {
}
