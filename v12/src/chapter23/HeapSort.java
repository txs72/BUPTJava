package chapter23;

import java.util.Comparator;

public class HeapSort {
  /** Heap sort method */
  public static <E> void heapSort(E[] list) {
    // Create a Heap of integers
    heapSort(list, (e1, e2) -> ((Comparable<E>)e1).compareTo(e2));
  }
  
  /** Heap sort method */
  public static <E> void heapSort(E[] list, Comparator<E> c) {
    // Create a Heap of integers
    Heap<E> heap = new Heap<>(c);

    // Add elements to the heap
    for (int i = 0; i < list.length; i++)
      heap.add(list[i]);

    // Remove elements from the heap
    for (int i = list.length - 1; i >= 0; i--)
      list[i] = heap.remove();
  }

  /** A test method */
  public static void main(String[] args) {
    Integer[] list = {-44, -5, -3, 3, 3, 1, -4, 0, 1, 2, 4, 5, 53}; 
    heapSort(list);
    for (int i = 0; i < list.length; i++)
      System.out.print(list[i] + " ");
  }
}
