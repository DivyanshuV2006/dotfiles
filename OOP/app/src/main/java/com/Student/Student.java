package com.Student;

import java.util.ArrayList;
import java.util.List;

public class Student extends User {
  public String studentID; // accessible everywhere
  protected List<String> enrolledCourses; // accessible in subclass & package

  public Student() {
    enrolledCourses = new ArrayList<>();
  }

  public void enrollCourse(String courseName) {
    enrolledCourses.add(courseName);
    System.out.println("Student " + name + " enrolled in " + courseName);
  }
}
