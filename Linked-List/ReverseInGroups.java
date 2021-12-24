/*https://leetcode.com/problems/reverse-nodes-in-k-group/*/

//iterative approach
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
    	//edge case
        if (k==1) return head;

        //place the new head
        ListNode newHead = head;
        int copy = k;
        while (k > 1)
        {
            newHead = newHead.next;
            --k;
        }

        //count the number of groups
        k = copy;
        int counter = 0;
        ListNode temp = head;
        while (temp != null)
        {
            ++counter;
            temp = temp.next;
        }
        counter /= k;


        ListNode prev = head, curr = head, rest = head.next, prevListTail = newHead;

        //for every group
        while (counter > 0)
        {
        	//reverse the group
            while (k > 1)
            {
                curr = rest;
                rest = curr.next;
                curr.next = prev;
                prev = curr;
                --k;
            }
            k = copy;

            //attach the group
            if (prevListTail != newHead)
                prevListTail.next = curr;

            //adjust the tail of the list
            while (prevListTail.next.next != prevListTail)
                prevListTail = prevListTail.next;
            prevListTail = prevListTail.next;

            //update for next iteration
            prev = rest;
            curr = rest;
            if (curr != null)
                rest = curr.next;
            --counter;
        }
        prevListTail.next = curr;
        return newHead;
    }
}

//recursive approach
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        //edge case
        if (k==1) return head;

        //recursion call
        head = reverseInGroups(head,k);
        return head;
    }
    public ListNode reverseInGroups(ListNode head, int k) {
        ListNode temp = head;
        int counter = k;

        //till we have more nodes, move next for k times
        while (temp != null && counter-- > 0)
            temp = temp.next;

        //if while loop is interrupted by temp being null return the list as it is
        if (temp == null && counter > 0)
            return head;

        /*recursion*/
        ListNode reversedList = reverseInGroups(temp,k);

        //reverse the current part
        ListNode newHead = reverse(head,k);

        //attach the already reversed list to the end and return
        head.next = reversedList;
        return newHead;
    }
    public ListNode reverse(ListNode head, int count) {
        //if last node return it
        if (head.next == null || count == 1)
            return head;

        /*recursion*/
        ListNode newHead = reverse(head.next,count-1);
        
        //reverse and return
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}