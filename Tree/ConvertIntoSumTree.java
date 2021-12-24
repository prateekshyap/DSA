/*https://practice.geeksforgeeks.org/problems/transform-to-sum-tree/1*/

class Solution{
    public void toSumTree(Node root){
        if (root == null) return;

        //get the left subtree and right subtree sum
        int leftSum = postOrder(root.left);
        int rightSum = postOrder(root.right);

        //store the sum in root
        root.data = leftSum+rightSum;
    }
    public int postOrder(Node root)
    {
    	//if root is not null
        if (root != null)
        {
        	/*recursion*/
            int leftSum = postOrder(root.left);
            int rightSum = postOrder(root.right);
            
            //store the root value
            int returnValue = root.data;

            //add the sum of the subtrees to it
            returnValue += leftSum;
            returnValue += rightSum;

            //store the sum of left and right subtree in root
            root.data = leftSum+rightSum;

            //return the total sum
            return returnValue;
        }

        //return 0 if root is null
        return 0;
    }
}