/*https://practice.geeksforgeeks.org/problems/rotate-and-delete-1587115621/1*/

class Solution
{
    public static int rotateDelete(ArrayList<Integer> arr, int n)
    {
        for (int i = 1; i < n; ++i)
        {
            int temp = arr.get((arr.size() - 1));
            arr.add(0, temp);
            arr.remove((arr.size()-1));
            if((arr.size()-i) < 0)
                arr.remove(0);
            else
                arr.remove(arr.size()-i);
           
        }
        return arr.get(0);
    }
}