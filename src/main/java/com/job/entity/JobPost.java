package com.job.entity;

import jakarta.persistence.*;

@Entity
public class JobPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String company;
    private String location;
    private String salary;
    private String skills;

    @Column(length = 5000)
    private String description;

    @ManyToOne
    private User recruiter;

    public Long getId() { return id; }
    public String getTitle() { return title; }
    public String getCompany() { return company; }
    public String getLocation() { return location; }
    public String getSalary() { return salary; }
    public String getSkills() { return skills; }
    public String getDescription() { return description; }
    public User getRecruiter() { return recruiter; }

    public void setId(Long id) { this.id = id; }
    public void setTitle(String title) { this.title = title; }
    public void setCompany(String company) { this.company = company; }
    public void setLocation(String location) { this.location = location; }
    public void setSalary(String salary) { this.salary = salary; }
    public void setSkills(String skills) { this.skills = skills; }
    public void setDescription(String description) { this.description = description; }
    public void setRecruiter(User recruiter) { this.recruiter = recruiter; }
}