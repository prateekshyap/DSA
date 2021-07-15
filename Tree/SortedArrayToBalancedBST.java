/*https://practice.geeksforgeeks.org/problems/array-to-bst4443/1*/

//GFG version without creating a tree and using iterative preorder travresal technique
class Data
{
    int start;
    int mid;
    int end;
    Data(int s, int e)
    {
        start = s;
        end = e;
        mid = (s+e)/2;
    }
}

class Solution
{
    public int[] sortedArrayToBST(int[] nums)
    {
        int[] result = new int[nums.length];
        int index = 0;

        //create a stack and push the range of the array
        Stack<Data> stack = new Stack<Data>();
        stack.push(new Data(0,nums.length-1));

        //till the stack becomes empty
        while (!stack.isEmpty())
        {
        	//pop the current data from stack
            Data curr = stack.pop();

            //store the corresponding element in the result
            result[index++] = nums[curr.mid];
            
            //if the right subtree has more than one nodes then push the right subtree range
            if (curr.mid != curr.end) stack.push(new Data(curr.mid+1,curr.end));
            //if the left subtree has more than one nodes then push the left subtree range
            if (curr.start != curr.mid) stack.push(new Data(curr.start,curr.mid-1));
        }

        return result;
    }
}

/*https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/*/

//Leetcode version by creating a tree and using same iterative preorder technique
class Data
{
    int start;
    int mid;
    int end;
    TreeNode parent;
    Data(int s, int e, TreeNode node)
    {
        start = s;
        end = e;
        mid = (s+e)/2;
        parent = node;
    }
}

class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = null;

        //create a stack and push the range of the array
        Stack<Data> stack = new Stack<Data>();
        stack.push(new Data(0,nums.length-1,null));

        //till the stack becomes empty
        while (!stack.isEmpty())
        {
            //pop the current data from stack
            Data curr = stack.pop();

            //create a new node for the data
            TreeNode currNode = new TreeNode(nums[curr.mid]);

            //attach it to the proper place
            //if root is null then attach to root
            if (root == null) root = currNode;
            else
            {
                //if value is less than parent attach as left child else as right child
                if (currNode.val < curr.parent.val) curr.parent.left = currNode;
                else curr.parent.right = currNode;
            }
            
            //if the right subtree has more than one nodes then push the right subtree range along with parent
            if (curr.mid != curr.end) stack.push(new Data(curr.mid+1,curr.end,currNode));
            //if the left subtree has more than one nodes then push the left subtree range along with parent
            if (curr.start != curr.mid) stack.push(new Data(curr.start,curr.mid-1,currNode));
        }
        return root;
    }
}