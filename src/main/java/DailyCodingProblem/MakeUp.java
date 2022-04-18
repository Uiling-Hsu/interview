package DailyCodingProblem;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MakeUp {
    public static List makeUp(List<Integer> input, int k) {
        LinkedList<Integer> result = new LinkedList();
        return findSubSet(input, k, result) ? result:null;
    }


    public static boolean findSubSet(List<Integer> input, int remain, LinkedList result) {
        if (remain == 0) return true;
        for (int i = 0; i < input.size(); i++) {
            if (input.get(i).intValue()!= -1) {
                int minus = remain - input.get(i);
                if (minus >= 0) {
                    int current = input.get(i);
                    result.add(current);
                    input.set(i, -1);
                    if (findSubSet(input, minus, result)) return true;
                    input.set(i, current);
                    result.removeLast();
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        List input = Arrays.asList(new Integer[]{12, 1, 61, 5, 9, 2});
        System.out.println(MakeUp.makeUp(input,24));


    }

}
