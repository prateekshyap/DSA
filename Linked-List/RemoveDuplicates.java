/*https://leetcode.com/problems/remove-duplicates-from-sorted-list/*/
 
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        //edge case
        if (head == null || head.next == null) return head;
        ListNode curr = head; //points to one node
        ListNode temp = curr.next; //points to the next node
        
        //till we have more nodes
        while (temp != null)
        {
        	//if it is duplicate
            if (curr.val == temp.val)
            {
            	//skip the temp node
                curr.next = temp.next;
                temp = temp.next;
            }
            else
            {
                curr = temp;
                temp = temp.next;
            }
        }
        return head;
    }
}