package com.project.orange.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@Getter
@Entity
public class ReportCategories {

    @Id
    @Column(name = "report_category_id")
    private Long reportCategoryId;
    @Column(name = "report_category_name")
    private String reportCategoryName;

    @Builder
    public ReportCategories(Long reportCategoryId, String reportCategoryName) {
        this.reportCategoryId = reportCategoryId;
        this.reportCategoryName = reportCategoryName;
    }
}
