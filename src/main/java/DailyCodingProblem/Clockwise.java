package DailyCodingProblem;

public class Clockwise {
    static int[][] directions = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};

    public static void walkClockwise(int[][] matrix, int r, int c, int dindex){
        if (matrix[r][c] == Integer.MAX_VALUE){
            return;
        }
        System.out.println(matrix[r][c]);
        matrix[r][c] = Integer.MAX_VALUE;
        int n_dindex = dindex;
        int[] direction = directions[n_dindex];
        int n_r = r+direction[0];
        int n_c = c+ direction[1];
        if(n_r <0 || n_r >= matrix.length || n_c <0 || n_c >= matrix[0].length || matrix[n_r][n_c] == Integer.MAX_VALUE){
            n_dindex = (dindex+1)%4;
            n_r = r + directions[n_dindex][0];
            n_c = c + directions[n_dindex][1];
        }
        walkClockwise(matrix,n_r,n_c, n_dindex);
    }

    public static void walkClockwise(int[][] matrix){
        walkClockwise(matrix, 0, 0, 0);
    }

    public static void main(String[] args){
        int[][] matric = new int[][]{
                {1,2,3,4,5},
                {6,7,8,9,10},
                {11,12,13,14,15},
                {16,17,18,19,20}};
        Clockwise.walkClockwise(matric);
    }
}
