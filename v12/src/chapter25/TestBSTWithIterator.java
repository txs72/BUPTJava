package chapter25;

public class TestBSTWithIterator {
  public static void main(String[] args) {
    BST<String> tree = new BST<>();
    tree.insert("George");
    tree.insert("Michael");
    tree.insert("Tom");
    tree.insert("Adam");
    tree.insert("Jones");
    tree.insert("Peter");
    tree.insert("Daniel");
    
    for (String s: tree)
      System.out.print(s.toUpperCase() + " ");
  }
}
