/*https://leetcode.com/problems/merge-in-between-linked-lists/*/

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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode aNodePrev = list1, aNode = list1, bNode = list1, temp = list1;
        while (a > 0 || b > 0)
        {
            if (a > 0)
            {
                aNodePrev = aNode;
                aNode = aNode.next;
                --a;
            }
            if (b > 0)
            {
                bNode = bNode.next;
                --b;
            }
        }
        temp = list2;
        while (temp.next != null) temp = temp.next;
        if (aNode == list1)
        {
            temp.next = bNode.next;
            return list2;
        }
        aNodePrev.next = list2;
        temp.next = bNode.next;
        return list1;
    }
}