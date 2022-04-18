import java.util.Arrays;
import java.util.PriorityQueue;

public class ClosetPoints {
    public static int[][] findClosetPoint(int[][] points, int x) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<int[]>((int[] a, int[] b) -> {
            int compare = (b[0]*b[0] + b[1]*b[1]) - (a[0]*a[0] + a[1]*a[1]);
            if (compare == 0) {
                return b[0] - a[0];
            }
            return compare;
        });

        //O(k)
        for (int[] point : points) {
            maxHeap.offer(point);
            if (maxHeap.size() > x) {
                maxHeap.poll();
            }
        }
        int[][] result = new int[maxHeap.size()][2];
        for (int i = maxHeap.size() - 1; i >= 0; i--) {
            result[i] = maxHeap.poll();
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] result = ClosetPoints.findClosetPoint(new int[][]{{1, 2}, {3, 4}, {1, -1},{2,1}}, 2);
        for (int[] p : result) {
            System.out.println(Arrays.toString(p));
        }

    }
}
