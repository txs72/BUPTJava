import java.util.Scanner;
public class SSNChap9Quiz1 {
    public static void main(String[] args) {
        String ssn;
        Scanner scanner = new Scanner(System.in);
        ssn = scanner.nextLine();
        if (ssn.length() != 11) {
            System.out.println("Invalid SSN");
            System.exit(-1);
        }
        int checkIndex[] = { 0, 1, 2, 4, 5, 7, 8, 9, 10 };
        boolean valid = true;
        for (int i = 0; i < checkIndex.length; i++) {
            char c = ssn.charAt(checkIndex[i]);
            if (!Character.isDigit(c)) {
                valid = false;
                break;
            }
        }
        if(valid){
            System.out.println("Valid SSN");
        }
        else {
            System.out.println("Invalid SSN");
        }
    }
}
