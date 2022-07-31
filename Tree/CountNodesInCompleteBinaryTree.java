/*https://binarysearch.com/problems/Count-Nodes-in-Complete-Binary-Tree*/
/*https://leetcode.com/problems/count-complete-tree-nodes/*/

/*x*logn approach*/
import java.util.*;

/**
 * public class Tree {
 *   int val;
 *   Tree left;
 *   Tree right;
 * }
 */
class Solution {
    StringBuffer path;
    public int solve(Tree root) {
        if (root == null) return 0;
        int lh = 0;
        int rh = 0;
        Tree temp = root;
        while (temp != null)
        {
            temp = temp.left;
            ++lh;
        }
        temp = root;
        while (temp != null)
        {
            temp = temp.right;
            ++rh;
        }
        if (lh == rh) return (int)Math.pow(2,lh)-1;
        temp = root;
        int lHeight, rHeight;
        path = new StringBuffer("");
        while (temp.left != null || temp.right != null)
        {
            lHeight = height(temp.left);
            rHeight = height(temp.right);
            if (lHeight > rHeight)
            {
                temp = temp.left;
                path.append('L');
            }
            else
            {
                temp = temp.right;
                path.append('R');
            }
        }
        int val = 2, i;
        int result = 0;
        for (i = path.length()-2; i >= 0; --i)
        {
            if (path.charAt(i) == 'R') result += val;
            val *= 2;
        }
        if (path.charAt(path.length()-1) == 'L') ++result;
        else result += 2;
        return result+(int)Math.pow(2,rh)-1;
    }

    public int height(Tree root)
    {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        return Math.max(height(root.left),height(root.right))+1;
    }
}

class Solution {
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null)return 1;
        final int leftHigh = leftDepth(root.left);
        final int rightHigh = leftDepth(root.right);
        if(leftHigh > rightHigh){
            return countNodes(root.left) + (int)Math.pow(2,rightHigh);
        }else if(leftHigh == rightHigh){
            return countNodes(root.right) + (int)Math.pow(2,leftHigh);
        }else{
            return 0;
        }
    }
    private int leftDepth(TreeNode root){
        int res = 0;
        while(root != null){
            root = root.left;
            res++;
        }
        return res;
    }
}