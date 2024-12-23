package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class Deserialize {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

        public static void main(String args[]) {

            TreeNode root = new TreeNode(1);
            root.left = new TreeNode(2);
            root.right = new TreeNode(3);
            root.right.left = new TreeNode(4);
            root.right.right = new TreeNode(5);

            String serialized = serialize(root);

            System.out.println(serialized);

            deserialize(serialized);

        }

        public static String serialize(TreeNode root) {

            if (root == null)
                return "null";

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            StringBuffer sb = new StringBuffer();

            while (!queue.isEmpty()) {

                TreeNode current = queue.poll();

                if (current == null) {
                    sb.append("null,");
                } else {
                    sb.append(current.val).append(",");
                    queue.offer(current.left);
                    queue.offer(current.right);
                }

            }
            sb.setLength(sb.length() - 1);
            return sb.toString();

        }

        public static TreeNode deserialize(String data) {

            String s[] = data.split(",");

            TreeNode root = new TreeNode(Integer.parseInt(s[0]));

            Queue<TreeNode> queue = new LinkedList<>();

            queue.offer(root);

            int i = 1;

            while (!queue.isEmpty() && i < s.length) {

                TreeNode current = queue.poll();

                if (s[i].equals("null")) {
                    current.left = new TreeNode(Integer.parseInt(s[i]));
                    queue.offer(current);
                }
                i++;

                if (s[i].equals("null") && i < s.length) {
                    current.right = new TreeNode(Integer.parseInt(s[i]));
                    queue.offer(current);
                }

                i++;

            }

            return root;

        }

    }
}