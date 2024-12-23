package BinaryTree;

public class Kthsmallest {

    public static int count = 0;
    public static int result = 0;

    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val){
            this.val = val;
        }
    }


    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);

        function(root, 3);
       System.out.println("result " + result);
    }

    public static void function(TreeNode root, int k){

        if(root == null)  return ;

        function(root.left, k);

        count = count + 1 ;

        if(count == k){
            result = root.val;
            return;
        }

        function(root.right, k);

    }
    
}
