package com.university.roster;

public class Student {
  private String studentId;
  private String name;
  private double gpa;

  public Student(String studentId, String name, double gpa) {
    this.studentId = studentId;
    this.name = name;
    this.gpa = gpa;
  }

  public void displayInfo() {
    System.out.println("Name: " + this.name + ",Id: " + this.studentId + ",GPA: " + this.gpa);
  }

  public String getName() {
    return name;
  }
}
