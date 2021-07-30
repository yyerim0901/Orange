package com.project.orange.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@Getter
@Entity
public class ReportCat {

    @Id
    @Column(name = "report_category_id")
    private Long reportCatId;
    @Column(name = "report_category_name")
    private String reportCatName;

    @Builder
    public ReportCat(Long reportCatId, String reportCatName) {
        this.reportCatId = reportCatId;
        this.reportCatName = reportCatName;
    }
}
