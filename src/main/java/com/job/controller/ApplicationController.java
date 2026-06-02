package com.job.controller;

import com.job.entity.JobApplicationEntity;
import com.job.entity.JobPost;
import com.job.entity.User;
import com.job.repository.JobApplicationRepository;
import com.job.repository.JobPostRepository;
import com.job.repository.UserRepository;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ApplicationController {

    private final JobApplicationRepository appRepo;
    private final JobPostRepository jobRepo;
    private final UserRepository userRepo;
    

    public ApplicationController(JobApplicationRepository appRepo,
                                 JobPostRepository jobRepo,
                                 UserRepository userRepo) {
        this.appRepo = appRepo;
        this.jobRepo = jobRepo;
        this.userRepo = userRepo;
    }

    @PostMapping("/candidate/apply/{jobId}")
    public JobApplicationEntity apply(@PathVariable Long jobId,
                                      @RequestParam("resume") MultipartFile resume,
                                      HttpSession session) throws Exception {

        String username = (String) session.getAttribute("username");

        User candidate = userRepo.findByUsername(username).orElseThrow();
        JobPost job = jobRepo.findById(jobId).orElseThrow();

        String uploadDir = System.getProperty("user.dir") + "/uploads/";

        File dir = new File(uploadDir);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        String fileName = System.currentTimeMillis() + "_" + resume.getOriginalFilename();

        resume.transferTo(new File(uploadDir + fileName));

        JobApplicationEntity application = new JobApplicationEntity();

        application.setCandidate(candidate);
        application.setJobPost(job);
        application.setResumeFileName(fileName);
        application.setStatus("APPLIED");
        application.setAppliedAt(LocalDateTime.now());
        return appRepo.save(application);
    }

    @GetMapping("/candidate/applications")
    public List<JobApplicationEntity> myApplications(HttpSession session) {

        String username = (String) session.getAttribute("username");

        User candidate = userRepo.findByUsername(username).orElseThrow();

        return appRepo.findByCandidate(candidate);
    }

    @GetMapping("/recruiter/applications/{jobId}")
    public List<JobApplicationEntity> applicationsForJob(@PathVariable Long jobId) {

        JobPost job = jobRepo.findById(jobId).orElseThrow();

        return appRepo.findByJobPost(job);
    }

    @PutMapping("/recruiter/applications/{id}/status")
    public JobApplicationEntity updateStatus(@PathVariable Long id,
                                             @RequestParam String status) {

        JobApplicationEntity app = appRepo.findById(id).orElseThrow();

        app.setStatus(status);

        return appRepo.save(app);
    }
}