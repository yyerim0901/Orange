package com.project.orange.service.nofitication;

import com.project.orange.entity.notification.Notifications;
import com.project.orange.entity.user.Users;
import com.project.orange.repository.notification.NotificationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    private NotificationsRepository notificationsRepository;

    @Override
    public List<Notifications> selectAllByUserId(Long userId) {
        return notificationsRepository.findAllByUserUserId(userId);
    }

    @Override
    public void deleteByNotificationId(Long notificationId) {
        notificationsRepository.deleteById(notificationId);
    }
}
