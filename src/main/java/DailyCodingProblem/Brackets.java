package DailyCodingProblem;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Brackets {
    static Map<Character, Character> bracketMap = new HashMap();

    static Stack<Character> stack = new Stack();

    static{
        bracketMap.put('(', ')');
        bracketMap.put('[', ']');
        bracketMap.put('{', '}');
    }

    public static boolean isValid(String input) {

        for (char c : input.toCharArray()) {
            if (bracketMap.containsKey(c)) {
                stack.push(c);
            } else {
                Character openBracket = stack.pop();
                if (!bracketMap.get(openBracket).equals(c)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args){
        System.out.println(Brackets.isValid("{{[]}}"));
    }

}
