package chapter24;

public class MyPriorityQueue<E> {
  private Heap<E> heap; 
  
  public MyPriorityQueue() {
    heap = new Heap<E>();
  }
  
  public MyPriorityQueue(java.util.Comparator<E> c) {
    heap = new Heap<E>(c);
  }
  
  public void enqueue(E newObject) {
    heap.add(newObject);
  }

  public E dequeue() {
    return heap.remove();
  }

  public int getSize() {
    return heap.getSize();
  }
}
