/*https://practice.geeksforgeeks.org/problems/lowest-common-ancestor-in-a-bst/1*/

class BST
{    
	Node LCA(Node root, int n1, int n2)
	{
		//edge cases
        if (root == null)
            return null;
        if (n1 == root.data || n2 == root.data)
            return root;

        //keep modifying the values on the path to n1, except n1 itself
        Node temp = root;
        while (temp != null && temp.data != n1)
        {
            if (n1 < temp.data)
            {
                temp.data += 1;
                temp.data *= -1;
                temp = temp.left;
            }
            else if (n1 > temp.data)
            {
                temp.data += 1;
                temp.data *= -1;
                temp = temp.right;
            }
        }

        //again start from root
        temp = root;
        Node parent = root;
        Node answer = temp;

        //till we get modified values
        while (temp.data < 0)
        {
        	//restore the original value
            temp.data += 1;
            temp.data *= (-1);

            //if it is equal to n1 or n2, return it
            if (temp.data == n2 || temp.data == n1)
                return temp;

            //otherwise move
            else
            {
                parent = temp;
                temp = (temp.data < n2) ? temp.right : temp.left;
            }
        }

        //if we again reached n1, it is the answer itself
        if (temp.data == n1)
            answer = temp;

        //otherwise, the last modified node will be the answer
        else if (temp.data != n1)
            answer = parent;
        
        return answer;
    }   
}