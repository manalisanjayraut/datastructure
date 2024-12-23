package BinaryTree;
public class isSubTree {

        public static class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;
    
            TreeNode(int val) {
                this.val = val;
            }
        }


    
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        if(root == null) return false;

        if(isSameTree(root, subRoot)) return true;

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        
    }

    public boolean isSameTree(TreeNode t1, TreeNode t2){

        if(t1 == null && t2 == null) return true;

        if(t1 != null || t2 != null || t1.val != t2.val ){
            return false;
        }

        return isSameTree(t1.left, t2.left) && isSameTree(t1.right , t2.right);
    }
}