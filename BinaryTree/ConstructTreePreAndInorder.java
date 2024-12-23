package BinaryTree;
import java.util.HashMap;

public class ConstructTreePreAndInorder {

    static HashMap<Integer,Integer> map = new HashMap<>();

    static int preOrderIndex = 0;

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }
    
    public static void main(String args[]){

        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

        buildTreeNode(preorder, inorder);


    }

    public static TreeNode buildTreeNode(int[] preorder, int[] inorder){

        for(int i = 0; i < inorder.length ; i++){

            map.put(inorder[i],i);
        }

        return buildTreeNode(preorder, 0, inorder.length - 1);

    
    }

    public static  TreeNode buildTreeNode(int[] preorder, int left, int right){

        if(left > right) return null;

        int val = preorder[preOrderIndex++];

        TreeNode root = new TreeNode(val);

        int index = map.get(root.val); // this will give index of the root in inorder 

        root.left = buildTreeNode(preorder,left, index -1 );// so values till root is left subtree
        root.right = buildTreeNode(preorder,index + 1, right ); // values after root is right

        return root;

        
    }

        
}