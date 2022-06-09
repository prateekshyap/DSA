/*https://binarysearch.com/problems/Linked-List-Union*/

import java.util.*;

/**
 * class LLNode {
 *   int val;
 *   LLNode next;
 * }
 */

//extra space approach
class Solution {
    public LLNode solve(LLNode ll0, LLNode ll1) {
        HashSet<Integer> set = new HashSet<Integer>();
        LLNode newHead = new LLNode(0);

        LLNode temp1 = ll0, temp2 = ll1;

        while (temp1 != null)
        {
            set.add(temp1.val);
            temp1 = temp1.next;
        }

        while (temp2 != null)
        {
            set.add(temp2.val);
            temp2 = temp2.next;
        }

        LLNode temp = newHead;
        
        PriorityQueue<Integer> q = new PriorityQueue<Integer>();
        for (Integer i : set) q.add(i);
        
        while (!q.isEmpty())
        {
            temp.next = new LLNode((Integer)q.poll());
            temp = temp.next;
        }
        return newHead.next;
    }
}

//traversal approach
class Solution {
    public LLNode solve(LLNode ll0, LLNode ll1) {
        LLNode newHead = new LLNode(-1);

        LLNode temp = newHead, temp1 = ll0, temp2 = ll1;
        
        while (temp1 != null && temp2 != null)
        {
            if (temp1.val < temp2.val)
            {
                if (temp.val != temp1.val)
                {
                    temp.next = temp1;
                    temp = temp.next;
                }
                temp1 = temp1.next;
            }
            else
            {
                if (temp.val != temp2.val)
                {
                    temp.next = temp2;
                    temp = temp.next;
                }
                temp2 = temp2.next;
            }
        }
        if (temp1 != null)
        {
            while (temp1 != null && temp.val == temp1.val) temp1 = temp1.next;
            temp.next = temp1;
        }
        if (temp2 != null)
        {
            while (temp2 != null && temp.val == temp2.val) temp2 = temp2.next;
            temp.next = temp2;
        }
        return newHead.next;
    }
}

//recursion
import java.util.*;

/**
 * class LLNode {
 *   int val;
 *   LLNode next;
 * }
 */


class Solution {
    public LLNode solve(LLNode ll0, LLNode ll1) {
        if (ll0 == null && ll1 == null) return ll1;
        if (ll0 == null) return ll1;
        if (ll1 == null) return ll0;

        LLNode rest;

        if (ll0.val == ll1.val) rest = solve(ll0.next,ll1.next);
        else if (ll0.val < ll1.val) rest = solve(ll0.next,ll1);
        else rest = solve(ll0,ll1.next);

        if (ll0.val == ll1.val)
        {
            ll0.next = rest;
            return ll0;
        }
        
        if (ll0.val < ll1.val)
        {
            ll0.next = rest;
            return ll0;
        }
        
        ll1.next = rest;
        return ll1;
    }
}