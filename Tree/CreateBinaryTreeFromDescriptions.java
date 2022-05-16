/*https://leetcode.com/problems/create-binary-tree-from-descriptions/*/

class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer,TreeNode> map = new HashMap<Integer,TreeNode>();
        HashSet<Integer> set = new HashSet<Integer>();
        int i;
        TreeNode curr;
        
        for (i = 0; i < descriptions.length; ++i)
        {
            set.add(descriptions[i][0]); set.add(descriptions[i][1]);
            map.put(descriptions[i][0],new TreeNode(descriptions[i][0]));
            map.put(descriptions[i][1],new TreeNode(descriptions[i][1]));
        }
        
        for (i = 0; i < descriptions.length; ++i)
        {
            curr = map.get(descriptions[i][0]);
            if (descriptions[i][2] == 1) curr.left = map.get(descriptions[i][1]);
            else if (descriptions[i][2] == 0) curr.right = map.get(descriptions[i][1]);
            set.remove(descriptions[i][1]);
        }
        Iterator it = set.iterator();
        if (it.hasNext()) return (TreeNode)(map.get(it.next()));
        return null;
    }
}