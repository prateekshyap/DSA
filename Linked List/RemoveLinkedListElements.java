/*https://leetcode.com/problems/remove-linked-list-elements/*/

class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode prev = head, curr = head;
        while (curr != null)
        {
            if (curr.val == val && curr == head)
            {
                head = prev = curr = head.next;
            }
            else if (curr.val == val && curr.next == null)
            {
                prev.next = curr = null;
            }
            else if (curr.val == val)
            {
                prev.next = curr.next;
                curr = curr.next;
            }
            else
            {
                prev = curr;
                curr = curr.next;
            }
        }
        return head;
    }
}