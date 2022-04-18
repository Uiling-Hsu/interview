package DailyCodingProblem;

import java.util.HashMap;
import java.util.Map;

public class DecodingCount {
    public static int count(String input){
        char[] c = input.toCharArray();
        return count(c,0,new HashMap());
    }

    public static int count(char[] c, int index, Map<Integer,Integer> mome){
        if(c.length == 0) return 0;
        if(index ==c.length ) return 1;
        if(index == c.length-1) return 1;
        if(mome.get(index)!= null) return mome.get(index);
        StringBuilder sb = new StringBuilder();
        String compose = sb.append(c[index]).append(c[index+1]).toString();
        Integer num = Integer.parseInt(compose);
        int result = 0;
        if(num <= 26) {
            result +=count(c,index+2,mome);
        }
        result += count(c,index+1,mome);

        mome.put(index, result);
        return mome.get(index);
    }


    public static void main(String[] args){
        int result = DecodingCount.count("1222");
        System.out.println(result);
    }

}
