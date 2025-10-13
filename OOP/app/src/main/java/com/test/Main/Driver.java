package com.test.Main;

import com.test.modules.Triangle;
import com.test.modules.Rectangle;
import com.test.modules.Circle;
import java.util.Scanner;

public class Driver {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int circleCount = 0;
    int triangleCount = 0;
    int rectangleCount = 0;
    double totalCircleArea = 0;
    double totalRectangleArea = 0;
    double totalTriangleArea = 0;
    double totalCirclePerimeter = 0;
    double totalRectanglePerimeter = 0;
    double totalTrianglePerimeter = 0;
    while (true) {
      System.out.println("Enter a shape: ");
      String shape = sc.next().toLowerCase();
      if (shape.equals("exit")) {
        break;
      }
      switch (shape) {

        case "circle":
          double rad = sc.nextDouble();
          Circle c = new Circle(rad);
          System.out.println("Area: " + c.getArea());
          System.out.println("Perimeter: " + c.getPerimeter());
          circleCount++;
          totalCircleArea += c.getArea();
          totalCirclePerimeter += c.getPerimeter();
          break;

        case "triangle":
          double base = sc.nextDouble();
          double height = sc.nextDouble();
          double sideA = sc.nextDouble();
          double sideB = sc.nextDouble();
          double sideC = sc.nextDouble();

          Triangle t = new Triangle(base, height, sideA, sideB, sideC);
          System.out.println("Area: " + t.getArea());
          System.out.println("Perimeter: " + t.getPerimeter());
          triangleCount++;
          totalTriangleArea += t.getArea();
          totalTrianglePerimeter += t.getPerimeter();
          break;

        case "rectangle":
          double length = sc.nextDouble();
          double width = sc.nextDouble();

          Rectangle r = new Rectangle(length, width);
          System.out.println("Area: " + r.getArea());
          System.out.println("Perimeter: " + r.getPerimeter());
          rectangleCount++;
          totalRectangleArea += r.getArea();
          totalRectanglePerimeter += r.getPerimeter();
          break;
      }
    }

    System.out.println("-----Circle-----");
    System.out.println("Total Shapes: " + circleCount);
    System.out.println("Total Area: " + totalCircleArea);
    System.out.println("Total Perimeter: " + totalCirclePerimeter);
    System.out.println();
    System.out.println("-----Rectangle-----");
    System.out.println("Total Shapes: " + rectangleCount);
    System.out.println("Total Area: " + totalRectangleArea);
    System.out.println("Total Perimeter: " + totalRectanglePerimeter);
    System.out.println();
    System.out.println("-----Triangle-----");
    System.out.println("Total Shapes: " + triangleCount);
    System.out.println("Total Area: " + totalTriangleArea);
    System.out.println("Total Perimeter: " + totalTrianglePerimeter);
    System.out.println();
    sc.close();
  }
}
