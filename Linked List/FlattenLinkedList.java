/*https://practice.geeksforgeeks.org/problems/flattening-a-linked-list/1*/

class GfG
{
    Node flatten(Node root)
    {
	    Node right = root;
	    Node down = root;
	    Node temp = root;
	    right = root.next;
	    Node newList = null;
	    if (right != null && right.next != null)
	        newList = right.next;
	    boolean listChanged = false;
	    while (right != null)
	    {
	        if (down.data > right.data)
	        {
	            temp = right.bottom;
	            right.bottom = down;
	            if (root == down)
	            {
	                root = right;
	                down = right;
	            }
	            else
	                down = right;
                right = temp;
                continue;
	        }
	        while (down.bottom != null && down.bottom.data < right.data)
	            down = down.bottom;
            if (right.bottom != null)
                temp = right.bottom;
            else
            {
                temp = newList;
                if (newList != null && newList.next != null)
                    newList = newList.next;
                else
                    newList = null;
                listChanged = true;
            }
            right.bottom = down.bottom;
            down.bottom = right;
            right = temp;
            if (listChanged)
            {
                down = root;
                listChanged = false;
            }
	    }
	    return root;
    }
}