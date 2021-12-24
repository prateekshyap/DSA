/*https://leetcode.com/problems/reverse-linked-list/*/

//iterative version
class Solution {
    public ListNode reverseList(ListNode head) {
        //edge case
        if (head == null || head.next == null)
            return head;

        //three pointer approach
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

//recursive approach
class Solution {
    public ListNode reverseList(ListNode head) {
        //edge case
        if (head == null || head.next == null)
            return head;

        //recursion call
        head = reverse(head);
        return head;
    }
    public ListNode reverse(ListNode head) {
        //last node will be the base case, return it as it is
        if (head.next == null)
            return head;

        /*recursion*/
        ListNode newHead = reverse(head.next);
        
        //reverse
        head.next.next = head;
        head.next = null;
        
        //return
        return newHead;
    }
}