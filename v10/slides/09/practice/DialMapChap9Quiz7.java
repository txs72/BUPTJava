import java.util.Scanner;

public class DialMapChap9Quiz7 {
    public static final String[] PHONETABLE = {"ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"};

    public static void main(String[] args) {
        System.out.print("Enter a string:");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i))) {
                int n = getNumber(Character.toUpperCase(s.charAt(i)));
                System.out.print(n);
            } else {
                System.out.print(s.charAt(i));
            }
        }
    }

    private static int getNumber(char c) {
        for (int i = 0; i < PHONETABLE.length; i++) {
            if (PHONETABLE[i].contains(String.valueOf(c))) {
                return (i + 2);
            }
        }
        return 0;
    }
}
