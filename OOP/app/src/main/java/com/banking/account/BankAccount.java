package com.banking.account;

class BankAccount {
  private String owner;
  private double balance;

  public BankAccount() {
    owner = "Divyanshu Verma";
    balance = 0.0;
  }

  public BankAccount(String owner, double balance) {
    this.balance = balance;
    this.owner = owner;
  }

  public BankAccount(BankAccount bank) {
    this.balance = bank.getBalance();
    this.owner = bank.getOwner();
  }

  public String getOwner() {
    return owner;
  }

  public double getBalance() {
    return balance;
  }

  public void setOwner(String owner) {
    if (owner == null || owner.isEmpty()) {
      System.out.println("Owner cannot be empty.");
      return;
    }
    this.owner = owner;
  }

  public void getBalance(double balance) {
    if (balance < 0) {
      System.out.println("Balance cannot be negative.");
      return;
    }
    this.balance = balance;
  }

  public void deposit(double amount) {
    if (amount < 0) {
      System.out.println("Deposit must be positive.");
      return;
    }
    balance += amount;
  }

  public boolean withdraw(double amount) {
    if (amount > balance) {
      System.out.println("Insufficient Funds.");
      return false;
    }
    if (amount < 0) {
      System.out.println("Amount must be positive.");
      return false;
    }
    balance -= amount;
    return true;
  }

  @Override
  public String toString() {
    return "BankAccount{owner='" + owner + "', balance=" + String.format("%.2f", balance) + "}";
  }
}
