/*https://leetcode.com/problems/linked-list-cycle/*/

public class Solution {
    public boolean hasCycle(ListNode head) {
        //edge cases
        if (head == null || head.next == null) return false;
        if (head.next == head) return true;

        //two pointer approach
        ListNode singleJump = head, doubleJump = head;
        singleJump = singleJump.next;
        doubleJump = doubleJump.next.next;
        if (singleJump == doubleJump) return true;
        boolean flag = false;
        while (true)
        {
            singleJump = singleJump.next;

            //if null encountered, indicate it
            if (doubleJump == null || doubleJump.next == null || doubleJump.next.next == null)
            {
                flag = false;
                break;
            }
            doubleJump = doubleJump.next.next;

            //if cycle detected, indicate it
            if (singleJump == doubleJump) 
            {
                flag = true;
                break;
            }
        }
        return flag;
    }
}