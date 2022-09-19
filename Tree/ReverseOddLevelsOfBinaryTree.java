/*https://leetcode.com/problems/reverse-odd-levels-of-binary-tree/*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode reverseOddLevels(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        Queue<TreeNode> queue2 = new LinkedList<TreeNode>();
        boolean flag = false;
        queue.add(root);
        while (!queue.isEmpty())
        {
            int len = queue.size();
            if (flag)
            {
                ArrayList<Integer> list = new ArrayList<Integer>();
                for (int i = 0; i < len; ++i)
                {
                    TreeNode node = queue.poll();
                    list.add(node.val);
                    queue2.add(node);
                }
                for (int i = len-1; i >= 0; --i)
                {
                    TreeNode node = queue2.poll();
                    node.val = list.get(i);
                    queue.add(node);
                }
            }
            for (int i = 0; i < len; ++i)
            {
                TreeNode node = queue.poll();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            flag = !flag;
        }
        return root;
    }
}

class Solution {
    public TreeNode reverseOddLevels(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) {
            List<TreeNode> list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            if (level % 2 == 1) {
                int i = 0, j = size - 1;
                while (i < j) {
                    int temp = list.get(i).val;
                    list.get(i).val = list.get(j).val;
                    list.get(j).val = temp;
                    i++;
                    j--;
                }
            }
            level++;
        }
        return root;
    }
}

//legendary recursion


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode reverseOddLevels(TreeNode root) {
        reverse(root, root, root.left, root.right, true); 
        return root;
    }
    
    private void reverse(TreeNode parentL, TreeNode parentR, TreeNode left, TreeNode right, boolean isOdd){
        if (left == null) return;
        
        if (isOdd){
            int temp = left.val;
            left.val = right.val;
            right.val = temp;
        }
        
        reverse(left, right, left.left, right.right, !isOdd);
        reverse(left, right, left.right, right.left, !isOdd);
    }
}

