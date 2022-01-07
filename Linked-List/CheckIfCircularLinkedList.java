/*https://practice.geeksforgeeks.org/problems/circular-linked-list/1*/

class GfG
{
    boolean isCircular(Node head)
    {
	    Node curr = head;
	    while (curr.next != null)
	    {
	        curr = curr.next;
	        if (curr == head)
	            return true;
	    }
	    return false;
    }
}