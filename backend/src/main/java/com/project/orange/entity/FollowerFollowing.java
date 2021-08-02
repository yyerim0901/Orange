package com.project.orange.entity;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@Getter
@Entity
public class FollowerFollowing {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long followId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users fromUser;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users toUser;

    public Long getFollowId() {
        return followId;
    }

    public void setFollowId(Long followId) {
        this.followId = followId;
    }

    public Users getFromUser() {
        return fromUser;
    }

    public void setFromUser(Users fromUser) {
        //기존 관계 제거
        if(this.fromUser != null){
            this.fromUser.getFollowerList().remove(this);
        }
        this.fromUser = fromUser;
        fromUser.getFollowerList().add(this);
    }

    public Users getToUser() {
        return toUser;
    }

    public void setToUser(Users toUser) {
        //기존 관계 제거
        if(this.toUser != null){
            this.toUser.getFollowingList().remove(this);
        }
        this.toUser = toUser;
        toUser.getFollowingList().add(this);
    }

    //Users와 1:N , N:1 관계...

//    @Builder
//    public FollowerFollowing(Long followId, Long from, Long to) {
//        this.followId = followId;
//        this.from = from;
//        this.to = to;
//    }
}
