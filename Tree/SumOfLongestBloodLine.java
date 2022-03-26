/*https://practice.geeksforgeeks.org/problems/sum-of-the-longest-bloodline-of-a-tree/1#*/

class Solution
{
    ArrayList<ArrayList<Integer>> paths;
    public int sumOfLongRootToLeafPath(Node root)
    {
        //code here
        paths = new ArrayList<ArrayList<Integer>>();
        recur(root,0,0);
        int maxLength = -1, maxSum = 0;
        for (ArrayList<Integer> path : paths)
        {
            if ((Integer)path.get(0) > maxLength)
            {
                maxLength = (Integer)path.get(0);
                maxSum = (Integer)path.get(1);
            }
            else if ((Integer)path.get(0) == maxLength)
                maxSum = Math.max(maxSum,(Integer)path.get(1));
        }
        return maxSum;
    }
    public void recur(Node root, int length, int sum)
    {
        if (root == null) return;
        if (root.left == null && root.right == null)
        {
            ++length;
            sum += root.data;
            ArrayList<Integer> temp = new ArrayList<Integer>();
            temp.add(length);
            temp.add(sum);
            paths.add(temp);
        }
        recur(root.left,length+1,sum+root.data);
        recur(root.right,length+1,sum+root.data);
    }
}