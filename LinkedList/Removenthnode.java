package LinkedList;

public class Removenthnode {

    static class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
            this.next = null;
        }
    }

    public static void main(String args[]){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode newnode = removenthnode(head,2);

        ListNode current = newnode;

        while(current != null){
            System.out.print("-->" + current.val);
            current = current.next;
        }

    }

    public static ListNode removenthnode(ListNode head, int n){

        if(head == null) return null;

        ListNode first = head;
        ListNode second = head;


        for(int i = 0; i <=n ; i++){
            first = first.next;
        }

        while(first != null){
            first = first.next;
            second = second.next;
        }

        second.next = second.next.next;

        return head;


    }
    
}
