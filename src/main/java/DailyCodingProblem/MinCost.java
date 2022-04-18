package DailyCodingProblem;

public class MinCost {
    public static int minCostwithoutNeighbor(int[][] cost){
        int[][] min = new  int[cost.length][cost[0].length];
        for(int i = 0; i < min[0].length; i++){
            min[min.length-1][i] = cost[min.length-1][i];
        }
        for(int r = min.length-2; r >= 0; r--){
            for(int c = 0; c < min[0].length; c++){
                int minNext = Integer.MAX_VALUE;
                for(int nc =0; nc <  min[0].length; nc ++){// nc = next row’s col
                    if(nc != c){
                        minNext = min[r+1][nc] < minNext? min[r+1][nc] :minNext;
                    }
                }
                min[r][c] = cost[r][c]+minNext;
            }
        }
        int result = min[0][0];
        for(int i = 0 ; i < min[0].length; i++){
            if(min[0][i] < result){
                result = min[0][i];
            }
        }
        return result;
    }

    public static void main(String[] args){
        int[][] cost = new int[][]{{1,2,3},{2,1,3},{1,2,3}};
        System.out.println(MinCost.minCostwithoutNeighbor(cost));

    }






}
