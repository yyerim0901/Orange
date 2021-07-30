package com.project.orange.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@Getter
@Entity
public class Notifications {

    @Id
    @Column(name = "notification_id")
    private Long notificationId;
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "notification_title")
    private String notificationTitle;
    @Column(name = "notification_content")
    private String notificationContent;

    @Builder
    public Notifications(Long notificationId, Long userId, String notificationTitle, String notificationContent) {
        this.notificationId = notificationId;
        this.userId = userId;
        this.notificationTitle = notificationTitle;
        this.notificationContent = notificationContent;
    }
}
