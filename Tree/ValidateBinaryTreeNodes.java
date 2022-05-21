/*https://leetcode.com/problems/validate-binary-tree-nodes/*/

/*Normal Tree Based Solution*/

class TreeNode
{
    int data;
    TreeNode left;
    TreeNode right;
    TreeNode(int d)
    {
        data = d;
    }
}

class Solution {
    boolean result;
    boolean[] visited;
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        HashMap<Integer,TreeNode> treeMap = new HashMap<Integer,TreeNode>();
        HashSet<Integer> possibleRoots = new HashSet<Integer>();
        int i;
        result = true;
        visited = new boolean[n];
        for (i = 0; i < n; ++i) //for each node
        {
            possibleRoots.add(i); //add to possible roots
            treeMap.put(i,new TreeNode(i)); //add a node in the map
        }
        for (i = 0; i < n; ++i) //for each node
        {
            if (leftChild[i] != -1) //if left child is present
            {
                ((TreeNode)treeMap.get(i)).left = (TreeNode)treeMap.get(leftChild[i]); //store it
                possibleRoots.remove(new Integer(leftChild[i])); //remove from possible roots
            }
            if (rightChild[i] != -1) //if right child is present
            {
                ((TreeNode)treeMap.get(i)).right = (TreeNode)treeMap.get(rightChild[i]); //store it
                possibleRoots.remove(new Integer(rightChild[i])); //remove from possible roots
            }
        }
        Iterator it = possibleRoots.iterator();
        if (it.hasNext()) //if there is a root
            inOrder((TreeNode)treeMap.get((Integer)it.next())); //run recursion on it
        else result = false; //if no root, result is false
        if (it.hasNext()) //if there is a second root
            result = false; //result is false
        for (i = 0; i < n; ++i) //for each node
            if (!visited[i]) //if any node is unvisited
                result = false; //result is false
        return result;
    }
    public void inOrder(TreeNode root)
    {
        if (root == null || result == false) return; //if root is null or tree is already found to be invalid, return
        if (visited[root.data]) //if node is already visited
        {
            result = false; //mark invalid
            return; //return
        }
        visited[root.data] = true; //mark node as visited
        inOrder(root.left); //recur on left child
        inOrder(root.right); //recur on right child
    }
}

/*Disjoint Set Solution*/

class Solution {
    int[] parents;
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        this.parents = new int[n];
        int[] indegree = new int[n];
        int connected = n;
        for(int i=0; i<n; i++) {
            parents[i] = i;
        }
        for(int i=0; i<leftChild.length; i++) {
            if(leftChild[i] != -1) {
                if(this.union(i, leftChild[i])) {
                    indegree[leftChild[i]]++;
                    connected--;
                } else {
                    return false;
                }
                if(indegree[leftChild[i]] > 1) {
                    return false;
                }                
            }
            if(rightChild[i] != -1) {
                if(this.union(i, rightChild[i])) {
                    indegree[rightChild[i]]++;
                    connected--;
                } else {
                    return false;
                }
                if(indegree[rightChild[i]] > 1) {
                    return false;
                }                
            }
        }
        return connected ==  1;
    }
    
    private boolean union(int x, int y) {
        int setX = find(x);
        int setY = find(y);
        if(setX != setY) {
            parents[setY] = setX;
            return true;
        }
        return false;
    }
    
    private int find(int num) {
        if(parents[num] != num) {
            parents[num] = find(parents[num]);
        }
        return parents[num];
    }
}