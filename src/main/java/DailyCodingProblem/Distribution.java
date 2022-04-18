package DailyCodingProblem;

import java.util.ArrayList;
import java.util.List;

public class Distribution {
    public static List<String> stringDistribute(String[] words, int k){
        List<String> result = new ArrayList();
        int lengthCount = 0;
        int spancCount = 0;
        boolean start = true;
        int startIndex = 0;
        StringBuilder sb  = new StringBuilder();
        if(words.length == 1){
            result.add(words[0]);
            return result;
        }
        for(int i = 0; i < words.length; i++){
            lengthCount+= start? words[i].length():1+words[i].length();
            start = false;
            if(lengthCount > k){
                lengthCount = lengthCount-words[i].length()-i;
                spancCount = (k-lengthCount)/(i-1);
                int extraSpace = (k-lengthCount)%(i-1);
                cal(spancCount,extraSpace,startIndex,i,words,sb);
                lengthCount = 0;
                start = true;
                startIndex = i;
                i--;
                spancCount = 0;
                result.add(sb.toString());
                sb.setLength(0);
            }
        }
        if(startIndex<words.length){
            lengthCount = lengthCount - (words.length-startIndex-1);
            spancCount = (k-lengthCount)/(words.length-startIndex-1);
            int extraSpace = (k-lengthCount)%(words.length-startIndex-1);
            cal(spancCount,extraSpace,startIndex,words.length,words,sb);
        }
        result.add(sb.toString());
        return result;
    }
    public static void cal(int spancCount, int extraSpace, int startIndex,int endIndex, String[] words, StringBuilder sb){
        for(int j = startIndex; j<endIndex; j++){
            if(j != startIndex) {
                if(extraSpace!=0) {
                    sb.append(" ");
                    extraSpace--;
                }
                for(int x = 0; x<spancCount; x++){
                    sb.append(" ");
                }
            }
            sb.append(words[j]);
        }

    }

    public static void main(String[] args){
//        String[] inputs = new String[]{"the", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog"};
        String[] inputs = new String[]{"the", "quick", "brown"};
        List<String> result = Distribution.stringDistribute(inputs,16);

        System.out.println(result.toString());
        for(String s:result){
            System.out.println(s);

        }
    }

}
