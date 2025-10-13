package com.university.roster;

public class Course {

  private String courseName;
  private Student[] students;
  private int studentCount;
  private int maxStudents;

  public Course(String courseName, int maxStudents) {
    this.courseName = courseName;
    this.maxStudents = maxStudents;
    students = new Student[this.maxStudents];
  }

  public void addStudent(Student student) {
    if (studentCount >= maxStudents) {
      System.out.println("Course is full. Cannot add " + student.getName());
      return;
    } else {
      students[studentCount] = student;
      studentCount++;
    }
  }

  public void printRoster() {
    System.out.println("Roster for: " + courseName);

    System.out.println("-------------------------");
    for (int i = 0; i < studentCount; i++) {
      students[i].displayInfo();
    }
    System.out.println("-------------------------");
  }
}
