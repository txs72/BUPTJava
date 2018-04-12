import java.util.Scanner;

public class Pyramid_Ch4Quiz17 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lines = scanner.nextInt(); // 应该能最大到60000左右
        int i, j, k, len;
        String raw = "", process = "";
        char c;
        final char STARTCHAR = 'A'; // 随便设置一个即可
        int formatLen = ("" + lines).length() + 1;
        String formatStr = "%" + formatLen + "d";
        for (i = 1; i <= lines; i++) {
            for (j = lines; j >= 1; j--) {
                c = (char) (STARTCHAR + j - 1);
                raw += ("" + c); // 生成串的前半部分
            }
            for (j = 2; j <= lines; j++) {
                c = (char) (STARTCHAR + j - 1);
                raw += ("" + c); // 生成串的后半部分
            }
            for (k = i + 1; k <= lines; k++) {
                char r;
                r = (char) (STARTCHAR + k - 1);
                process = raw.replace(r, ' ');
                raw = process;
            }
            for (k = 0; k < raw.length(); k++) { // 格式化输出
                if (raw.charAt(k) == ' ') {
                    for (len = 0; len < formatLen; len++) System.out.print(' ');
                } else System.out.printf(formatStr, raw.charAt(k) - STARTCHAR + 1);
            }
            System.out.println();
            raw = "";
        }
    }
}
