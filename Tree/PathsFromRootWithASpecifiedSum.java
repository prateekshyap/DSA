/*https://practice.geeksforgeeks.org/problems/paths-from-root-with-a-specified-sum/1*/

class Solution
{
    static ArrayList<ArrayList<Integer>> result;
    public static ArrayList<ArrayList<Integer>> printPaths(Node root, int sum)
    {
        //code here
        result = new ArrayList<ArrayList<Integer>>();
        traversePreOrder(root, sum, 0, new ArrayList<Integer>());
        return result;
    }
    public static void traversePreOrder(Node root, int sum, int currSum, ArrayList<Integer> currPath)
    {
        if (root != null)
        {
            currSum += root.data;
            currPath.add(root.data);
            if (currSum == sum)
            {
                ArrayList<Integer> newList = new ArrayList<Integer>();
                for (Integer element : currPath)
                    newList.add(element);
                result.add(newList);
            }
            
            traversePreOrder(root.left, sum, currSum, currPath);
            traversePreOrder(root.right, sum, currSum, currPath);
            
            currSum -= root.data;
            currPath.remove(currPath.size()-1);
        }
    }
}