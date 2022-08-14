/*https://leetcode.com/problems/merge-nodes-in-between-zeros/*/

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
    public ListNode mergeNodes(ListNode head) {
        ListNode newList = null, tail = null, prev = null, temp = head;
        
        while (temp != null)
        {
            if (temp.val == 0)
            {
                if (newList == null)
                    newList = tail = new ListNode(0);
                else
                {
                    prev = tail;
                    tail.next = new ListNode(0);
                    tail = tail.next;
                }
            }
            tail.val += temp.val;
            temp = temp.next;
        }
        
        prev.next = null;
        return newList;
    }
}