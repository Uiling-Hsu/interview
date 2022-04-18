package DailyCodingProblem;

public class SortingInPlace {
    public static char[] sort(char[] input){


        int i = sort(input, 'R', 0);

        sort(input, 'G', i);
        return input;

    }

    public static int sort(char[] input, char c, int s){
        while(s < input.length && input[s]== c){
            s++;
        }
        int k = s;
        while(k < input.length){
            while(k < input.length && input[k] != c){
                k++;
            }
            if(k >= input.length) return s;
            char temp = input[s];
            input[s] = input[k];
            input[k] = temp;
            s++;
        }
        return s;

    }

    public static void main(String[] args){
        char[] input = new char[]{'R','R','B','G','B'};
        System.out.println(SortingInPlace.sort(input));

    }

}
