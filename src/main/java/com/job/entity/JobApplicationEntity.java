package com.job.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class JobApplicationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String resumeFileName;
    private String status;
    private LocalDateTime appliedAt;

    @ManyToOne
    private User candidate;

    @ManyToOne
    private JobPost jobPost;

    public Long getId() { return id; }
    public String getResumeFileName() { return resumeFileName; }
    public String getStatus() { return status; }
    public LocalDateTime getAppliedAt() { return appliedAt; }
    public User getCandidate() { return candidate; }
    public JobPost getJobPost() { return jobPost; }

    public void setId(Long id) { this.id = id; }
    public void setResumeFileName(String resumeFileName) { this.resumeFileName = resumeFileName; }
    public void setStatus(String status) { this.status = status; }
    public void setAppliedAt(LocalDateTime appliedAt) { this.appliedAt = appliedAt; }
    public void setCandidate(User candidate) { this.candidate = candidate; }
    public void setJobPost(JobPost jobPost) { this.jobPost = jobPost; }
}