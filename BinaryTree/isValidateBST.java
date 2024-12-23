package BinaryTree;
public class isValidateBST{

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    
        TreeNode(int val) {
            this.val = val;
        }
    }
    
    public static boolean isValidBST(TreeNode root){
       return isValidateBST(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    public static boolean isValidateBST(TreeNode current, Integer max, Integer min){

        if(current == null) return true;

        if(current.val <= min || current.val >= max) return false;

        return isValidateBST(current.left, current.val, min) && isValidateBST(current.right, max, current.val);
    }

    public static void main(String[] args) {
        
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        System.out.println(isValidBST(root));


        TreeNode invalidRoot = new TreeNode(5);
        invalidRoot.left = new TreeNode(1);
        invalidRoot.right = new TreeNode(4);
        invalidRoot.right.left = new TreeNode(3);
        invalidRoot.right.right = new TreeNode(6);

        System.out.println(isValidBST(invalidRoot));
    }
}