package BinaryTree;

public class MaxDepthOfTree {

    private static int diameter = 0;
    private static int maxPathSum = 0;

    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val){
            this.val = val;
        }
    }


    public static int maxDepth(TreeNode root){    

        if(root == null) return 0;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return Math.max(left, right) + 1;
    }

    public static int diameter(TreeNode root){

        if(root == null) return 0;

        int left = diameter(root.left);
        int right = diameter(root.right);

        diameter = Math.max(diameter, left + right);

        return 1+ Math.max(left, right);


    }

    public static int maxPathSum(TreeNode root){

        if(root == null) return 0;

        int left = Math.max(0, maxPathSum(root.left));
        int right = Math.max(0, maxPathSum(root.right));

        maxPathSum = Math.max(maxPathSum, left + right  + root.val);

        return  Math.max(left, right)+ root.val;
        

    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(8);
      
        System.out.println("max depth of the tree :" + maxDepth(root));

        diameter(root);
        System.out.println("diameter of the tree :" + diameter);

        maxPathSum(root);
        System.out.println("max path sum : " + maxPathSum);
            
    }
    
}
