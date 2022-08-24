/*https://leetcode.com/problems/split-linked-list-in-parts/*/

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
    public ListNode[] splitListToParts(ListNode head, int k) {
        if (head == null) return new ListNode[k];
        int copy, N = 0, extra = 0, i;
        ListNode tail, temp = head;
        while (temp != null)
        {
            temp = temp.next;
            ++N;
        }
        ListNode[] result = new ListNode[k];
        extra = N%k;
        N /= k;
        for (i = 0; i < k; ++i)
        {
            result[i] = tail = new ListNode(-1);
            copy = N;
            while (copy-- > 0)
            {
                tail.next = head;
                head = head.next;
                tail = tail.next;
            }
            if (extra-- > 0)
            {
                tail.next = head;
                head = head.next;
                tail = tail.next;
            }
            tail.next = null;
            result[i] = result[i].next;
        }
        return result;
    }
}