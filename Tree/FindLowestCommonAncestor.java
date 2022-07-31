/*https://practice.geeksforgeeks.org/problems/lowest-common-ancestor-in-a-bst/1*/
/*https://practice.geeksforgeeks.org/problems/lowest-common-ancestor-in-a-binary-tree/1*/
/*https://binarysearch.com/problems/Lowest-Common-Ancestor*/

//for BST, path modification approach
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

//for BST, another simple approach
class BST
{    
    Node LCA(Node root, int n1, int n2)
    {
        if (root == null)
            return null;
   
        // If both n1 and n2 are smaller than root, then LCA lies in left
        if (root.data > n1 && root.data > n2)
            return LCA(root.left, n1, n2);
   
        // If both n1 and n2 are greater than root, then LCA lies in right
        if (root.data < n1 && root.data < n2) 
            return LCA(root.right, n1, n2);
   
        return root;
    }   
}

//for binary tree, tree traversal approach
class Solution
{
    boolean n1Present = false, n2Present = false;
    Node lca(Node root, int n1,int n2)
    {
        Node lca = findLCA(root,n1,n2);
        if (n1Present && n2Present) return lca;
        return null;
    }
    Node findLCA(Node root, int n1, int n2)
    {
        //base case
        if (root == null)
            return null;
 
        Node temp=null;
 
        //mark the presence of the given nodes
        if (root.data == n1)
        {
            n1Present = true;
            temp = root;
        }
        if (root.data == n2)
        {
            n2Present = true;
            temp = root;
        }
 
        // Look for keys in left and right subtrees
        Node left = findLCA(root.left, n1, n2);
        Node right = findLCA(root.right, n1, n2);
 
        if (temp != null)
            return temp;
 
        //if both are non null, root is the LCA
        if (left != null && right != null)
            return root;
 
        // Otherwise check if left subtree or right subtree is LCA
        return (left  != null) ? left  : right;
    }
}

//binary tree
class Solution {
    public int solve(Tree root, int a, int b) {
        if (root == null) return -1;
        if (root.val == a || root.val == b) return root.val;
        int left = solve(root.left, a, b);
        int right = solve(root.right, a, b);
        if (left != -1 && right != -1) return root.val;
        if (left != -1) return left;
        if (right != -1) return right;
        return -1;
    }
}