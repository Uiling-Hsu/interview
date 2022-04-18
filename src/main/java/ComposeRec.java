import java.util.ArrayList;
import java.util.List;

public class ComposeRec {
    public static List compose(int[][] grid) {
        List<List<Integer>> result = new ArrayList();
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                int current = grid[r][c];
                if (current != -1) {
                    List<Integer> temp = new ArrayList();
                    int s = c;
                    while (s < grid[0].length && grid[r][s] == current) {
                        temp.add(current);
                        grid[r][s] = -1;
                        s++;
                    }
                    int length = s - c;
                    for (int i = r + 1; i < grid.length; i++) {
                        List next = isSame(grid, current, i, c, length);
                        if (next != null) {
                            temp.addAll(next);
                            visited(grid, i, c, length);
                        }
                    }
                    result.add(temp);
                }

            }
        }
        return result;
    }

    private static List isSame(int[][] grid, int value, int r, int c, int length) {
        List<Integer> result = new ArrayList();
        for (int i = c; i < c + length; i++) {
            if (grid[r][i] != value) {
                return null;
            }
            result.add(value);
        }
        return result;

    }

    private static void visited(int[][] grid, int r, int c, int length) {
        for (int i = c; i < c + length; i++) {
            grid[r][i] = -1;
        }

    }

    public static void main(String[] arg) {
        int[][] input = new int[][]{
                {1, 2, 2, 3},
                {1, 8, 8, 8},
                {1, 8, 8, 8}
        };

        System.out.println(ComposeRec.compose(input));

    }

}
