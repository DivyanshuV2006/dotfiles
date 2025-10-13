package com.SepThirty;

// Derived class DeliveryPerson
class DeliveryPerson extends Person {
  private int deliveriesCompleted;
  private double ratePerDelivery;

  // Constructor
  public DeliveryPerson(String name, int age, int deliveriesCompleted, double ratePerDelivery) {
    super(name, age); // Calls Person constructor
    this.deliveriesCompleted = deliveriesCompleted;
    this.ratePerDelivery = ratePerDelivery;
  }

  // Method to calculate salary
  public double calculateSalary() {
    return deliveriesCompleted * ratePerDelivery;
  }

  // Overridden method
  @Override
  public void displayInfo() {
    super.displayInfo(); // Call parent’s displayInfo
    System.out.println("Deliveries Completed: " + deliveriesCompleted);

    // Format salary to 2 decimal places
    System.out.printf("Salary: $%.2f%n", calculateSalary());
  }
}
