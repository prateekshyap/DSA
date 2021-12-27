/*https://practice.geeksforgeeks.org/problems/print-nodes-having-k-leaves/1*/

class Solution
{
    ArrayList<Integer> result;
    public ArrayList<Integer> btWithKleaves(Node root, int k)
    {
        result = new ArrayList<Integer>();
        recur(root,k);
        if (result.size() == 0) result.add(-1);
        return result;
    }
    public int recur(Node root,int k)
    {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
        {
            if (k == 0) result.add(root.data);
            return 1;
        }
        int leftSubtreeCount = recur(root.left,k);
        int rightSubtreeCount = recur(root.right,k);
        if (leftSubtreeCount+rightSubtreeCount == k) result.add(root.data);
        return leftSubtreeCount+rightSubtreeCount;
    }
}