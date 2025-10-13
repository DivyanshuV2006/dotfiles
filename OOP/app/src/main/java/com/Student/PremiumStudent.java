package com.Student;

public class PremiumStudent extends Student {
  private String subscriptionEndDate; // accessible only inside PremiumStudent

  public void accessPremiumContent() {
    System.out.println("PremiumStudent " + name + " accessed premium content");
  }

  public void setSubscriptionEndDate(String date) {
    this.subscriptionEndDate = date;
  }

  public void showSubscriptionEnd() {
    System.out.println("Subscription ends on: " + subscriptionEndDate);
  }
}
