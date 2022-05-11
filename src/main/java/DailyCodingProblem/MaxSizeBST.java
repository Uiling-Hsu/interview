package DailyCodingProblem;

public class MaxSizeBST {

    int maxCount = 0;
    Node maxRoot ;

    public Node findMaxSizeBST(Node root){
        helper(root);
        return maxRoot;
    }

    public int[] helper(Node root){ // [size, min, max]
        if(root == null){
            return new int[]{0, Integer.MAX_VALUE, Integer.MIN_VALUE};
        }
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        if(root.val > left[2] && root.val < right[1]){
            int size = left[0] + right[0] + 1;
            if(size > maxCount){
                maxCount = size;
                maxRoot = root;
            }
            return new int[]{size, Math.min(root.val, left[1]), Math.max(root.val, right[2])};
        }
        return new int[]{0, Integer.MIN_VALUE, Integer.MAX_VALUE};
    }


    static class Node{
        Node right;
        Node left;
        int val;
        Node(Node left, Node right,int val){
            this.right = right;
            this.left = left;
            this.val = val;
        }
    }
    class Result{
        int total;
        boolean isBST = false;
        Node result;
        public Result(int total, boolean isBST, Node result){
            this.total = total;
            this.isBST = isBST;
            this.result = result;
        }
    }

    public static void main(String[] args){
        Node root = new Node(new Node(null, null,1), new Node(new Node(null, null,5), new Node(null, null,8),7),10);
//        Node root =new Node(new Node(null, null,1),new Node(null, null,5),4);
        MaxSizeBST maxSizeBST = new MaxSizeBST();
        Node result = maxSizeBST.findMaxSizeBST(root);
        System.out.println(maxSizeBST.maxCount);
    }

}
