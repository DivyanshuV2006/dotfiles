// Divyanshu Verma, Aidan da Costa

package com.project1;

import java.util.Scanner;

public class GroceryList {
  // Arrays to store the grocery items and their check-off status
  private static String[] itemArray = new String[50];
  private static boolean[] checkOffArray = new boolean[50];
  private static int numberOfItemsInList = 0;
  private static Scanner scanner = new Scanner(System.in);

  // Main method - runs the grocery list program
  public static void main(String[] args) {
    System.out.println("Welcome to Grocery List Management!");

    boolean running = true;

    // Keep the program running until user exits
    while (running) {
      displayMenu();

      // Get user's menu choice
      if (scanner.hasNextInt()) {
        int choice = scanner.nextInt();
        scanner.nextLine(); // Clear the newline character

        // Process the user's choice
        switch (choice) {
          case 1:
            addItem();
            break;
          case 2:
            removeItem();
            break;
          case 3:
            checkOffItem();
            break;
          case 4:
            printList();
            break;
          case 5:
            exitProgram();
            running = false;
            break;
          default:
            System.out.println("Invalid option. Please enter a number between 1 and 5.");
        }
      } else {
        System.out.println("Invalid input. Please enter a number.");
        scanner.nextLine(); // Clear invalid input
      }

      System.out.println(); // Add blank line for readability
    }
  }

  // Shows the menu options to the user
  private static void displayMenu() {
    System.out.println("\n========== MENU ==========");
    System.out.println("1. Add Item to your Grocery List");
    System.out.println("2. Remove Item from your Grocery List");
    System.out.println("3. \"Check Off\" an Item from your Grocery List");
    System.out.println("4. Display your Grocery List");
    System.out.println("5. Exit");
    System.out.print("Please enter the number of an option above: ");
  }

  // Adds a new item to the list
  private static void addItem() {
    System.out.print("Enter the name of the item to add: ");
    String itemName = scanner.nextLine().trim();

    // Check if item name is empty
    if (itemName.isEmpty()) {
      System.out.println("Item name cannot be empty.");
      return;
    }

    // Check if the item already exists
    int existingIndex = findItemIndex(itemName);

    if (existingIndex != -1) {
      System.out.println("This item already exists in the list.");
    } else {
      // Add the item to the end of the list
      itemArray[numberOfItemsInList] = itemName;
      checkOffArray[numberOfItemsInList] = false; // Not checked off by default
      numberOfItemsInList++;
      System.out.println("\"" + itemName + "\" has been added to your grocery list.");
    }
  }

  // Removes an item from the list
  private static void removeItem() {
    if (numberOfItemsInList == 0) {
      System.out.println("Your grocery list is empty.");
      return;
    }

    System.out.print("Enter the name or number of the item to remove: ");
    String input = scanner.nextLine().trim();

    int indexToRemove = -1;

    // Check if input is a number
    try {
      int itemNumber = Integer.parseInt(input);
      // Convert item number to array index
      if (itemNumber >= 1 && itemNumber <= numberOfItemsInList) {
        indexToRemove = itemNumber - 1;
      }
    } catch (NumberFormatException e) {
      // Input is not a number, search by name
      indexToRemove = findItemIndex(input);
    }

    // Remove the item if found
    if (indexToRemove != -1) {
      String removedItem = itemArray[indexToRemove];

      // Move all items after the removed item to the left
      for (int i = indexToRemove; i < numberOfItemsInList - 1; i++) {
        itemArray[i] = itemArray[i + 1];
        checkOffArray[i] = checkOffArray[i + 1];
      }

      numberOfItemsInList--;
      System.out.println("\"" + removedItem + "\" has been removed from your grocery list.");
    } else {
      System.out.println("Item/number doesn't exist in the list.");
    }
  }

  // Marks an item as checked off
  private static void checkOffItem() {
    if (numberOfItemsInList == 0) {
      System.out.println("Your grocery list is empty.");
      return;
    }

    System.out.print("Enter the name or number of the item to check off: ");
    String input = scanner.nextLine().trim();

    int indexToCheckOff = -1;

    // Check if input is a number
    try {
      int itemNumber = Integer.parseInt(input);
      // Convert item number to array index
      if (itemNumber >= 1 && itemNumber <= numberOfItemsInList) {
        indexToCheckOff = itemNumber - 1;
      }
    } catch (NumberFormatException e) {
      // Input is not a number, search by name
      indexToCheckOff = findItemIndex(input);
    }

    // Check off the item if found
    if (indexToCheckOff != -1) {
      if (checkOffArray[indexToCheckOff]) {
        System.out.println("\"" + itemArray[indexToCheckOff] + "\" is already checked off.");
      } else {
        checkOffArray[indexToCheckOff] = true;
        System.out.println("\"" + itemArray[indexToCheckOff] + "\" has been checked off.");
      }
    } else {
      System.out.println("Item/number doesn't exist in the list.");
    }
  }

  // Prints the current grocery list
  private static void printList() {
    if (numberOfItemsInList == 0) {
      System.out.println("Your grocery list is empty.");
      return;
    }

    System.out.println("\n===== Your Grocery List =====");
    for (int i = 0; i < numberOfItemsInList; i++) {
      // Display item number, check mark or dash, and item name
      String checkMark = checkOffArray[i] ? "x" : "-";
      System.out.println((i + 1) + ". " + checkMark + " " + itemArray[i]);
    }
  }

  // Prints the final list and exits the program
  private static void exitProgram() {
    System.out.println("\n===== Final Grocery List =====");

    if (numberOfItemsInList == 0) {
      System.out.println("Your grocery list is empty.");
    } else {
      for (int i = 0; i < numberOfItemsInList; i++) {
        String checkMark = checkOffArray[i] ? "x" : "-";
        System.out.println((i + 1) + ". " + checkMark + " " + itemArray[i]);
      }
    }

    System.out.println("\nThank you for using Grocery List Management. Goodbye!");
    scanner.close();
  }

  // Helper method to find an item in the array
  // Returns the index if found, -1 if not found
  private static int findItemIndex(String itemName) {
    for (int i = 0; i < numberOfItemsInList; i++) {
      // Use equalsIgnoreCase for case-insensitive comparison
      if (itemArray[i].equalsIgnoreCase(itemName)) {
        return i;
      }
    }
    return -1; // Item not found
  }
}
