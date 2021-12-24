/*https://practice.geeksforgeeks.org/problems/maximum-difference-between-node-and-its-ancestor/1*/

class Tree
{
    //Function to return the maximum difference between any 
    //node and its ancestor.
    int result = Integer.MIN_VALUE;
    int maxDiff(Node root)
    {
        //your code here
        result = Integer.MIN_VALUE;
        maxDiffUtil(root);
        return result;
    }
    
    int maxDiffUtil(Node node)
    {
        /* Returning Maximum int value if node is not
           there (one child case)  */
        if (node == null)
            return Integer.MAX_VALUE;
          
        /* If leaf node then just return node's value  */
        if (node.left == null && node.right == null)
            return node.data;
  
        /* Recursively calling left and right subtree
           for minimum value  */
        int val = Math.min(maxDiffUtil(node.left), maxDiffUtil(node.right));
  
        /* Updating res if (node value - minimum value
           from subtree) is bigger than res  */
        result = Math.max(result, node.data-val);
  
        /* Returning minimum value got so far */
        return Math.min(val, node.data);
    }
}