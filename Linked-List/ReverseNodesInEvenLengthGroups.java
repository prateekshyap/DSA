/*https://leetcode.com/problems/reverse-nodes-in-even-length-groups/*/

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
    public ListNode reverseEvenLengthGroups(ListNode head) {
        int count = 0, targetCount = 1;
        ListNode rest = null, temp = head, point = head, start = head, end = head;
        while (temp != null)
        {
            ++count;
            end = temp;
            temp = temp.next;
            if (count == targetCount || temp == null)
            {
                if ((targetCount == count && targetCount%2 == 0) || (temp == null && count%2 == 0))
                {
                    rest = temp;
                    ListNode[] reversedList = reverse(start,end);
                    point.next = reversedList[0];
                    reversedList[1].next = rest;
                    point = reversedList[1];
                }
                else
                    point = end;
                start = temp;
                end = temp;
                count = 0;
                ++targetCount;
            }
        }
        return head;
    }
    private ListNode[] reverse(ListNode start, ListNode end)
    {
        ListNode[] result = new ListNode[]{end,start};
        ListNode reversedList = reverseRecur(start, end);
        start.next = null;
        return result;
    }
    private ListNode reverseRecur(ListNode node, ListNode end)
    {
        if (node == end) return node;
        
        ListNode reversedList = reverseRecur(node.next,end);
        
        node.next.next = node;
        return reversedList;
    }
}

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
    public ListNode reverseEvenLengthGroups(ListNode head) {
        int count = 0, targetCount = 1;
        ListNode rest = null, temp = head, point = head, start = head, end = head;
        while (temp != null)
        {
            ++count;
            end = temp;
            temp = temp.next;
            if (count == targetCount || temp == null)
            {
                if ((targetCount == count && targetCount%2 == 0) || (temp == null && count%2 == 0))
                {
                    rest = temp;
                    ListNode reversedList = reverse(start,end);
                    point.next = reversedList;
                    start.next = rest;
                    point = start;
                }
                else
                    point = end;
                start = temp;
                end = temp;
                count = 0;
                ++targetCount;
            }
        }
        return head;
    }
    private ListNode reverse(ListNode start, ListNode end)
    {
        ListNode reversedList = reverseRecur(start, end);
        start.next = null;
        return end;
    }
    private ListNode reverseRecur(ListNode node, ListNode end)
    {
        if (node == end) return node;
        
        ListNode reversedList = reverseRecur(node.next,end);
        
        node.next.next = node;
        return reversedList;
    }
}