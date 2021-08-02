package com.project.orange.entity;

import com.project.orange.repository.PeriodsRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class PeriodsTest {

    @Autowired
    private PeriodsRepository periodsRepository;

    @Test
    void save(){
        //given
        String periodName = "1개월";
        int periodDays = 30;
        Periods period = new Periods();
        period.setPeriodName(periodName);
        period.setPeriodDays(periodDays);

        //when
        Periods savedPeriod = periodsRepository.save(period);

        //then
        assertEquals(periodName, savedPeriod.getPeriodName());
    }
}
