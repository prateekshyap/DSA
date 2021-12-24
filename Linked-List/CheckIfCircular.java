/*https://practice.geeksforgeeks.org/problems/circular-linked-list/1*/

class GfG
{
    boolean isCircular(Node head)
    {
	    Node curr = head;
	    while (curr.next != null)
	    {
	    	//if curr becomes equal to head at any point, return true
	        curr = curr.next;
	        if (curr == head)
	            return true;
	    }

	    //if curr reaches null before reaching head, return false
	    return false;
    }
}