package com.project.orange.service.report;

import com.project.orange.entity.report.Reports;

import java.util.List;

public interface ReportService {
    public List<Reports> selectAll();
    public List<Reports> selectAllByReportCategory(Long reportCategoryId);
    public Reports insert(Reports reports);
}
