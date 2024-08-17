# Student Management System

Welcome to the Student Management System, a simple Java-based command-line application for managing student records.

# Overview

The Student Management System is a command-line application that allows users to perform various actions related to student data management. It includes the following functionalities:

Add Student: Add a new student by providing their name, and mobile number.

Display Student: View a list of all students currently stored in the system.

Search Student: Search an individual student currently stored in the system.

Exit: Quit the application when done.


## ==== Software And Tools Required ====

* MySQL
* Netbeans
* Java [JDK 8+]


## ======= Dummy Database Initialization ==========

STEP 1: Open MySQL Command Prompt or MySQL Workbench

STEP 2: Login to the administrator user as : mysql -u <username> -p (Enter Password if asked)

STEP 3 :Copy paste the following MySql Commands:


```
create database studentmanagementsystem;

show databases;

use studentmanagementsystem;

create table student(name varchar(40), fname varchar(40) , rollno varchar(20), dob varchar(40), address varchar(100), phone varchar(20), email varchar(40),  x varchar(20), xii varchar(20), aadhar varchar(20), course varchar(40), branch varchar(40));

select * from student;
```

Thank you for using the Student Management System. If you have any questions or suggestions, please feel free to reach out.
Have a great day!
