/*https://practice.geeksforgeeks.org/problems/flattening-a-linked-list/1*/

class GfG
{
    Node flatten(Node root)
    {
	    Node right = root; //keeps track of the elements of the list present at the right of current list
	    Node down = root; //keeps track of the elements of the current list
	    Node temp = root; //a temporary pointer to hold things temporarily
	    right = root.next; //set right pointer to the second list
	    Node newList = null; //keeps track of the rest of the lists
	    if (right != null && right.next != null)
	        newList = right.next;
	    boolean listChanged = false; //indicates true when we are done merging two lists and heading towards the next

	    //till we have more lists to the right
	    while (right != null)
	    {
	    	/*unusual case*/
	    	//if the data at the current node is greater than the data at the first node of next list at the right
	        if (down.data > right.data)
	        {
	        	//move pointer to the next bottom node of the right list
	            temp = right.bottom;

	            //attach current node to the bottom of the smaller node
	            right.bottom = down;

	            //if down pointer is same as root
	            if (root == down)
	            {
	            	//move both
	                root = right;
	                down = right;
	            }

	            //otherwise move only down pointer to the right
	            else
	                down = right;

	            //make right to point temp
                right = temp;

                //continue with the while loop
                continue;
	        }

	        /*usual cases*/
	        //move the down pointer downwards till the data is less than the node at the right pointer
	        while (down.bottom != null && down.bottom.data < right.data)
	            down = down.bottom;

	        //if the right list is not exhausted
            if (right.bottom != null)
            	//hold the rest of the elements in temp
                temp = right.bottom;
            //if the right list is exhausted
            else
            {
            	//hold the rest of the lists in temp
                temp = newList;

                //move the newList pointer
                if (newList != null && newList.next != null)
                    newList = newList.next;
                else
                    newList = null;

                //indicate that the list is changed
                listChanged = true;
            }
            //insert the right node after the down pointer
            right.bottom = down.bottom;
            down.bottom = right;

            //set the right pointer
            right = temp;

            //if the list is changed
            if (listChanged)
            {
            	//start from the beginning and reset the indicator
                down = root;
                listChanged = false;
            }
	    }
	    return root;
    }
}

/*https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/*/

class Solution {
    public Node flatten(Node head) {
        if (head == null) return null;
        
        Node newHead = head, temp = head;
        
        while (temp != null)
        {
            while (temp.child == null && temp.next != null)
                temp = temp.next;

            if (temp.child == null) return head;

            Node rest = temp.next;
            temp.next = flatten(temp.child);
            temp.next.prev = temp;
            temp.child = null;
            while (temp.next != null)
                temp = temp.next;
            temp.next = rest;
            if (rest != null)
                rest.prev = temp;
        }
        
        return newHead;
    }
}