package chapter12;

import java.util.Scanner; 

public class ReadDataWithAutoClose {
  public static void main(String[] args) throws Exception {
    // Create a File instance
    java.io.File file = new java.io.File("scores.txt");

    try (
      // Create a Scanner for the file
      Scanner input = new Scanner(file);
    ) {
      // Read data from a file
      while (input.hasNext()) {
        String firstName = input.next();
        String mi = input.next();
        String lastName = input.next();
        int score = input.nextInt();
        System.out.println(
          firstName + " " + mi + " " + lastName + " " + score);
      }
    }
  }
}
