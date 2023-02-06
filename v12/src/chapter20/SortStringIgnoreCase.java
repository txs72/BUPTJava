package chapter20;

public class SortStringIgnoreCase {
  public static void main(String[] args) {
    java.util.List<String> cities = java.util.Arrays.asList
      ("Atlanta", "Savannah", "new York", "dallas");
    cities.sort((s1, s2) -> s1.compareToIgnoreCase(s2));

    for (String s: cities) {
      System.out.print(s + " ");
    }
  }
}