package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Traversal {
    
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val){
            this.val = val;
        }
    }

    public static List<Integer> preOrderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preOrderTraversal(root, list);
        return list;
    }

    private static void preOrderTraversal(TreeNode root, List<Integer> list) {
        if (root == null) return;

        list.add(root.val);
        preOrderTraversal(root.left, list);
        preOrderTraversal(root.right, list);
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        List<Integer> result = preOrderTraversal(root);
        System.out.println(result);

        List<Integer> list = new ArrayList<>();
         inOrderTraversal(root,list);
        System.out.println(list);

        List<List<Integer>> list2 = new LinkedList<>();
        levelOrderTraversal(root, list2);
        System.out.println(list2); 
        
        List<List<Integer>> list3 = new LinkedList<>();
        zigzagorder(root, list3);
        System.out.println(list3); 
        

    }

    public static void inOrderTraversal(TreeNode root, List<Integer> list) {

        if(root == null) return;

        inOrderTraversal(root.left, list);
        list.add(root.val);
        inOrderTraversal(root.right, list);

        
    }

    public static void levelOrderTraversal(TreeNode root, List<List<Integer>> list) {

        Queue<TreeNode> queue = new LinkedList<>();  

       

        queue.offer(root);

        while(!queue.isEmpty()){

            int size = queue.size();

            List<Integer> subList = new LinkedList<>();

            for(int i=0; i< size; i++) {

                if(queue.peek().left != null) queue.offer(queue.peek().left);
                if(queue.peek().right != null) queue.offer(queue.peek().right);   
                
                subList.add(queue.poll().val);


            }

            list.add(subList);
        }
    }

    public static void zigzagorder(TreeNode node, List<List<Integer>> list){

        if(node == null) return ;

        boolean lefttoright = true;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(node);

        while(!queue.isEmpty()){

            List<Integer> sublist = new LinkedList<>();

           

            for(int i =0; i < queue.size(); i++){

                TreeNode cuurentNode = queue.poll();

                int val = cuurentNode.val;
    
                if(lefttoright){
                    sublist.add(val);
                }else{
                    sublist.add(0, val);
                }

                if(cuurentNode.left != null) queue.offer(cuurentNode.left);
                if(cuurentNode.right!= null) queue.offer(cuurentNode.right);

            

            }

            lefttoright = !lefttoright;
            list.add(sublist);


        }


    }

 
}
