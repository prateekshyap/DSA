/*https://leetcode.com/problems/remove-zero-sum-consecutive-nodes-from-linked-list/*/

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
    public ListNode removeZeroSumSublists(ListNode head) {
        Map<Integer,ListNode> map = new HashMap<Integer,ListNode>();
        ListNode temp = head, prev = head;
        int sum = 0;
        while (temp != null)
        {
            sum += temp.val;
            if (temp.val == 0)
            {
                if (head == temp)
                {
                    head = head.next;
                    prev = head;
                }
                else prev.next = temp.next;
                temp = temp.next;
            }
            else if (sum == 0)
            {
                head = temp.next;
                prev = head;
                temp = head;
                map.clear();
            }
            else if (map.containsKey(sum))
            {
                ListNode start = map.get(sum);
                ListNode next = start.next;
                start.next = temp.next;
                int copy = sum;
                while (next != temp)
                {
                    copy += next.val;
                    map.remove(copy);
                    next = next.next;
                }
                prev = start;
                temp = temp.next;
            }
            else
            {
                map.put(sum,temp);
                prev = temp;
                temp = temp.next;
            }
        }
        return head;
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
    public ListNode removeZeroSumSublists(ListNode head) {
        if (head == null) return head;
        int s = 0;
        for (ListNode cur = head; cur != null; cur = cur.next) if ((s += cur.val) == 0) return removeZeroSumSublists(cur.next);
        head.next = removeZeroSumSublists(head.next);
        return head;
    }
}