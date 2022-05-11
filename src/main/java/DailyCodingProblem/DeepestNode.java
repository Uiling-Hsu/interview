package DailyCodingProblem;

import com.sun.tools.javac.util.Pair;

public class DeepestNode {
    public Pair<Node,Integer> findDeepest(Node node){
        if(node.left == null && node.right== null ){
            return new Pair(node, 1);
        }
        if (node.left == null){
            Pair<Node,Integer> rightPair = findDeepest(node.right);
            return new Pair(rightPair.fst, rightPair.snd+1);
        }
        if (node.right == null){
            Pair<Node,Integer> leftPair = findDeepest(node.left);
            return new Pair(leftPair.fst, leftPair.snd+1);
        }

        Pair<Node,Integer> leftPair = findDeepest(node.left);
        Pair<Node,Integer> rightPair = findDeepest(node.right);
        Pair<Node,Integer> result = leftPair.snd >rightPair.snd?leftPair:rightPair;
        return new Pair(result.fst, result.snd+1);

    }

    class Node{
        Node left;
        Node right;
    }


}
