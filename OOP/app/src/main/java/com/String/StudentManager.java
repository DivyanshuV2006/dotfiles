package com.String;

import java.util.ArrayList;
import java.util.Collections;

/**
 * StudentManager demonstrates basic ArrayList operations,
 * String methods, escape sequences, and Javadoc usage.
 */
public class StudentManager {

  /**
   * Main method to run the program.
   * 
   * @param args command line arguments
   */
  public static void main(String[] args) {
    // 1. ArrayList Operations
    ArrayList<String> students = new ArrayList<>();
    students.add("Alice");
    students.add("Bob");
    students.add("Charlie");
    students.add("Diana");
    students.add("Ethan");

    // Replace Bob with Frank
    students.set(1, "Frank");

    // Sort alphabetically
    Collections.sort(students);

    // Search for Diana
    System.out.println("Searching for Diana: " + (students.contains("Diana") ? "Found" : "Not Found"));

    // Search for George
    System.out.println("Searching for George: " + (students.contains("George") ? "Found" : "Not Found"));

    // 2. String Methods on Charlie
    String student = "Charlie";
    System.out.println("\nString Methods on " + student + ":");
    System.out.println("Uppercase: " + student.toUpperCase());
    System.out.println("Lowercase: " + student.toLowerCase());
    System.out.println("Length: " + student.length());
    System.out.println("Substring (first 3 letters): " + student.substring(0, 3));

    // 3. Escape Sequences: Display student list as table
    System.out.println("\nStudent List:\n");
    System.out.println("Roll No.\tName");
    for (int i = 0; i < students.size(); i++) {
      System.out.println((i + 1) + "\t\t" + students.get(i));
    }
  }
}
