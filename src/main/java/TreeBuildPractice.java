import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TreeBuildPractice {
    static class Node {
        String name;
        int level = 0;
        List<Node> childs = new ArrayList<>();

        Node(int level, String name) {
            this.level = level;
            this.name = name;
        }
    }


    public static Node buildTreeByPreorderWithLevel(Node[] input) {
        if (input.length == 1) {
            return input[0];
        }
        Node root = input[0];
        Map<Integer, Node> levelMap = new HashMap();
        levelMap.put(0, root);
        build(root, levelMap, input, 1);
        return root;
    }

    public static void build(Node parent, Map<Integer, Node> levelMap, Node[] input, int index) {
        // input[index].level == parent.level+1
        while (index < input.length && input[index].level == parent.level + 1) {
            parent.childs.add(input[index]);
            levelMap.put(input[index].level, input[index]);
            index++;
        }
        // input[index].level > parent.level+1
        if (index < input.length && input[index].level > parent.level + 1) {
            build(input[index - 1], levelMap, input, index);
        }
        // input[index].level < parent.level
        if (index < input.length && input[index].level <= parent.level) {
            build(levelMap.get(input[index].level - 1), levelMap, input, index);
        }
    }

    public static void preOrderPrint(Node root) {
        System.out.println(root.name);
        for (Node c : root.childs) {
            preOrderPrint(c);
        }
    }

    public static void main(String[] args) {
        Node[] input = new Node[]{new Node(0, "A"), new Node(1, "B"), new Node(1, "C"), new Node(2, "D"), new Node(3, "E"),new Node(2, "F")};
//        Node[] input = new Node[]{new Node(0, "A"), new Node(1, "B"), new Node(2, "E"), new Node(3, "F"), new Node(2, "G"),
//                new Node(1, "C"), new Node(1, "D"), new Node(2, "H"), new Node(3, "I")};

        Node result = TreeBuildPractice.buildTreeByPreorderWithLevel(input);
        TreeBuildPractice.preOrderPrint(result);
    }
}
