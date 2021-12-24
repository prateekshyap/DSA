/*https://leetcode.com/problems/remove-nth-node-from-end-of-list/*/

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
    	//edge case
        if (n == 1 && head.next == null)
        {
            head = head.next;
            return head;
        }
        ListNode front = head, back = head;
        int copy = n;

        //two pointer approach to locate Nth node from end
        while (copy > 1)
        {
            front = front.next;
            --copy;
        }
        while (front.next != null)
        {
            front = front.next;
            back = back.next;
        }

        //if it is the last node, remove it
        if (back.next == null)
        {
            ListNode temp = head;
            while (temp.next != back)
                temp = temp.next;
            temp.next = null;
        }

        //otherwise remove the next node by copying the value
        else
        {
            back.val = back.next.val;
            back.next = back.next.next;
        }
        return head;
    }
}