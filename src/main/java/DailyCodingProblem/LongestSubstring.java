package DailyCodingProblem;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstring {
    public static String longSubstringWithKDist(String input, int k){
        Map<Character,Integer> record = new HashMap();
        int i =0, j = 0;
        String result = "";
        while(i < input.length() && j < input.length()){
            record.put(input.charAt(j),j);
            if(record.size()>k){
                int index = record.get(input.charAt(i));
                record.remove(input.charAt(i));
                i = index+1;
            }
            if(j-i+1>=2 && j-i+1 > result.length()){
                result = input.substring(i,j+1);
            }
            j++;
        }
        return result;
    }

    public static void main(String[] args){
        String input = "abcddef";
        String result = LongestSubstring.longSubstringWithKDist(input,3);
        System.out.println(result);
    }

}
