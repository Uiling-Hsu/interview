package DailyCodingProblem;

public class WordPass {
    public boolean isExist(char[][] matrix, String s){
        for (int r = 0; r < matrix.length; r++){
            for (int c = 0; c < matrix[0].length; c++){
                if (isExist(matrix, s, r, c)){
                    return true;
                }
            }
        }
        return false;

    }

    public boolean isExist(char[][] matrix, String s, int r, int c){
        if (s.length() == 0) {
            return true;
        }
        if (r >= matrix.length || c >= matrix[0].length){
            return false;
        }
        if (s.charAt(0) == matrix[r][c]){
            return isExist(matrix, s.substring(1,s.length()), r+1, c) ||
            isExist(matrix, s.substring(1,s.length()), r, c+1);

        }
        return false;
    }

    public static void main(String[] args){
        WordPass wordPass = new WordPass();
        char[][] matrix = new char[][]{
                {'F', 'A', 'C', 'I'},
                {'O', 'B', 'Q', 'P'},
                {'A', 'N', 'O', 'B'},
                {'M', 'A', 'S', 'S'}
        };
        String s ="OBQP";

        System.out.println(wordPass.isExist(matrix,s));
    }

}
