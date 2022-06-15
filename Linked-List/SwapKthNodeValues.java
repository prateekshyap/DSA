/*https://binarysearch.com/problems/Swap-Kth-Node-Values*/

//swapping values
import java.util.*;

class Solution {
    public LLNode solve(LLNode node, int k) {
        int n = 0;
        LLNode temp = node;
        while (temp != null)
        {
            temp = temp.next;
            ++n;
        }

        int l = n-k;

        LLNode one = node, two = node;

        while (--k >= 0)
            one = one.next;
        while (--l > 0)
            two = two.next;

        int t = one.val;
        one.val = two.val;
        two.val = t;

        return node;
    }
}



//swapping nodes
import java.util.*;

class Solution {
    public LLNode solve(LLNode node, int k) {
        int n = 0;
        LLNode temp = node, temp1, temp2;
        while (temp != null)
        {
            temp = temp.next;
            ++n;
        }

        int l = n-k;
        ++k; --l;
        int kC = k, lC = l;

        LLNode one = node, two = node, prevOne = node, prevTwo = node;

        while (--k > 0)
        {
            prevOne = one;
            one = one.next;
        }
        while (--l >= 0)
        {
            prevTwo = two;
            two = two.next;
        }
        if (one == two) return node;
        if (kC > lC)
        {
            temp1 = prevOne;
            temp2 = one;
            prevOne = prevTwo;
            one = two;
            prevTwo = temp1;
            two = temp2;
        }

        if (one == node)
        {
            prevTwo.next = one;
            node = two;
            two.next = one.next;
            one.next = null;
        }
        else
        {
            prevOne.next = one.next;
            prevTwo.next = two.next;
            one.next = prevTwo.next;
            if (prevTwo != one) prevTwo.next = one;
            if (prevTwo != one) two.next = prevOne.next;
            else two.next = one;
            prevOne.next = two;
        }
        return node;
    }
}