import java.math.BigDecimal;
import java.math.BigInteger;

public class RationalChap14Quiz19 extends Number implements Comparable<RationalChap14Quiz19> {
    // Data fields for numerator and denominator
    private BigInteger numerator = new BigInteger("0");
    private BigInteger denominator = new BigInteger("1");

    /**
     * Construct a rational with default properties
     */
    public RationalChap14Quiz19() {
        this(new BigInteger("0"), new BigInteger("1"));
    }

    /**
     * Construct a rational with specified numerator and denominator
     */
    public RationalChap14Quiz19(BigInteger numerator, BigInteger denominator) {
        BigInteger gcd = gcd1(numerator, denominator);
        this.numerator = ((denominator.compareTo(new BigInteger("0")) >= 0) ?
                new BigInteger("1") : new BigInteger("-1"))
                .multiply(numerator).divide(gcd);
        this.denominator = denominator.divide(gcd);
    }

    /**
     * Find GCD of two numbers
     */
    private static BigInteger gcd(BigInteger n, BigInteger d) {
        BigInteger n1 = n.abs();
        BigInteger n2 = d.abs();

        BigInteger gcd = new BigInteger("1");
        BigInteger k;
        for (k = new BigInteger("1"); k.compareTo(n1) <= 0
                && k.compareTo(n2) <= 0; k = k.add(new BigInteger("1"))) {
            if (n1.mod(k).equals(new BigInteger("0"))
                    && n2.mod(k).equals(new BigInteger("0")))
            gcd = k;
        }
        return gcd;
    }

    private static BigInteger gcd1(BigInteger n, BigInteger d) {
        BigInteger n1 = n.abs();
        BigInteger n2 = d.abs();
        BigInteger temp;
        if(n1.equals(new BigInteger("0"))){ // 分子为0， 直接返回1即可
            return  new BigInteger("1");
        }
        if(n1.compareTo(n2) <= 0) { // 确保n1 > n2
            temp = n1;
            n1 = n2;
            n2 = temp;
        }

        temp = n1.mod(n2);
        while(!temp.equals(new BigInteger("0"))){
            n1 = n2;
            n2 = temp;
            temp = n1.mod(n2);
        }
        return n2;
    }

    /**
     * Return numerator
     */
    public BigInteger getNumerator() {
        return numerator;
    }

    /**
     * Return denominator
     */
    public BigInteger getDenominator() {
        return denominator;
    }

    /**
     * Add a rational number to this rational
     */
    public RationalChap14Quiz19 add(RationalChap14Quiz19 secondRational) {
        BigInteger n = numerator.multiply(secondRational.getDenominator()).add(
                denominator.multiply(secondRational.getNumerator()));
        BigInteger d = denominator.multiply(secondRational.getDenominator());
        return new RationalChap14Quiz19(n, d);
    }

    /**
     * Subtract a rational number from this rational
     */
    public RationalChap14Quiz19 subtract(RationalChap14Quiz19 secondRational) {
        BigInteger n = numerator.multiply(secondRational.getDenominator())
                .subtract(denominator.multiply(secondRational.getNumerator()));
        BigInteger d = denominator.multiply(secondRational.getDenominator());
        return new RationalChap14Quiz19(n, d);
    }

    /**
     * Multiply a rational number to this rational
     */
    public RationalChap14Quiz19 multiply(RationalChap14Quiz19 secondRational) {
        BigInteger n = numerator.multiply(secondRational.getNumerator());
        BigInteger d = denominator.multiply(secondRational.getDenominator());
        return new RationalChap14Quiz19(n, d);
    }

    /**
     * Divide a rational number from this rational
     */
    public RationalChap14Quiz19 divide(RationalChap14Quiz19 secondRational) {
        BigInteger n = numerator.multiply(secondRational.getDenominator());
        BigInteger d = denominator.multiply(secondRational.numerator);
        return new RationalChap14Quiz19(n, d);
    }

    @Override
    public String toString() {
        if (denominator.equals(new BigInteger("1")))
            return numerator + "";
        else
            return numerator + "/" + denominator;
    }

    @Override // Override the equals method in the Object class
    public boolean equals(Object other) {
        if ((this.subtract((RationalChap14Quiz19) (other))).getNumerator()
                .equals(new BigInteger("0")))
            return true;
        else
            return false;
    }

    @Override // Implement the abstract intValue method in Number
    public int intValue() {
        return (int) doubleValue();
    }

    @Override // Implement the abstract floatValue method in Number
    public float floatValue() {
        return (float) doubleValue();
    }

    @Override // Implement the doubleValue method in Number
    public double doubleValue() {
        return (new BigDecimal(numerator)
                .divide(new BigDecimal(denominator), 25, BigDecimal.ROUND_HALF_UP))
                .doubleValue();
    }

    @Override // Implement the abstract longValue method in Number
    public long longValue() {
        return (long) doubleValue();
    }

    @Override // Implement the compareTo method in Comparable
    public int compareTo(RationalChap14Quiz19 o) {
        if (this.subtract(o).getNumerator().compareTo(new BigInteger("0")) > 0)
            return 1;
        else if (this.subtract(o).getNumerator().compareTo(new BigInteger("0")) <= 0)
            return -1;
        else
            return 0;
    }
}