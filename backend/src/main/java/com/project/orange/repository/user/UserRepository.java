package com.project.orange.repository.user;

import com.project.orange.entity.user.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

//            JpaRepository interface를 상속 받으면 사용할 수 있는 주요 메서드

//            - save(S) : 새로운 엔티티는 저장하고 이미 잇는 엔티티는 수정
//            (식별자 값이 없으면 em.persist(), 있으면 em.merge() 호출)
//            - delete(T) : 엔티티 하나를 삭제 (내부에서 em.remove() 호출)
//            - findOne(ID) : 엔티티 하나를 조회 (내부에서 em.find() 호출)
//            - getOne(ID) : 엔티티를 프록시로 조회 (내부에서 em.getReference() 호출)
//            - findAll(..) : 모든 엔티티를 조회 (sort 또는 pageable 조건을 파라미터로 제공)
//             출처: https://data-make.tistory.com/621 [Data Makes Our Future]
}
