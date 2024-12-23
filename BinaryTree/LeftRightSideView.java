package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeftRightSideView {

    
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

        List<Integer> result = leftsideview(root);
        System.out.println("result left side view :" + result);

        List<Integer> result2 = rightsideview(root);
        System.out.println("result right side view :" + result2);        

    }

    public static List<Integer> rightsideview(TreeNode root) {

       

        List<Integer> list = new ArrayList<>();
        if(root == null) return list;

        Queue<TreeNode> queueu = new LinkedList<>();

        queueu.offer(root);

        while(!queueu.isEmpty()){

            int size = queueu.size();

            for(int i =0; i <size; i++){

                TreeNode current = queueu.poll();

                if( i == size - 1){
                    list.add(current.val);
                }

               if(current.left != null) queueu.offer(current.left);
               if(current.right != null) queueu.offer(current.right);
            }
        }
        return list;
            
        
        
    }

    public static List<Integer> leftsideview(TreeNode root){

        List<Integer> list = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();

        if(root == null) return list;


        queue.offer(root);

        while(!queue.isEmpty()){

            int size = queue.size();

            for(int i =0; i < size; i++){

                TreeNode current = queue.poll();

                if(i ==0) list.add(current.val);

                if(current.left != null ) queue.add(current.left);
                if(current.right != null ) queue.add(current.right);

            }

        }

        return list;
        
        
    }
    
}
