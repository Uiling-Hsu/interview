package DailyCodingProblem;

import java.util.ArrayList;
import java.util.List;

public class BreakUp {
    public static List<String> breakUp(String str, int k){
        String[] list = str.split(" ");
        List<String> result = new ArrayList();
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < list.length; ){
            if(list[i].length() > k){
                return null;
            }
            if((sb.length()==0?sb.length():sb.length())+1+list[i].length() <= k){

                (sb.length()==0?sb:sb.append(' ')).append(list[i]);
                i+=1;
            }else{
                result.add(sb.toString());
                sb.setLength(0);
            }
        }
        result.add(sb.toString());
        return result;

    }

    public static void main(String[] args){
        String input = "the quick brown fox jumps over the lazy dog";

        System.out.println(BreakUp.breakUp(input, 10));

    }

}
