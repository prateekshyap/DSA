/*https://leetcode.com/problems/insertion-sort-list/*/

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
    public ListNode insertionSortList(ListNode head) {
        ListNode temp = head.next, prev = head, pick, move;
        while (temp != null)
        {
            //pick the next node
            pick = temp;
            temp = temp.next;
            
            //detach pick node
            prev.next = null;
            pick.next = null;
            
            //find the position for pick
            move = head;
            while (move.next != null && move.next.val < pick.val)
                move = move.next;
            
            //reattach pick
            if (move == head && pick.val < move.val)
            {
                pick.next = move;
                head = pick;
            }
            else
            {
                pick.next = move.next;
                move.next = pick;
                if (move != prev) prev.next = temp;
                else prev = pick;
            }
        }
        
        return head;
    }
}