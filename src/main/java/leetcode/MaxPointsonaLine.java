package leetcode;

/**
 * Created by Administrator on 14-10-26.
 */
public class MaxPointsonaLine {
    static class Point {
        int x;
        int y;

        Point() {
            x = 0;
            y = 0;
        }

        Point(int a, int b) {
            x = a;
            y = b;
        }
    }

    public int maxPoints(Point[] points) {
        int result = 2;
        int flag = 0;
        if (points.length < 3) {
            return points.length;
        }
        if (allTheSame(points)) {
            return points.length;
        }
        for (int i = 0; i < points.length - 1; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int x1 =  points[i].x;
                int y1 =  points[i].y;
                int x2 =  points[j].x;
                int y2 =  points[j].y;
                if (x1 == x2 && y1 == y2) {
                    continue;
                }
                int m = 0;
                for (int r = 0; r < points.length; r++) {
                    int x3 = points[r].x;
                    int y3 = points[r].y;
                    if((y3-y2)*(x2-x1) == (y2-y1)*(x3-x2)) {
                        m++;
                    }
                }
                if (m > points.length / 2) {
                    return m;
                }
                if (m > result) {
                    result = m;
                }
            }
        }
        return result;
    }

    private boolean allTheSame(Point[] points) {
        for (int i = 0; i < points.length; i++) {
            if (points[i].x != points[0].x || points[i].y != points[0].y) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Point[] points = {new Point(3, 10), new Point(0, 2), new Point(0, 2), new Point(3, 10)};
        MaxPointsonaLine maxPointsonaLine = new MaxPointsonaLine();
        int result = maxPointsonaLine.maxPoints(points);
        System.out.println(result);
    }
}
