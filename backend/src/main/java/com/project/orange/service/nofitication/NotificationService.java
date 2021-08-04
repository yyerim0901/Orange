package com.project.orange.service.nofitication;

import com.project.orange.entity.notification.Notifications;
import com.project.orange.entity.user.Users;

import java.util.List;

public interface NotificationService {
    public List<Notifications> selectAllByUserId(Long userId);
    public void deleteByNotificationId(Long notificationId);
}
