package DailyCodingProblem;

public class Path {
    public static int count(int steps, int[] climbs){
        if(steps == 0) return 1;
        int[] result = new int[steps+1];
        result[0] = 1;
        for(int i = 1; i< result.length; i++){
            int count = 0;
            for(int climb: climbs){
                if(i-climb>=0){
                    count += result[i-climb];
                }
            }
            result[i] = count;
        }
        return result[steps];
    }



    public static void main(String[] args){
        System.out.println(Path.count(5,new int[]{1,3,5}));
    }
}
