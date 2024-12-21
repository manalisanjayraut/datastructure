package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class invertedTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(8);

        TreeNode root2 = invertedTree(root);

        List<Integer> list = new ArrayList<>();
        preOrderTraversal(root2, list);
        System.out.println(list);

    }

    private static void preOrderTraversal(TreeNode root, List<Integer> list) {
      
        if(root == null) return;

        list.add(root.val);
        preOrderTraversal(root.left, list);
       
        preOrderTraversal(root.right, list);

    }

    public static TreeNode invertedTree(TreeNode root) {

        if (root == null)
            return null;

        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;

        invertedTree(root.left);
        invertedTree(root.right);

        return root;

    }
}
