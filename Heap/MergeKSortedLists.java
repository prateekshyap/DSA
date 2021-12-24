/*https://leetcode.com/problems/merge-k-sorted-lists/*/

class ValuePolling implements Comparator<ListNode> {
    public int compare(ListNode n1, ListNode n2) {
        return n1.val - n2.val;
    }
}
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
    	//create a new head with a dummy node
        ListNode head = new ListNode(0);
        ListNode temp = head;
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(new ValuePolling());
        
        //add all the heads to the minheap
        for (int i = 0; i < lists.length; ++i)
            if (lists[i] != null)
                pq.add(lists[i]);

        //till exhausted
        while (!pq.isEmpty()) {
        	//remove the root and attach it to the new head
            temp.next = pq.poll();
            temp = temp.next;

            //add the next element to the minheap
            if (temp.next != null)
                pq.add(temp.next);
        }

        return head.next;
    }
}