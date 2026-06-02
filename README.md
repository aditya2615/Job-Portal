Job Portal & Recruitment Management System

A full-stack Job Portal application built using Java, Spring Boot, Spring Security, MySQL, HTML, CSS, and JavaScript. The platform connects job seekers and recruiters, allowing recruiters to post jobs and candidates to apply for them through a simple and secure interface.

Features

Candidate Features

User Registration & Login

View Available Jobs

Apply for Jobs

Upload Resume

Track Applications

Manage Profile


Recruiter Features

Recruiter Registration & Login

Create Job Postings

View Posted Jobs

Review Applications

Manage Candidates


Admin Features

User Management

Role-Based Access Control

Application Monitoring


Tech Stack

Backend

Java 17+

Spring Boot

Spring Security

Spring Data JPA

Hibernate


Frontend

HTML5

CSS3

JavaScript


Database

MySQL


Build Tool

Maven


Project Structure

Job-Portal
│
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com.jobportal
│   │   │       ├── controller
│   │   │       ├── service
│   │   │       ├── repository
│   │   │       ├── entity
│   │   │       ├── dto
│   │   │       └── config
│   │   │
│   │   ├── resources
│   │   │   ├── static
│   │   │   ├── templates
│   │   │   └── application.properties
│   │
│   └── test
│
├── pom.xml
└── README.md

Database Configuration

Create a MySQL database:

CREATE DATABASE jobportal_db;

Update application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/jobportal_db
spring.datasource.username=root
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

Installation & Setup

Clone Repository

git clone https://github.com/aditya2615/Job-Portal.git

cd Job-Portal

Build Project

mvn clean install

Run Application

mvn spring-boot:run

Application will start at:

http://localhost:8080

API Endpoints

Authentication

Method	Endpoint	Description

POST	/api/auth/register	Register User
POST	/api/auth/login	Login User
GET	/api/auth/logout	Logout User


Jobs

Method	Endpoint	Description

GET	/api/jobs	Get All Jobs
POST	/api/recruiter/jobs	Create Job
GET	/api/recruiter/jobs	Recruiter Jobs


Applications

Method	Endpoint	Description

POST	/api/applications/apply	Apply Job
GET	/api/applications	View Applications


Security

Spring Security Authentication

Password Encryption using BCrypt

Session-Based Authentication

Role-Based Access Control (Candidate / Recruiter)


Future Enhancements

Email Notifications

Resume Download

Dashboard Analytics

Advanced Job Search

Pagination & Filtering

Interview Scheduling

Admin Dashboard

JWT Authentication

Cloud Deployment


Screenshots

Add screenshots here:

screenshots/
├── home.png
├── login.png
├── candidate-dashboard.png
├── recruiter-dashboard.png
└── applications.png

Author

Aditya Vignesh K

GitHub: [aditya2615](https://github.com/aditya2615?utm_source=chatgpt.com)

License

This project is licensed under the MIT License.


---

If you are a recruiter, you can post jobs and manage applications. If you are a candidate, you can browse opportunities and apply with your resume through a unified recruitment platform.
"# Job-Portal" 
