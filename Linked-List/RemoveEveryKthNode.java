/*https://practice.geeksforgeeks.org/problems/remove-every-kth-node/1*/

class GfG
{
    Node delete(Node head, int k)
    {
        if (k == 1) return null;
	    Node temp = head;
	    int i = k-2;
	    while (temp != null && temp.next != null)
	    {
	        if (i == 0 && temp.next != null)
	        {
	            temp.next = temp.next.next;
	            i = k-1;
	        }
	        temp = temp.next;
	        --i;
	    }
	    return head;
    }
}