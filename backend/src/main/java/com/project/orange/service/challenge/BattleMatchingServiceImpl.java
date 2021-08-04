package com.project.orange.service.challenge;

import com.project.orange.entity.challenge.BattleMatching;
import com.project.orange.repository.challenge.BattleMatchingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BattleMatchingServiceImpl implements BattleMatchingService {

    @Autowired
    private BattleMatchingRepository battleMatchingRepository;

    @Override
    public Optional<BattleMatching> selectOne(Long id) {
        return battleMatchingRepository.findById(id);
    }

    @Override
    public List<BattleMatching> selectAll() {
        return battleMatchingRepository.findAll();
    }

    @Override
    public BattleMatching insert(BattleMatching battleMatching) {
        return battleMatchingRepository.save(battleMatching);
    }

    @Override
    public void deleteById(Long id) {
        battleMatchingRepository.deleteById(id);
    }
}
