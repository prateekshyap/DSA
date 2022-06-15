/*https://practice.geeksforgeeks.org/problems/transform-to-sum-tree/1*/
/*https://binarysearch.com/problems/Elephant-Tree*/

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

class Solution {
    public Tree solve(Tree root) {
        recur(root);
        return root;
    }
    public int recur(Tree root)
    {
        if (root == null) return 0;
        recur(root.left);
        recur(root.right);
        if (root.left != null) root.val += root.left.val;
        if (root.right != null) root.val += root.right.val;
        return root.val;
    }
}

class Solution {
    public Tree solve(Tree root) {
        recur(root);
        return root;
    }
    public int recur(Tree root)
    {
        if (root == null) return 0;
        if (root.left != null) root.val += recur(root.left);
        if (root.right != null) root.val += recur(root.right);
        return root.val;
    }
}

class Solution {
    public Tree solve(Tree root) {
        if (root.left == null && root.right == null) return root;

        if (root.left == null) root.val += solve(root.right).val;
        else if (root.right == null) root.val += solve(root.left).val;
        else root.val += solve(root.right).val+solve(root.left).val;
        
        return root;
    }
}