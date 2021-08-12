package com.project.orange.service.user;

import com.project.orange.entity.user.BadgesUsers;
import com.project.orange.repository.user.BadgesUsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BadgesUsersServiceImpl implements BadgesUsersService{

    @Autowired
    private BadgesUsersRepository badgesUsersRepository;

    @Override
    public List<BadgesUsers> selectAllByUserId(Long user) {
        return badgesUsersRepository.findAllByUser(user);
    }
}
