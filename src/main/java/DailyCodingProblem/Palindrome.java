package DailyCodingProblem;

public class Palindrome {
    public static String makePalindrome(String s){
        if(isPalindrome(s)){
            return s;
        }
        String s1 = s.charAt(0) + makePalindrome(s.substring(1))+  s.charAt(0);
        String s2 = s.charAt(s.length()-1) + makePalindrome(s.substring(0,s.length()-1)) + s.charAt(s.length()-1);
        if(s1.length() == s2.length()){
            return s1.compareTo(s2) <= 0? s1: s2;
        }
        return s1.length() < s2.length()? s1:s2;
    }

    public static boolean isPalindrome(String s){
        if(s.length() <=1){
            return true;
        }
        int i = 0, j= s.length()-1;
        while(i<j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public static void main(String[] args){
        System.out.println(Palindrome.makePalindrome("abb"));
    }
}
