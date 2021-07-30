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
    private Long userid;
    @Column(name = "report_category_id")
    private Long reportCatId;
    @Column(name = "report_content")
    private String reportContent;

    @Builder
    public Reports(Long reportId, Long userid, Long reportCatId, String reportContent) {
        this.reportId = reportId;
        this.userid = userid;
        this.reportCatId = reportCatId;
        this.reportContent = reportContent;
    }
}
