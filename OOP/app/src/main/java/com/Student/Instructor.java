package com.Student;

import java.util.ArrayList;
import java.util.List;

public class Instructor extends User {
  public String instructorID; // accessible everywhere
  protected List<String> coursesTeaching; // accessible in subclass & package

  public Instructor() {
    coursesTeaching = new ArrayList<>();
  }

  public void createCourse(String courseName) {
    coursesTeaching.add(courseName);
    System.out.println("Instructor " + name + " created course: " + courseName);
  }

  public void gradeStudent(String studentName, String courseName) {
    System.out.println("Instructor " + name + " graded " + studentName + " in " + courseName);
  }
}
