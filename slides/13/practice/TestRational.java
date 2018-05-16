import java.math.BigInteger;

public class TestRational {
    /**
     * Main method
     */
    public static void main(String[] args) {
        // Create and initialize two rational numbers r1 and r2.
        RationalChap14Quiz19 r1 = new RationalChap14Quiz19(new BigInteger("4"), new BigInteger("233"));
        RationalChap14Quiz19 r2 = new RationalChap14Quiz19(new BigInteger("2"), new BigInteger("454"));

        // Display results
        System.out.println(r1 + " + " + r2 + " = " + r1.add(r2));
        System.out.println(r1 + " - " + r2 + " = " + r1.subtract(r2));
        System.out.println(r1 + " * " + r2 + " = " + r1.multiply(r2));
        System.out.println(r1 + " / " + r2 + " = " + r1.divide(r2));
        System.out.println(r2 + " is " + r2.doubleValue());
        System.out.println();

        RationalChap14Quiz19 rational = new RationalChap14Quiz19(new BigInteger("0"), new BigInteger("1"));
        for (int i = 2; i <= 100; i++) {
            rational = rational.add(new RationalChap14Quiz19(new BigInteger("" + (i - 1)),
                    new BigInteger("" + i)));
            //System.out.println("added " + (i-1) + "/" + i + " = " + rational);
        }
        System.out.println("Final result: " + rational);
        System.out.println("Double value: " + rational.doubleValue());
    }
}
