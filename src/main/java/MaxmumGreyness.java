public class MaxmumGreyness {
    public static int findMaxmumGreyness(int[][] input){
        int[] colMaxZero = new int[input.length];
        int[] colMaxOne = new int[input.length];
        int[] rolMaxZero = new int[input[0].length];
        int[] rolMaxOne = new int[input[0].length];
        for(int c = 0 ; c< input.length; c++){
            for(int r = 0 ; r< input[0].length ;r++){
                if(input[c][r] == 0){
                    rolMaxZero[r]++;
                    colMaxZero[c]++;
                }
                if(input[c][r] == 1) {
                    rolMaxOne[r]++;
                    colMaxOne[c]++;
                }
            }
        }
        int result = Integer.MIN_VALUE;
        for(int c = 0 ; c< input.length; c++){
            for(int r = 0 ; r< input[0].length ;r++){
                result = Math.max(result,(colMaxOne[c]+rolMaxOne[r]) - (colMaxZero[c]+rolMaxZero[r]));
            }
        }
        return result;
    }

    public static void main(String[] args){
//        int[][] input = new int[][]{{1,0,1,0},{0,1,0,1},{1,0,1,0}};
        int[][] input = new int[][]{{1,0,1},{0,0,1},{1,1,0}};
        System.out.println(MaxmumGreyness.findMaxmumGreyness(input));
    }

}
