package com.project.orange.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@Getter
@Entity
public class Reports {

    @Id
    @Column(name = "report_id")
    private Long reportId;
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "report_category_id")
    private Long reportCategoryId;
    @Column(name = "report_content")
    private String reportContent;

    @Builder
    public Reports(Long reportId, Long userId, Long reportCategoryId, String reportContent) {
        this.reportId = reportId;
        this.userId = userId;
        this.reportCategoryId = reportCategoryId;
        this.reportContent = reportContent;
    }
}
