package LinkedList;

public class Addtwonumber {

    static class ListNode{
        int val;
        ListNode next;

        ListNode(int val){
            this.val = val;
            this.next = null;
        }
    }

    public static void main(String args[]){
           // Create first number: 2 -> 4 -> 3 (342)
           ListNode l1 = new ListNode(2);
           l1.next = new ListNode(4);
           l1.next.next = new ListNode(3);
   
           // Create second number: 5 -> 6 -> 4 (465)
           ListNode l2 = new ListNode(5);
           l2.next = new ListNode(6);
           l2.next.next = new ListNode(4);
   
           // Add the two numbers
           ListNode result = addTwoNumbers(l1, l2);

           ListNode current = result;

           while(current!=null){
            System.out.println("-->" + current.val);
            current = current.next;
           }
   
         
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2){

        if(l1 == null || l2 == null) return null;

        ListNode current_l1 = l1;
        ListNode current_l2 = l2;

        ListNode dummy = new ListNode(0);
        ListNode result = dummy;
        int carry = 0;

        while(current_l1 != null && current_l2 != null){
            int val1 = (current_l1 != null) ? current_l1.val: 0;
            int val2 = (current_l2 != null) ? current_l2.val: 0;

            int sum = val1 + val2+carry;
            carry =  sum / 10;
            int digit = sum % 10;

            result.next = new ListNode(digit);
            result = result.next;
            if(current_l1 != null) current_l1 = current_l1.next;
            if(current_l2 != null) current_l2 = current_l2.next;


        }

        return dummy.next;

    }
    
    
}
