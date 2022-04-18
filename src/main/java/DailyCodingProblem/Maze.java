package DailyCodingProblem;

import java.util.LinkedList;
import java.util.Queue;

public class Maze {
    int[][] direction = new int[][]{{1, 0}, {0, 1}, {0, -1}, {-1, 0}};

    int result = Integer.MAX_VALUE;

    public int countStep(boolean[][] board, int[] start, int[] end) {
        board[start[0]][start[1]] = true;
        dfs(board, start, end, 0);
//        return result;
        return bfs(board,start,end);


    }

    public void dfs(boolean[][] board, int[] start, int[] end, int tempCount) {
        if (start[0] == end[0] && start[1] == end[1]) {
            result = result > tempCount ? tempCount:result;
        }
        for (int[] d : direction) {
            int[] next = new int[]{start[0] + d[0], start[1] + d[1]};
            if (next[0] >= 0 && next[0] < board.length && next[1] >= 0 && next[1] < board[0].length && !board[next[0]][next[1]]) {
                board[next[0]][next[1]] = true;
                dfs(board, next, end, tempCount + 1);
                board[next[0]][next[1]] = false;

            }
        }
    }

    public int bfs(boolean[][] board, int[] start, int[] end){
        Queue<int[]> q = new LinkedList();
        q.add(start);
        int distance = 0;
        while(q.size()!=0) {
            int levelSize = q.size();
            distance++;// min distance from start
            for(int i =0; i< levelSize; i++) {
                int[] current = q.poll();
                board[current[0]][current[1]] = true;
                for (int[] d : direction) {
                    int[] adj = new int[]{current[0]+d[0],current[1]+d[1]};
                    if(isValid(adj, board)){
                        if(adj[0] == end[0] && adj[1] == end[1]){
                            return distance;
                        }
                        q.add(adj);
                    }
                }
            }
        }
        return -1;

    }

    public boolean isValid(int[] point, boolean[][] board) {
        if (point[0] < 0 || point[0] >= board.length || point[1] < 0 || point[1] >= board[0].length || board[point[0]][point[1]]) {
            return false;
        }
        return true;
    }


    public static void main(String[] args) {
        Maze maze = new Maze();
        boolean[][] board = new boolean[][]{
                {false, false, false, false},
                {true, true, false, true},
                {false, false, false, false},
                {false, false, false, false}
        };
        int[] start = new int[]{3, 0};
        int[] end = new int[]{1, 0};
        System.out.println(maze.countStep(board, start, end));
    }

}
