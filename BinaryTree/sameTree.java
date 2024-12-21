package BinaryTree;

public class sameTree {


    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val){
            this.val = val;
        }
    }


    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(8);


        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        root2.left.left = new TreeNode(8);
      
        System.out.println("max depth of the tree :" + isSameTree(root, root2));

      
            
    }

    public static boolean isSameTree(TreeNode t1, TreeNode t2){

        if(t1 == null && t2 == null ) return true;

        if(t1 == null || t2 == null  || t1.val != t2.val) return false;

        return (isSameTree(t1.left, t2.left) &&  isSameTree(t1.right, t2.right));


    }
    
}
