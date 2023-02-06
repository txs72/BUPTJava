import java.util.Scanner;

public class MeiHuaPing_Ch6Quiz21 {
    public static void main(String[] args) {
        int drops;
        int slots;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of balls to drop: ");
        drops = scanner.nextInt();
        System.out.print("Enter the number of slots in the bean machine: ");
        slots = scanner.nextInt();

        double position;
        int calc[] = new int[slots];
        for (int i = 0; i < slots; i++) {
            calc[i] = 0;
        }

        for (int i = 0; i < drops; i++) { // 模拟掉落过程
            position = slots / 2.0;
            for (int j = 0; j < slots - 1; j++) {
                if (Math.random() < 0.5) {
                    position -= 0.5;
                    System.out.print('L');
                } else {
                    position += 0.5;
                    System.out.print('R');
                }
            }
            System.out.println();
            calc[(int) position]++;
        }
        for (int j = drops; j > 0; j--) {
            boolean hasValueValue = false;
            for (int i = 0; i < slots; i++) { // 限制输出显示的总高度
                if (calc[i] >= j) hasValueValue = true;
            }
            if (hasValueValue == true) {
                for (int i = 0; i < slots; i++) { // 将数组竖过来输出
                    if (calc[i] >= j) System.out.print('O');
                    else System.out.print('.');
                }
                System.out.println();
            }
        }
        System.out.println();
        for (int i = 0; i < slots; i++) {
            System.out.println("slots[" + i + "] = " + calc[i]);
        }
    }

}
