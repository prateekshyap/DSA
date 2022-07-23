/*https://leetcode.com/problems/reorder-list/*/

class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return;
        ListNode tortoise = head, hare = head, prev = tortoise;
        while (hare != null && hare.next != null)
        {
            prev = tortoise;
            tortoise = tortoise.next;
            hare = hare.next.next;
        }
        if (hare != null) tortoise = prev;
        ListNode secondList = tortoise.next;
        tortoise.next = null;
        
        //reversing the second list
        secondList = reverse(secondList);
        ListNode newList = new ListNode(-1), tempPoint = newList;
        boolean turn = true;
        while (head != null && secondList != null)
        {
            if (turn)
            {
                tempPoint.next = head;
                head = head.next;
            }
            else
            {
                tempPoint.next = secondList;
                secondList = secondList.next;
            }
            tempPoint = tempPoint.next;
            turn = !turn;
        }
        if (head != null) tempPoint.next = head;
        else if (secondList != null) tempPoint.next = secondList;
        head = newList.next;
    }
    private ListNode reverse(ListNode head)
    {
        if (head.next == null) return head;
        
        ListNode reversedList = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return reversedList;
    }
}

class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return;
        ListNode tortoise = head, hare = head, prev = tortoise;
        while (hare != null && hare.next != null)
        {
            prev = tortoise;
            tortoise = tortoise.next;
            hare = hare.next.next;
        }
        if (hare != null) tortoise = prev;
        ListNode secondList = tortoise.next;
        tortoise.next = null;
        
        //reversing the second list
        secondList = reverse(secondList);
        head = getInterleavedList(head,secondList);
    }
    private ListNode getInterleavedList(ListNode head1, ListNode head2)
    {
        if (head1 == null) return head2;
        if (head2 == null) return head1;
        
        ListNode interleavedList = getInterleavedList(head1.next,head2.next);
        head1.next = head2;
        head2.next = interleavedList;
        
        return head1;
    }
    private ListNode reverse(ListNode head)
    {
        if (head.next == null) return head;
        
        ListNode reversedList = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return reversedList;
    }
}