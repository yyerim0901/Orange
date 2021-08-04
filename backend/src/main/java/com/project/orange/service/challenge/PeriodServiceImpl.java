package com.project.orange.service.challenge;

import com.project.orange.entity.challenge.Periods;
import com.project.orange.repository.challenge.PeriodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PeriodServiceImpl implements PeriodService {

    @Autowired
    private PeriodsRepository periodsRepository;

    @Override
    public Optional<Periods> selectOne(Long periodId) {
        return periodsRepository.findById(periodId);
    }

    @Override
    public List<Periods> selectAll() {
        return periodsRepository.findAll();
    }
}
