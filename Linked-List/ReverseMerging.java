/*https://practice.geeksforgeeks.org/problems/merge-2-sorted-linked-list-in-reverse-order/1*/

class GfG
{
    Node mergeResult(Node node1, Node node2)
    {
	    // Your code here
	    Node head = new Node(0);
	    Node temp;
	    while (node1 != null || node2 != null)
	    {
	        if (node1 == null || (node2 != null && node2.data < node1.data))
	        {
	            temp = node2;
	            node2 = node2.next;
	            temp.next = head.next;
	            head.next = temp;
	        }
	        else
	        {
	            temp = node1;
	            node1 = node1.next;
	            temp.next = head.next;
	            head.next = temp;
	        }
	    }
	    
	    return head.next;
    }
}