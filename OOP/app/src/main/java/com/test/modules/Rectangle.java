package com.test.modules;

public class Rectangle {
  private double width;
  private double length;

  public Rectangle(double length, double width) {
    this.width = width;
    this.length = length;
  }

  public void setWidth(double width) {
    this.width = width;
  }

  public void setLength(double length) {
    this.length = length;
  }

  public double getWidth() {
    return width;
  }

  public double getLength() {
    return length;
  }

  public double getArea() {
    return length * width;
  }

  public double getPerimeter() {
    return (2 * width) + (2 * length);
  }
}
