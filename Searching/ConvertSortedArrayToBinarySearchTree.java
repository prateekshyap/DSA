/*https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/*/

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
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Stack<Data> dataStack = new Stack<Data>();
        dataStack.push(new Data(0,nums.length-1,null));
        while (!dataStack.isEmpty())
        {
            Data curr = dataStack.pop();

            TreeNode currNode = new TreeNode(nums[curr.mid]);
            if (root == null) root = currNode;
            else
            {
                if (currNode.val < curr.parent.val)
                    curr.parent.left = currNode;
                else
                    curr.parent.right = currNode;
            }
            
            //if the right subtree has more than one nodes then push the right subtree range
            if (curr.mid != curr.end) dataStack.push(new Data(curr.mid+1,curr.end,currNode));
            //if the left subtree has more than one nodes then push the left subtree range
            if (curr.start != curr.mid) dataStack.push(new Data(curr.start,curr.mid-1,currNode));
        }
        return root;
    }
}