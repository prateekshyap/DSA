/*https://leetcode.com/problems/find-the-minimum-and-maximum-number-of-nodes-between-critical-points/*/

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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return new int[]{-1,-1};
        int[] result = new int[2];
        result[0] = Integer.MAX_VALUE;
        result[1] = Integer.MIN_VALUE;
        int index = 1, prevVal = head.val, firstIndex = -1, prevIndex = -1, currIndex = -1;
        ListNode temp = head.next;
        while (temp.next != null)
        {
            prevIndex = currIndex;
            if (firstIndex == -1) firstIndex = currIndex;
            if (prevVal > temp.val && temp.next.val > temp.val)
                currIndex = index;
            else if (prevVal < temp.val && temp.next.val < temp.val)
                currIndex = index;
            if (firstIndex != -1 && currIndex != -1 && currIndex != firstIndex)
                result[1] = currIndex-firstIndex;
            if (currIndex != -1 && prevIndex != -1 && prevIndex != currIndex)
                result[0] = Math.min(result[0],currIndex-prevIndex);
            ++index;
            prevVal = temp.val;
            temp = temp.next;
        }
        if (result[0] == Integer.MAX_VALUE) result[0] = -1;
        if (result[1] == Integer.MIN_VALUE) result[1] = -1;
        return result;
    }
}