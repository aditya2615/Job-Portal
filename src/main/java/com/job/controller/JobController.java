package com.job.controller;

import com.job.entity.JobPost;
import com.job.entity.User;
import com.job.repository.JobPostRepository;
import com.job.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class JobController {

    private final JobPostRepository jobRepo;
    private final UserRepository userRepo;

    public JobController(JobPostRepository jobRepo,
                         UserRepository userRepo) {
        this.jobRepo = jobRepo;
        this.userRepo = userRepo;
    }

    @GetMapping("/jobs")
    public List<JobPost> allJobs() {
        return jobRepo.findAll();
    }

    @PostMapping("/recruiter/jobs")
    public JobPost addJob(@RequestBody JobPost job,
                          HttpSession session) {

        String username = (String) session.getAttribute("username");

        User recruiter = userRepo.findByUsername(username).orElseThrow();

        job.setRecruiter(recruiter);

        return jobRepo.save(job);
    }

    @GetMapping("/recruiter/jobs")
    public List<JobPost> myJobs(HttpSession session) {

        String username = (String) session.getAttribute("username");

        User recruiter = userRepo.findByUsername(username).orElseThrow();

        return jobRepo.findByRecruiter(recruiter);
    }

    @DeleteMapping("/recruiter/jobs/{id}")
    public String deleteJob(@PathVariable Long id) {
        jobRepo.deleteById(id);
        return "Job deleted successfully";
    }
}