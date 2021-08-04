package com.project.orange.service.report;

import com.project.orange.entity.report.ReportCategories;
import com.project.orange.entity.report.Reports;
import com.project.orange.repository.report.ReportCategoriesRepository;
import com.project.orange.repository.report.ReportsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ReportServiceImpl implements ReportService{

    @Autowired
    private ReportsRepository reportsRepository;
    @Autowired
    private ReportCategoriesRepository reportCategoriesRepository;

    @Override
    public List<Reports> selectAll() {
        return reportsRepository.findAll();
    }

    @Override
    public List<Reports> selectAllByReportCategory(Long reportCategoryId) {

        List<Reports> reports = null;

        Optional<ReportCategories> reportCategory = reportCategoriesRepository.findById(reportCategoryId);
        if(reportCategory.isPresent()){
            reports = reportCategory.get().getReportsList();
        }
        return reports;
    }

    @Override
    public Reports insert(Reports reports) {
        return reportsRepository.save(reports);
    }
}
