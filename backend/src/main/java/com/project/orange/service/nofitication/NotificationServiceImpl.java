package com.project.orange.service.nofitication;

import com.project.orange.entity.notification.Notifications;
import com.project.orange.entity.user.Users;
import com.project.orange.repository.notification.NotificationsRepository;
import com.project.orange.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    private NotificationsRepository notificationsRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Notifications> selectAllByUserId(Long userId) {
        return notificationsRepository.findAllByUserUserId(userId);
    }

    @Override
    public void deleteByNotificationId(Long notificationId) {
        notificationsRepository.deleteById(notificationId);
    }

    @Override
    public Optional<Notifications> sendNotificationTo(Long userId, String title, String content) {
        Notifications notification = new Notifications();
        notification.setUser(userRepository.findByUserId(userId));
        notification.setNotificationTitle(title);
        notification.setNotificationContent(content);

        return Optional.of(notificationsRepository.save(notification));
    }
}
