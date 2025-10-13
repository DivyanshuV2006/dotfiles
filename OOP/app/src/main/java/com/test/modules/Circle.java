package com.test.modules;

public class Circle {
  private double r;

  public Circle(double r) {
    this.r = r;
  }

  public double getRadius() {
    return r;
  }

  public void setRadius(double r) {
    this.r = r;
  }

  public double getArea() {
    return Math.PI * r * r;
  }

  public double getPerimeter() {
    return 2 * (Math.PI * r);
  }
}
