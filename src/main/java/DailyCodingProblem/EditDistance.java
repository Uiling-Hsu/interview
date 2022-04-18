package DailyCodingProblem;

public class EditDistance {
    public static int distance(String a, String b){

        int[][] record = new int[a.length()][b.length()];
        int before = 0;
        for(int c = 0; c < b.length(); c++){
            if(a.charAt(0) != b.charAt(c)){
                record[0][c] = before + 1;
            }else{
                record[0][c] = before;
            }
            before = record[0][c];
        }
        before = 0;
        for(int r = 0; r < a.length(); r++){
            if(b.charAt(0) != a.charAt(r)){
                record[r][0] = before+1;
            }else{
                record[r][0] = before;
            }
            before = record[r][0];
        }

        for(int r=1;r<a.length();r++){
            for(int c = 1; c < b.length(); c++){
                if(a.charAt(r) == b.charAt(c)){
                    record[r][c] = record[r-1][c-1];
                }else{
                    // min(record[r-1][c-1]+1, record[r-1][c], record[r][c-1])
                    int min = Math.min(record[r-1][c-1],record[r-1][c]);
                    min = Math.min(min, record[r][c-1]);
                    record[r][c] = min+1;
                }
            }
        }

        return record[a.length()-1][b.length()-1];
    }

    public static void main(String[] args){
        int result = EditDistance.distance("kitten", "sitting");
        System.out.println(result);
    }

}
