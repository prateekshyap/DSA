/*https://leetcode.com/problems/next-greater-node-in-linked-list/*/

class Solution {
    ArrayList<Integer> list;
    public int[] nextLargerNodes(ListNode head) {
        list = new ArrayList<Integer>();
        recur(head);
        int[] result = new int[list.size()];
        for (int i = 0, j = list.size()-1; i < list.size() && j >= 0 ; ++i, --j)
            result[i] = (Integer)list.get(j);
        return result;
    }
    public ListNode recur(ListNode head)
    {
        if (head.next == null) //base case
        {
            list.add(0);
            return head;
        }
        
        ListNode node = recur(head.next); //recursion
        
        if (head.val < node.val) //add node if it is greater than head
        {
            list.add(node.val);
            return head;
        }
        while (node.next != null && node.val <= head.val) node = node.next; //otherwise move node till the end or till a greater element that the head, whichever is earlier
        if (node.val > head.val) //add node if it is greater than head
        {
            list.add(node.val);
            head.next = node;
        }
        else //otherwise add 0
        {
            list.add(0);
            head.next = null;
        }
        return head; //return head
    }
}