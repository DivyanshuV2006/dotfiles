package com.ReadAndWrite;

import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String fileName = "output.txt";

    try (FileWriter writer = new FileWriter(fileName)) {
      System.out.println("Enter text (type 'stop' to finish):");
      while (true) {
        String line = sc.nextLine();
        if (line.equalsIgnoreCase("stop")) {
          break;
        }
        writer.write(line + System.lineSeparator());
      }
      System.out.println("\nText successfully written to " + fileName);
    } catch (IOException e) {
      System.out.println("An error occurred while writing to file: " + e.getMessage());
    }

    System.out.println("\n--- Content of the file ---");
    try (FileReader reader = new FileReader(fileName)) {
      int ch;
      while ((ch = reader.read()) != -1) {
        System.out.print((char) ch);
      }
    } catch (IOException e) {
      System.out.println("An error occurred while reading from file: " + e.getMessage());
    }

    sc.close();
  }
}
