package Heap;

import java.util.PriorityQueue;

public class MergeKSortedList {

     static class ListNode {
        int val;
        ListNode next;
    
        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }
    
    

    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);

        ListNode[] lists = {l1, l2, l3};

        // Merge k sorted lists and print the result
        ListNode merged = mergeKLists(lists);
        while(merged != null) {
            System.out.print(merged.val + " ");
            merged = merged.next;

        }
        
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

        for(ListNode head : lists){
            minHeap.add(head);
        }

        ListNode dummy = new ListNode(0);
        ListNode currNode = dummy;

        while(!minHeap.isEmpty()){
            ListNode smallest = minHeap.poll();
            currNode.next = smallest;
            
            if(smallest.next != null){          
                minHeap.add(smallest.next);
            }   
            currNode = currNode.next;    

        }
        
     
        return dummy.next;
    }
    
}
