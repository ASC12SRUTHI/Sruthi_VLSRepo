CREATE DATABASE VLSDB;
use VLSDB;
create table course(
    courseId int primary key,
    courseName VARCHAR(20),
    authorName VARCHAR(20),
    courseDurationInHours LONG,
    courseAvailability BOOLEAN
);
SELECT * FROM course;