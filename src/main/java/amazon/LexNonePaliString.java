package amazon;

import java.util.Arrays;

public class LexNonePaliString {
    /*
    *  if input s has no palindrome substring, return
    *  else, next lexicographical string without substring palindrome
    *  the input and output length must be the same , if there is no output, return null
    */


    public static String generate(String s){
        while(isSubStrPalindrome(s)){
            s = nextLexicagraphicString(s);
        }
        return s;

    }

    public static boolean isSubStrPalindrome(String s){
        if (s == null){ return false;}
        int length = s.length();
        if(length ==1 ) return false;
        if(length == 2){
            if (s.charAt(0) == s.charAt(1)){
                return true;
            }else{
                return false;
            }
        }
        boolean[][] record = new boolean[length][length];
        for(int i = 0 ; i < length; i++){
            record[i][i] = false;
        }

        for(int i =1 ; i < length; i++){
            if(s.charAt(i) == s.charAt(i-1)){
                record[i-1][i] = true;
            }
        }

        for(int l = 2; l < length; l++){
            for(int i =0 ; i < length; i++){
                if(i+l < length){
                    if(s.charAt(i+l) == s.charAt(i+l-1) || s.charAt(i+l) == s.charAt(i+l-2)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static String nextLexicagraphicString(String s){
        if(s== "") return "a";
        int i = s.length()-1;
        while(i >=0 && s.charAt(i) == 'z'){
            i--;
        }

        if (i == -1) {
            return null; //because requirement is the same length string
            // return s+"a";
        }

        String result = s.substring(0,i) + (char)((int)s.charAt(i)+1) + s.substring(i+1);
        return result;

    }

    public static void main(String[] args){
//        String next = LexNonePaliString.nextLexicagraphicString("zzzz");
//        System.out.println(next);

//        boolean b = LexNonePaliString.isSubStrPalindrome("abxa");
        String s= LexNonePaliString.generate("aba");
        System.out.println(s);
    }
}
