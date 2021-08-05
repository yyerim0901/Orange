package com.project.orange.repository.report;

import com.project.orange.entity.report.ReportCategories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportCategoriesRepository extends JpaRepository<ReportCategories, Long> {
}
