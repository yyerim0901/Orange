package com.project.orange.service;

import com.project.orange.entity.challenge.BattleMatching;

import java.util.List;
import java.util.Optional;

public interface BattleMatchingService {
    public Optional<BattleMatching> selectOne(Long id);
    public List<BattleMatching> selectAll();
    public BattleMatching insert(BattleMatching battleMatching);
    public void deleteById(Long id);
}
