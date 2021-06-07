/*https://leetcode.com/problems/odd-even-linked-list/*/

class Solution {
    public ListNode oddEvenList(ListNode head) {
        //edge case
        if (head == null || head.next == null) return head;
        
        ListNode oddHead = new ListNode(1);
        ListNode evenHead = new ListNode(2);
        ListNode oddTail = oddHead;
        ListNode evenTail = evenHead;
        
        boolean flag = true;

        //keep attaching the nodes alternatively to the tails
        while (head != null)
        {
            if (flag)
            {
                oddTail.next = head;
                oddTail = oddTail.next;
                head = head.next;
            }
            else
            {
                evenTail.next = head;
                evenTail = evenTail.next;
                head = head.next;
            }
            flag = !flag;
        }

        //make the last nodes point to null
        if (evenTail.next == oddTail)
            evenTail.next = null;
        else if (oddTail.next == evenTail)
            oddTail.next = null;

        //attach even list to odd list tail
        oddTail.next = evenHead.next;
        return oddHead.next;
    }
}