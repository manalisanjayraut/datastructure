package LinkedList;

public class Reorder {

    static class ListNode{
        int val;
        ListNode next;

        ListNode(int val){
            this.val = val;
            this.next = null;
        }
    }


    public static void main(String[] args) {

         // Create a linked list: 1 -> 2 -> 3 -> 4 -> 5
            ListNode head = new ListNode(1);
            head.next = new ListNode(2);
            head.next.next = new ListNode(3);
            head.next.next.next = new ListNode(4);
            head.next.next.next.next = new ListNode(5);

            System.out.println("Original List:");

            reorder(head);

            ListNode current = head;
            while(current != null){
                System.out.println("-->" + current.val);
                current = current.next;
            }

           
        
    }

    public static void reorder(ListNode head){

        if (head == null || head.next == null) return;


        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode current = slow.next;
        slow.next = null;
        ListNode prev = null;
        ListNode next = null;

        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current ;
            current = next;
        }

        ListNode second = prev;
        
        ListNode first = head;

        while(first != null && second != null){

            ListNode temp1 = first.next;
            ListNode temp2 = second.next;

            first.next = second;
            second.next = temp1;

            first = temp1;
            second = temp2;
        }


    }

    
    
}
