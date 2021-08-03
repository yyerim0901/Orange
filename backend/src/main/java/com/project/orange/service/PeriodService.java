package com.project.orange.service;

import com.project.orange.entity.challenge.Periods;


import java.util.List;
import java.util.Optional;

public interface PeriodService {
    public Optional<Periods> selectOne(Long challengeId);
    public List<Periods> selectAll();
}
