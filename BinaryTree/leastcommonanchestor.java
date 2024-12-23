package BinaryTree;

import java.util.LinkedList;
import java.util.List;

public class leastcommonanchestor {

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
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        TreeNode p = root.left; // Node 2
        TreeNode q = root.left.right; // Node 4

       // TreeNode lca = findLCM(root, p, q);

        //System.out.println("lcm  :" + lca.val);

        TreeNode lcm = findOptimalLCM(root, p, q);

        System.out.println("lcm ** optimal :" + lcm.val);

    }

    public static TreeNode findOptimalLCM(TreeNode root, TreeNode p, TreeNode q){
        TreeNode current = root;

        while(current != null){

            if(p.val < current.val && q.val < current.val){
                current = current.left;
            } else if(p.val > current.val && q.val > current.val){
                current = current.right;
            }else{
                return current;
            }
        }

        return null;
    }

    

   
}
