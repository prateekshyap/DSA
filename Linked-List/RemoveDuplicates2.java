/*https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/*/

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode curr = head;
        ListNode prev = head;
        ListNode temp = curr.next;
        boolean flag = false;
        while (temp != null)
        {
            if (curr.val == temp.val)
            {
                flag = true;
                curr.next = temp.next;
                temp = temp.next;
            }
            else
            {
                if (flag)
                {
                    curr.val = temp.val;
                    curr.next = temp.next;
                    temp = temp.next;
                    flag = false;
                }
                else
                {
                    curr = temp;
                    temp = temp.next;
                }
            }
        }
        if (flag)
        {
            temp = head;
            if (temp == curr) return null;
            while (temp.next != curr)
                temp = temp.next;
            temp.next = null;
        }
        return head;
    }
}