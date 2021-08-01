package com.project.orange.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@Getter
@Entity
public class ReportCategories {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "report_category_id")
    private Long reportCategoryId;
    @Column(name = "report_category_name")
    private String reportCategoryName;

    @OneToMany(mappedBy = "reportId", fetch = FetchType.LAZY) //하나의 reportCategory는 여러 개의 report를 가진다.
    List<Reports> reportsList = new ArrayList<>();

    public void addReportsList(Reports report){
        reportsList.add(report);
        report.setReportCategories(this);
    }

    @Builder
    public ReportCategories(Long reportCategoryId, String reportCategoryName) {
        this.reportCategoryId = reportCategoryId;
        this.reportCategoryName = reportCategoryName;
    }

    public Long getReportCategoryId() {
        return reportCategoryId;
    }

    public void setReportCategoryId(Long reportCategoryId) {
        this.reportCategoryId = reportCategoryId;
    }

    public String getReportCategoryName() {
        return reportCategoryName;
    }

    public void setReportCategoryName(String reportCategoryName) {
        this.reportCategoryName = reportCategoryName;
    }

    public List<Reports> getReportsList() {
        return reportsList;
    }

    public void setReportsList(List<Reports> reportsList) {
        this.reportsList = reportsList;
    }
}
