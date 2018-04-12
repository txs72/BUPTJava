public class ConsecutiveFour_Ch7Quiz19 {
    public static void main(String[] args) {
        int[][] values = {
                {0, 1, 0, 3, 1, 6, 1},
                {0, 1, 3, 1, 1, 0, 1},
                {5, 6, 2, 1, 6, 2, 9},
                {6, 5, 4, 4, 1, 9, 1},
                {1, 6, 6, 1, 9, 3, 1},
                {3, 6, 3, 9, 4, 0, 7},
        };

        if (isConsecutiveFour(values)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }

    public static boolean isConsecutiveFour(int[][] values) {
        boolean hasConsecutiveFour = false;
        for (int i = 0; i < values.length; i++) { // 判断行
            for (int j = 0; j < values[i].length - 3; j++) {
                if (values[i][j] == values[i][j + 1] &&
                        values[i][j + 1] == values[i][j + 2] &&
                        values[i][j + 2] == values[i][j + 3]) {
                    hasConsecutiveFour = true;
                    System.out.println("i=" + i + " j=" + j);
                    return hasConsecutiveFour;
                }
            }
        }
        for (int i = 0; i < values.length - 3; i++) { // 判断列
            for (int j = 0; j < values[i].length; j++) {
                if (values[i][j] == values[i + 1][j] &&
                        values[i][j] == values[i + 2][j] &&
                        values[i][j] == values[i + 3][j]) {
                    hasConsecutiveFour = true;
                    System.out.println("i=" + i + " j=" + j);
                    return hasConsecutiveFour;
                }
            }
        }

        for (int i = 0; i < values.length - 3; i++) { // 判断斜线
            for (int j = 0; j < values[i].length; j++) {
                if(j+3<values[i].length){ // 测试前向斜线
                    if(values[i][j] == values[i+1][j+1] &&
                            values[i][j] == values[i+2][j+2] &&
                            values[i][j] == values[i+3][j+3]){
                        hasConsecutiveFour = true;
                        System.out.println("i=" + i + " j=" + j);
                        return hasConsecutiveFour;
                    }
                }
                if(j>=3) { // 测试反向斜线
                    if(values[i][j] == values[i+1][j-1] &&
                            values[i][j] == values[i+2][j-2] &&
                            values[i][j] == values[i+3][j-3]){
                        hasConsecutiveFour = true;
                        System.out.println("i=" + i + " j=" + j);
                        return hasConsecutiveFour;
                    }
                }
            }
        }
        return hasConsecutiveFour;
    }
}
