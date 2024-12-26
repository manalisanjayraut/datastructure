package LinkedList;

import LinkedList.SLTraversal.ListNode;

public class MergerList {

    static class ListNode{
        int val;
        ListNode next;

        ListNode(int val){
            this.val = val;
            this.next = null;
        }
    }

    public static void main(String[] args) {
          // Create two sorted linked lists
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode head = mergeList(l1, l2);

        ListNode current = head;
        while(current != null){
            System.out.print(" -->" + current.val);
            current = current.next;
        }
    }

    public static ListNode mergeList(ListNode l1, ListNode l2){

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while ( l1 != null && l2 != null){

            if(l1.val <= l2.val){
                current.next = l1;
                l1 = l1.next;
            }else{
                current.next = l2;
                l2 = l2.next;

            }

            current = current.next;
        }

        if(l1 != null){
            current.next = l1;
        }
        if(l2 != null){
            current.next  = l2;
        }

        return dummy.next;

    }
    
}
