package com.job.repository;

import com.job.entity.JobApplicationEntity;
import com.job.entity.JobPost;
import com.job.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface JobApplicationRepository extends JpaRepository<JobApplicationEntity, Long> {
    List<JobApplicationEntity> findByCandidate(User candidate);
    List<JobApplicationEntity> findByJobPost(JobPost jobPost);
}