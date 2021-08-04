package com.project.orange.repository.notification;

import com.project.orange.entity.notification.Notifications;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationsRepository extends JpaRepository<Notifications, Long> {
    public List<Notifications> findAllByUserUserId(Long userid);
}
