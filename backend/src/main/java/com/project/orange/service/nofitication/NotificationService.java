package com.project.orange.service.nofitication;

import com.project.orange.entity.notification.Notifications;
import com.project.orange.entity.user.Users;

import java.util.List;
import java.util.Optional;

public interface NotificationService {
    public List<Notifications> selectAllByUserId(Long userId);
    public void deleteByNotificationId(Long notificationId);
    public Optional<Notifications> sendNotificationTo(Long userId, String title, String content);
}
