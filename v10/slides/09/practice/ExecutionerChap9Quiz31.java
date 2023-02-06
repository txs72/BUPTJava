import java.util.Random;
import java.util.Scanner;

public class ExecutionerChap9Quiz31 {
    public static final String[] WORDBAND = {"world", "that", "apple"};
    private static boolean f = true;

    public static void main(String[] args) {
        while (f) {
            Scanner scanner = new Scanner(System.in);
            ExecutionerChap9Quiz31 newGame = new ExecutionerChap9Quiz31();
            newGame.game();
            System.out.println("Do you want to guess for another word? Enter y or n");
            String s = scanner.next();
            f = s.equalsIgnoreCase("y");
        }
    }

    public void game() {
        Scanner input = new Scanner(System.in);
        Random r = new Random();
        String realLine = WORDBAND[(r.nextInt(WORDBAND.length))];
        String ansLine = "";
        String myLine = "";
        int err = 0;
        for (int i = 0; i < realLine.length(); i++) {
            ansLine += "*";
        }
        StringBuilder ansLineN = new StringBuilder(ansLine);
        while (true) {
            System.out.print("(Guess)Enter a letter in word " + ansLineN + " >");
            String c = input.next();
            //判断是否猜完了这个单词
            if (myLine.length() == realLine.length()) {
                if (err > 1) {
                    System.out.println("The word is " + myLine + ".  You miss " + err + " times");
                } else {
                    System.out.println("The word is " + myLine + ".  You miss " + err + " time");
                }
                break;
            }
            //判断是否已经输入过这个字符
            if (ansLineN.indexOf(c) >= 0) {
                System.out.println(c + " is already in the word!");
                continue;
            }
            //猜错
            if (!realLine.contains(c)) {
                System.out.println(c + " is not in the word!");
                err++;
                continue;
            }
            //才对，替换猜对的字符
            int i = -1;
            while (i < realLine.length()) {
                i = realLine.indexOf(c, i + 1);
                if (i >= 0) {
                    ansLineN.replace(i, i + 1, c);
                    myLine += c;
                } else
                    break;
            }
            if (myLine.length() == realLine.length()) {
                if (err > 1) {
                    System.out.println("The word is " + myLine + ".  You miss " + err + " times");
                } else {
                    System.out.println("The word is " + myLine + ".  You miss " + err + " time");
                }
                break;
            }
        }
    }
}

