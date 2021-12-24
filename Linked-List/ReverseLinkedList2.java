/*https://leetcode.com/problems/reverse-linked-list-ii/*/

class Solution {
    public ListNode reverseBetween(ListNode head, int l, int r) {
    	//edge cases
        if (head.next == null && l == 1 && r == 1)
            return head;
        if (l == r)
            return head;
        ListNode prev = head, curr = head, newList = head;
        ListNode left = head, right = head, leftToList = head;
        int loop = r-l;

        //set left pointer
        while (l > 1)
        {
            leftToList = left;
            left = left.next;
            --l;
            right = right.next;
            --r;
        }

        //set right pointer
        while (r > 1)
        {
            right = right.next;
            --r;
        }

        //standard reverse process
        prev = left;
        curr = left;
        newList = left.next;
        while (loop > 0)
        {
            curr = newList;
            newList = curr.next;
            curr.next = prev;
            prev = curr;
            --loop;
        }

        //set the pointers
        left.next = newList;
        if (left == head)
            head = right;
        else
            leftToList.next = right;
        return head;
    }
}