/*https://leetcode.com/problems/linked-list-cycle-ii/*/

public class Solution {
    public ListNode detectCycle(ListNode head) {
    	//edge case
        if (head == null || head.next == null) return null;
        
        //two pointer approach
        ListNode slow = head, fast = head;
        slow = slow.next;
        fast = fast.next.next;
        if (slow == fast)
            return head;
        boolean flag = false;
        while (true)
        {
            slow = slow.next;

            //if null encountered, indicate it
            if (fast == null || fast.next == null || fast.next.next == null)
            {
                flag = false;
                break;
            }
            fast = fast.next.next;

            //if cycle encountered, indicate it
            if (slow == fast) 
            {
                flag = true;
                break;
            }
        }

        //if no cycle, return null
        if (!flag) return null;

        //standard approach to locate the cycle
        slow = head;
        while (slow != fast)
        {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}