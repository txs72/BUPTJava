public class MyInteger {
    private int value;

    public MyInteger(int value) {
        this.value = value;
    }

    public int get() {
        return value;
    }

    public boolean isEven() {
        return value % 2 == 0;
    }

    public boolean isOdd() {
        return value % 2 != 0;
    }

    public boolean isPrime() {
        return isPrimeInternal(this.value);
    }

    private static boolean isPrimeInternal(int v) {
        boolean flag = true;
        for (int i = 2; i < v; i++) {
            if (v % i == 0) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    public static boolean isEven(int v) {
        return v % 2 == 0;
    }

    public static boolean isOdd(int v) {
        return v % 2 != 0;
    }

    public static boolean isPrime(int v) {
        return isPrimeInternal(v);
    }

    public static boolean isEven(MyInteger v) {
        return v.isEven();
    }

    public static boolean isOdd(MyInteger v) {
        return v.isOdd();
    }

    public static boolean isPrime(MyInteger v) {
        return v.isPrime();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass())
            return false;
        MyInteger myInteger = (MyInteger) o;
        return value == myInteger.value;
    }

    public boolean equals(int v) {
        return this.equals(new MyInteger(v));
    }

    public boolean equals(MyInteger v) {
        return this.equals((Object) v);
    }

    public static int parseInt(char[] c) {
        int rv = 0;
        for (int i = 0; i < c.length; i++) {
            if (c[i] > '9' || c[i] < '0') {
                return -1;
            }
        }
        for (int i = 0; i < c.length; i++) {
            rv *= 10;
            rv = rv + (c[i] - '0');
        }
        return rv;
    }

    public static int parseInt(String c) {
        int rv = 0;
        for (int i = 0; i < c.length(); i++) {
            if (c.charAt(i) > '9' || c.charAt(i) < '0') {
                return -1;
            }
        }
        for (int i = 0; i < c.length(); i++) {
            rv *= 10;
            rv = rv + (c.charAt(i) - '0');
        }
        return rv;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("MyInteger{");
        sb.append("value=").append(value);
        sb.append('}');
        return sb.toString();
    }
}

