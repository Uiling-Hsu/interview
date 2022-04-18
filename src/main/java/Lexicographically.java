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
        if (i == -1)
            str = str + 'a';

// If there are some
// non-z characters
        else
            str = str.substring(0, i) +
                    (char) ((int) (str.charAt(i)) + 1) +
                    str.substring(i + 1);
        return str;
    }

    // Driver Code
    public static void main(String[] args) {
        String str = "z";
        System.out.print(nextWord(str));
    }
}
