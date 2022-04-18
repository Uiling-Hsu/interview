public class Lexicographically {
    public static String nextWord(String str) {

        // if string is empty
        if (str == "")
            return "a";

        // Find first character from
        // right which is not z.
        int i = str.length() - 1;
        while (i >= 0 && str.charAt(i) == 'z')
            i--;

        // If all characters are 'z',
        // append an 'a' at the end.
        String result;
        if (i == -1) {
            result = str + 'a';
            // If there are some
            // non-z characters
        }else {
            result = str.substring(0, i) +
                    (char) ((int) (str.charAt(i)) + 1);
            for(int j = 0; j < str.substring(i+1).length();j++){
                result+="a";
            }
        }
        return result;
    }

    // Driver Code
    public static void main(String[] args) {
        String str = "abzz";
        System.out.print(nextWord(str));
    }
}
