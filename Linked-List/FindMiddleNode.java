/*https://leetcode.com/problems/middle-of-the-linked-list/*/

//two pointer approach
class Solution {
    public ListNode middleNode(ListNode head) {
        if (head.next == null) return head;
        if (head.next.next == null) return head.next;
        ListNode singleJump = head;
        ListNode doubleJump = head;
        while (doubleJump != null && doubleJump.next != null)
        {
            singleJump = singleJump.next;
            if (doubleJump.next.next != null)
                doubleJump = doubleJump.next.next;
            else
                doubleJump = null;
        }
        return singleJump;
    }
}