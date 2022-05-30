/*https://leetcode.com/problems/swap-nodes-in-pairs/*/
/*https://binarysearch.com/problems/Pairwise-Linked-List-Swap*/

//iterative solution
class Solution {
    public ListNode swapPairs(ListNode head) {
    	//edge case
        if (head == null || head.next == null) return head;
        ListNode first = head, second = head, newList = head;
        ListNode newHead = head.next;

        //till we have more elements left
        while (newList != null && newList.next != null)
        {
        	//swap first and second pointers
            second = first.next;
            newList = second.next;
            second.next = first;

            //make first.next to point the new list
            if (newList != null && newList.next != null)
                first.next = newList.next;
            else if (newList == null)
                first.next = null;
            else if (newList.next == null)
                first.next = newList;

            //update for the next iteration
            first = newList;
        }
        return newHead;
    }
}

class Solution {
    public LLNode solve(LLNode node) {
        if (node == null || node.next == null)
            return node;
        LLNode prev = node, curr = node, newList = node, newHead = node.next;
        while (newList != null && newList.next != null)
        {
            prev = newList;
            curr = prev.next;
            newList = curr.next;
            curr.next = prev;
            prev.next = newList == null || newList.next == null ? newList : newList.next;
        }
        return newHead;
    }
}

//recursive solution
class Solution {
    public ListNode swapPairs(ListNode head) {
        //edge case
        if (head == null || head.next == null) return head;
        
        //recursion call
        head = swap(head,head.next);
        return head;
    }
    public ListNode swap(ListNode first, ListNode second) {
        //for odd number of nodes straight-away return the remaining list
        if (second == null)
            return first;

        ListNode list = null; //stores the already swapped list

        //if list is not already exhausted
        if (second.next != null)
            /*recursion*/
            list = swap(second.next,second.next.next);

        //swap and attach the already swapped list
        second.next = first;
        first.next = list;

        //return the list
        return second;
    }
}