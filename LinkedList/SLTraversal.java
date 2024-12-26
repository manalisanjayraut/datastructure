package LinkedList;

import javax.sound.sampled.LineUnavailableException;

public class SLTraversal {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(2);
        l1.next.next.next = new ListNode(1);

        traversal(l1);
        System.out.println("========================================================");
        ListNode secondmiddle = secondmiddle(l1);
        System.out.println("second middle "+ secondmiddle.val);
        System.out.println("========================================================");
       
        System.out.println("is palindrome "+ palindrome(l1));
        System.out.println("========================================================");
        ListNode revesre  = reverse(l1);
        traversal(revesre);
       
    }

    public static void traversal(ListNode head){

        ListNode current = head;
        while(current!= null){
            System.out.println("value is ==>" + current.val);
            current = current.next;
        }
    }

    public static ListNode reverse(ListNode head){

        ListNode current = head;
        ListNode next = null;
        ListNode prev = null;

        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;

    }

    public static ListNode secondmiddle(ListNode head){

        if(head == null) return null;

        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static boolean palindrome(ListNode head){


        if(head == null || head.next == null) return false;
        
        ListNode secondhalf = secondmiddle(head);

        ListNode secondreverse = reverse(secondhalf);

        ListNode current = head;

        while(current!= null && secondreverse != null){
            if(current.val != secondreverse.val)
            {
                return false;
            }
            current = current.next;
            secondreverse = secondreverse.next;
        }
        return true;
    }


    
}
