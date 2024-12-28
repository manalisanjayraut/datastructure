package LinkedList;

public class ReverseLinkedList {

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

         ListNode latest  = reverse(head);

         ListNode current = latest;
         while (current != null) {

            System.out.println("-->" + current.val);
            current = current.next;
            
         }

    }

    public static ListNode reverse(ListNode head){

        ListNode current = head;
        ListNode prev = null;
        ListNode next = null;

        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
    
}
