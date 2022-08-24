/*https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int pairSum(ListNode head) {
        if (head.next.next == null) return head.val+head.next.val;
        ListNode slow = head, prev = head, fast = head;
        while (fast != null)
        {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        slow = reverseList(slow);
        int max = 0;
        while (head != null)
        {
            max = Math.max(max,head.val+slow.val);
            head = head.next;
            slow = slow.next;
        }
        return max;
    }
    private ListNode reverseList(ListNode head)
    {
        ListNode prev = head;
        ListNode curr = head;
        ListNode newList = head;

        //till we are left with new elements
        while (newList != null)
        {
            //set curr to new element
            curr = newList;

            //set new element to the next element
            newList = curr.next;

            //modify the poninter
            curr.next = prev;

            //move the previous pointer forward
            prev = curr;
        }

        //remove the loop
        head.next = null;

        //update the head
        head = curr;

        return head;
    }
}