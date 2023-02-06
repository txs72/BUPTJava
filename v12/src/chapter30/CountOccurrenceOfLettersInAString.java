package chapter30;

import java.util.*;
import java.util.stream.Stream;
import java.util.stream.Collectors;

public class CountOccurrenceOfLettersInAString {
  private static int count = 0;
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter a string: ");
    String s = input.nextLine();
    
    count = 0; // Reset the count for columns
    System.out.println("The occurrences of each letter are:");
    Stream.of(toCharacterArray(s.toCharArray()))
      .filter(ch -> Character.isLetter(ch))
      .map(ch -> Character.toUpperCase(ch))
      .collect(Collectors.groupingBy(e -> e, 
           TreeMap::new, Collectors.counting()))
         .forEach((k, v) -> { System.out.print(v + " " + k 
              + (++count % 10 == 0 ? "\n" : " "));
         });
  }
  
  public static Character[] toCharacterArray(char[] list) {
    Character[] result = new Character[list.length];
    for (int i = 0; i < result.length; i++) {
      result[i] = list[i];
    }
    return result;
  }
}
