package DailyCodingProblem;

public class MaxSizeBST {

    int maxCount = 0;
    Node maxRoot ;

    public Node findMaxSizeBST(Node root){
        isBST(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
        System.out.println(maxCount);
        return maxRoot;
    }

    public Result isBST(Node root, int max, int min){
        if(root == null){
            return new Result(0, true,null);
        }
        if(root.val > min && root.val < max){
            Result leftBSTCount = isBST(root.left, root.val, min);
            Result rightBSTCount = isBST(root.right, max, root.val);
            int total = 1;
            if(!leftBSTCount.isBST || !rightBSTCount.isBST){
                return new Result(0, false, null);
            }
            if(root.left != null){
                total += leftBSTCount.total;
            }
            if(root.right != null){
                total += rightBSTCount.total;
            }
            if(total > maxCount){
                maxCount = total;
                maxRoot = root;
            }
            return new Result(total, true, root);
        }
        return new Result(0, false, null);
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
        Node root = new Node(new Node(new Node(new Node(null, null,1), new Node(null, null,3),2),new Node(null, null,5),4), new Node(null, null,7), 8);
        MaxSizeBST maxSizeBST = new MaxSizeBST();
        Node result = maxSizeBST.findMaxSizeBST(root);
        System.out.println(result.val);

    }

}
