/*https://practice.geeksforgeeks.org/problems/min-distance-between-two-given-nodes-of-a-binary-tree/1/*/
 
class GfG {
    boolean n1Present = false, n2Present = false;
    int findDist(Node root, int n1, int n2) {
    	//find the LCA node
        Node lca = findLCA(root,n1,n2);

        //if any of the two values is not present then return -1
        if (!n1Present || !n2Present) return -1;

        //find the distances of all three nodes from root
        int n1Distance = findDistanceFromRoot(root,n1);
        int n2Distance = findDistanceFromRoot(root,n2);
        int lcaDistance = findDistanceFromRoot(root,lca.data);

        //since the path from root to the lca is traversed twice
        return n1Distance+n2Distance-(2*lcaDistance);
    }
    int findDistanceFromRoot(Node root, int data)
    {
    	//return -1 if reached dead end
        if (root == null)
            return -1;

        //return 0 if data found
        if (root.data == data)
            return 0;

        //find the same for left and right subtrees if data not found yet
        int left = findDistanceFromRoot(root.left,data);
        int right = findDistanceFromRoot(root.right,data);

        //if both are -1 then return -1
        if (left == -1 && right == -1) return -1;

        //otherwise add 1 to the non -1 value and return
        return left == -1 ? right+1 : left+1;
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