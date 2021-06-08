/*https://practice.geeksforgeeks.org/problems/delete-nodes-having-greater-value-on-right/1*/

class Solution
{
    int max;
    Node compute(Node head)
    {
    	//edge case
        if (head == null || head.next == null) return head;
        max = Integer.MIN_VALUE;
        
        //recursion call
        head = findLeaders(head);
        return head;
    }
    Node findLeaders(Node head)
    {
    	//base case
        if (head.next == null)
        {
            max = head.data;
            return head;
        }

        /*recursion*/
        Node list = findLeaders(head.next);
        
        //if the current value is smaller, skip it
        if (head.data < max)
            return list;

        //otherwise attach the already processed list to the next of current node
        head.next = list;

        //update max and return
        max = Math.max(head.data,max);
        return head;
    }
}