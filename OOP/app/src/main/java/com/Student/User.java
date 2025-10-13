package com.Student;

public class User {
  public String name; // accessible everywhere
  protected String email; // accessible in subclasses & same package
  String userID; // default, accessible in same package
  private String password; // private, only in User

  public void login() {
    System.out.println(getClass().getSimpleName() + " " + name + " logged in");
  }

  public void logout() {
    System.out.println(name + " logged out");
  }

  protected String getEmail() {
    return email;
  }

  // setter for password (optional if needed)
  private void setPassword(String password) {
    this.password = password;
  }
}
