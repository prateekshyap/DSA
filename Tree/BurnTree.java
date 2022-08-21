/*https://practice.geeksforgeeks.org/problems/burning-tree/1*/
/*https://leetcode.com/problems/amount-of-time-for-binary-tree-to-be-infected/*/

class Solution
{
    static int max;
    public static int minTime(Node root, int target) 
    {
        max = 0;
        burn(root, target, 0);
        return max;
    }
    public static int burn(Node root, int target, int top)
    {
        if (root == null) return 0;
        if (root.left == null && root.right == null && root.data == target) return -1;
        int left = burn(root.left,target,top+1);
        int right = burn(root.right,target,top+1);
        if (left < 0)
        {
            max = Math.max(max,Math.abs(left)+Math.max(right,top));
            return left-1;
        }
        if (right < 0)
        {
            max = Math.max(max,Math.abs(right)+Math.max(left,top));
            return right-1;
        }
        return 1+Math.max(left,right);
    }
}

class Solution
{
    /*class Node {
        int data;
        Node left;
        Node right;
    
        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }*/
    
    static HashMap<Integer,ArrayList<Integer>> graph;
    public static int minTime(Node root, int target) 
    {
        graph = new HashMap<Integer,ArrayList<Integer>>();
        buildGraph(root,null); //convert tree to graph
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(target);
        boolean flag;
        int len, i, result = -1, node;
        boolean[] visited = new boolean[10001];

        //BFS and counting levels
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
            if (flag) ++result;
        }
        return result;
    }
    private static void buildGraph(Node node, Node parent)
    {
        if (node == null) return;
        if (!graph.containsKey(node.data)) graph.put(node.data,new ArrayList<Integer>());
        if (parent != null)
        {
            graph.get(node.data).add(parent.data);
            graph.get(parent.data).add(node.data);
        }
        buildGraph(node.left,node);
        buildGraph(node.right,node);
    }
}