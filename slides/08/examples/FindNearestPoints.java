public class FindNearestPoints {
    public static void main(String[] args) {
        double points[][] = {
                {-1, 3}, {-1, -1}, {1, 1}, {2, 0.5},
                {2, -1}, {3, 3}, {4, 2}, {4, -0.5}
        };

        double distance = 0;
        double minDistance = 10000;
        int minIndex1 = -1, minIndex2 = -1;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                distance = Math.sqrt((points[i][0] - points[j][0]) * (points[i][0] - points[j][0]) +
                        (points[i][1] - points[j][1]) * (points[i][1] - points[j][1]));
                if(distance < minDistance) {
                    minDistance = distance;
                    minIndex1 = i;
                    minIndex2 = j;
                }
            }
        }
        System.out.println("Shortest distance = " + minDistance);
        System.out.println("between p[" + points[minIndex1][0] + "," + points[minIndex1][1] + "]");
        System.out.println("    and p[" + points[minIndex2][0] + "," + points[minIndex2][1] + "]");
    }
}
