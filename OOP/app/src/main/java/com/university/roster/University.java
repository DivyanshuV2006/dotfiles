package com.university.roster;

public class University {
  public static void main(String[] args) {
    Student student1 = new Student("S101", "Alice Johnson", 3.8);
    Student student2 = new Student("S102", "Bob Williams", 3.5);

    Course course = new Course("CS", 1);

    course.addStudent(student1);
    course.addStudent(student2);

    course.printRoster();

  }
}
