package com.project.orange.entity;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Data
@Entity
public class Reports {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "report_id")
    private Long reportId;
    @Column(name = "report_content")
    private String reportContent;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Users user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reportsList")
    private ReportCategories reportCategories; //얘도 그냥 private ReportsCategories reportCategories; 로 바꿔야할듯

//    @Builder
//    public Reports(Long reportId, Long userId, Long reportCategoryId, String reportContent) {
//        this.reportId = reportId;
//        this.userId = userId;
//        this.reportCategoryId = reportCategoryId;
//        this.reportContent = reportContent;
//    }
}
