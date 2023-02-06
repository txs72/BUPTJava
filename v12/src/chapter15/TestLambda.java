package chapter15;

public class TestLambda {
  public static void main(String[] args) {
    TestLambda test = new TestLambda();
    test.setAction1(() -> System.out.print("Action 1! "));
    test.setAction2(e -> System.out.print(e + " "));
    System.out.println(test.getValue((e1, e2) -> e1 + e2));
  }

  public void setAction1(T1 t) {
    t.m1();
  }
  
  public void setAction2(T2 t) {
    t.m2(4.5);
  }
  
  public int getValue(T3 t) {
    return t.m3(5, 2);
  }
}

@FunctionalInterface
interface T1 {
  public void m1();
}

@FunctionalInterface
interface T2 {
  public void m2(Double d);
}

@FunctionalInterface
interface T3 {
  public int m3(int d1, int d2);
}
