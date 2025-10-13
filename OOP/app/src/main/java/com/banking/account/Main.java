package com.banking.account;

class Main {
  public static void main(String[] args) {
    if (args.length == 0) {
      BankAccount a1 = new BankAccount();
      a1.deposit(50);
      a1.withdraw(30);
      System.out.println(a1);
    } else if (args.length == 2) {
      BankAccount a2 = new BankAccount(args[0], Double.parseDouble(args[1]));
      a2.withdraw(10_000);
      System.out.println(a2);
    }
    return;
  }
}
