package com.project.orange.entity;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@Getter
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

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {

        //기존 관계 제거
        if(this.user != null){
            this.user.getReportsList().remove(this);
        }
        this.user = user;
        user.getReportsList().add(this);
    }

    public ReportCategories getReportCategories() {
        return reportCategories;
    }

    public void setReportCategories(ReportCategories reportCategories) {

        //기존 관계 제거
        if(this.reportCategories != null) {
            this.reportCategories.getReportsList().remove(this);
        }
        this.reportCategories = reportCategories;
        reportCategories.getReportsList().add(this);
    }

    public Long getReportId() {
        return reportId;
    }

    public void setReportId(Long reportId) {
        this.reportId = reportId;
    }

    public String getReportContent() {
        return reportContent;
    }

    public void setReportContent(String reportContent) {
        this.reportContent = reportContent;
    }


}
