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
    private Long notifyId;
    @Column(name = "user_id")
    private Long userid;
    @Column(name = "notification_title")
    private String notifyTitle;
    @Column(name = "notification_content")
    private String notifyContent;

    @Builder
    public Notifications(Long notifyId, Long userid, String notifyTitle, String notifyContent) {
        this.notifyId = notifyId;
        this.userid = userid;
        this.notifyTitle = notifyTitle;
        this.notifyContent = notifyContent;
    }
}
