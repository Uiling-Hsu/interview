package DailyCodingProblem;

public class Universal {
    int count = 0;
    static class Node{
        Node left, right;
        int val=0;
        public Node(int val, Node left, Node right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int countUnival(Node root){
        count(root);
        return count;
    }

    public boolean count(Node root){
        if(root.left == null && root.right == null){ count++; return true;}
        if(root.left == null && count(root.right) && root.val == root.right.val) {count++; return true;}
        if(root.right == null && count(root.left) && root.val == root.left.val) {count++; return true;}
        if (count(root.left) && count(root.right) && root.val == root.left.val && root.val == root.right.val) {count++; return true;}
        return false;
    }

    public static void main(String[] args){
        Node root = new Node(0,new Node(1,null,null), new Node(0,new Node(1,new Node(1,null,null),new Node(1,null,null)),new Node(0,null,null)));
        Universal universal = new Universal();
        System.out.println(universal.countUnival(root));

    }

}
