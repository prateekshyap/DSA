/*https://leetcode.com/problems/partition-list/*/

class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode list1 = new ListNode(1), list2 = new ListNode(1);
        ListNode temp = head, temp1 = list1, temp2 = list2;
        while (temp != null)
        {
            if (temp.val < x)
            {
                temp1.next = temp;
                temp1 = temp1.next;
            }
            else
            {
                temp2.next = temp;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        temp2.next = null;
        temp1.next = list2.next;
        return list1.next;
    }
}