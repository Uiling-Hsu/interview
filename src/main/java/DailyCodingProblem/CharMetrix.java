package DailyCodingProblem;

public class CharMetrix {
    public static int count(char[][] input){
        int count = 0;
        for(int c = 0; c < input[0].length; c++){
            for(int r = 1; r< input.length; r++){
                if(input[r][c] < input[r-1][c]){
                    count+=1;
                    break;
                }
            }
        }
        return count;
    }

    public static void main(String[] args){
//        char[][] input = new char[][]{{'c','b','a'},{'d','a','f'},{'g','h','i'}};
//        char[][] input = new char[][]{{'c','b','a','d'}};
        char[][] input = new char[][]{{'z','y','x'},{'w','v','u'},{'t','s','r'}};
        int result = CharMetrix.count(input);
        System.out.println(result);
    }
}
