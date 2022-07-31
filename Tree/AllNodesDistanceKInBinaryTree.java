/*https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    Map<Integer,List<Integer>> graph;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        graph = new HashMap<Integer,List<Integer>>();
        buildGraph(root,null);
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(target.val);
        int level = 0, node, len, i;
        boolean flag;
        List<Integer> result = new ArrayList<Integer>();
        if (k == 0)
        {
            result.add(target.val);
            return result;
        }
        boolean[] visited = new boolean[501];
        while (!queue.isEmpty())
        {
            flag = false;
            len = queue.size();
            for (i = 0; i < len; ++i)
            {
                node = queue.poll();
                if (visited[node]) continue;
                visited[node] = true;
                flag = true;
                for (Integer adjNode : graph.get(node))
                    queue.add(adjNode);
            }
            if (flag) ++level;
            if (level == k)
            {
                for (Integer elem : queue)
                    if (!visited[elem])
                        result.add(elem);
                break;
            }
        }
        return result;
    }
    private void buildGraph(TreeNode node, TreeNode parent)
    {
        if (node == null) return;
        if (!graph.containsKey(node.val)) graph.put(node.val,new ArrayList<Integer>());
        if (parent != null)
        {
            graph.get(parent.val).add(node.val);
            graph.get(node.val).add(parent.val);
        }
        buildGraph(node.left,node);
        buildGraph(node.right,node);
    }
}