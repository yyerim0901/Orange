package com.project.orange.repository;

import com.project.orange.entity.ReportCat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportCatRepository extends JpaRepository<ReportCat, Long> {
}
