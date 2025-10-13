package com.SepThirty;

class Person {
  protected String name;
  protected int age;

  // Constructor
  public Person(String name, int age) {
    this.name = name;
    this.age = age;
  }

  // Method to display info
  public void displayInfo() {
    System.out.println("Name: " + name);
    System.out.println("Age: " + age);
  }
}
