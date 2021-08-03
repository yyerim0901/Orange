package com.project.orange.entity.notification;

import com.project.orange.entity.user.Users;
import lombok.*;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Data
@Entity
//@Table 속성 추가해야되나,,?
public class Notifications {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "notification_id")
    private Long notificationId;
    @Column(name = "notification_title")
    private String notificationTitle;
    @Column(name = "notification_content")
    private String notificationContent;

    @JoinColumn(name = "user_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Users user;
    //이걸... private Users user; 이렇게 바꿔야하는 것 같기도 하고,,만약 바꾸면 notifications의 mappedby도 바꿔야함
    //users 와 notifications에서 주인은 notifications => 주인은 그저 위치 상 name
    //비즈니스 로직의 중요성과는 아무 상관없기에 user가 왜 주인이 아니지? 이런 생각은 잘못된 것
    //주인이 아닌 애가 mappedby 속성을 가져야함
    //보통 일대다 관계에서는 "다"인 애가 주인!

//    @Builder
//    public Notifications(Long notificationId, Long userId, String notificationTitle, String notificationContent) {
//        this.notificationId = notificationId;
//        this.userId = userId;
//        this.notificationTitle = notificationTitle;
//        this.notificationContent = notificationContent;
//    }
}
