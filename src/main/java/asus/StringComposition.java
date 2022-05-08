package asus;

public class StringComposition {
    /**
     * A: ab
     *      i
     * B: ac
     *      j
     * C: acab
     *       k
     *
     *
     *
     *
     */
    public static boolean isValid(String a, String b, String c){
        if(c.length() != a.length()+b.length()){
            return false;
        }
        if(c.length()==0 && a.length()==0 && b.length()==0){
            return true;
        }
        boolean temp = false;
        if(a.length() != 0 && c.charAt(0) == a.charAt(0)){
            temp = isValid(a.substring(1),b,c.substring(1));
        }
        if(b.length() != 0 && c.charAt(0) == b.charAt(0)){
            temp = temp || isValid(a,b.substring(1),c.substring(1));
        }
        return temp;

    }

    public static void main(String[] args){
        System.out.println(StringComposition.isValid("ab","ac","baac"));
    }





}
