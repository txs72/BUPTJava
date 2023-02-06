package chapter21;

import chapter13.GeometricObject;
import chapter13.Circle;
import chapter13.Rectangle;
import chapter20.GeometricObjectComparator;
import java.util.*;

public class TestTreeSetWithComparator {
  public static void main(String[] args) {
    // Create a tree set for geometric objects using a comparator
    Set<GeometricObject> set =
      new TreeSet<>(new GeometricObjectComparator());
    set.add(new Rectangle(4, 5));
    set.add(new Circle(40));
    set.add(new Circle(40));
    set.add(new Rectangle(4, 1));

    // Display geometric objects in the tree set
    System.out.println("A sorted set of geometric objects");
    for (GeometricObject element: set)
      System.out.println("area = " + element.getArea());
  }
}
