package com.job.repository;

import com.job.entity.JobPost;
import com.job.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface JobPostRepository extends JpaRepository<JobPost, Long> {
    List<JobPost> findByRecruiter(User recruiter);
}