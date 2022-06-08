/*https://binarysearch.com/problems/Interleaved-Linked-List*/

import java.util.*;

class Solution {
    public LLNode solve(LLNode l0, LLNode l1) {
        LLNode head = new LLNode(-1);
        boolean turn = true;
        LLNode temp1 = l0, temp2 = l1, temp = head;
        while (l0 != null && l1 != null)
        {
            if (turn) //if turn is true, add nodes from l0
            {
                temp.next = l0;
                l0 = l0.next;
            }
            else //if turn is false, add nodes from l1
            {
                temp.next = l1;
                l1 = l1.next;
            }
            temp = temp.next; //move temp
            turn = !turn; //alter turn
        }
        if (l0 != null) temp.next = l0;
        else if (l1 != null) temp.next = l1;
        else temp.next = null;
        return head.next;
    }
}