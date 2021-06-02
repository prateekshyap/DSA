/*https://practice.geeksforgeeks.org/problems/find-pair-given-difference1559/1*/

class Solution
{
    public boolean findPair(int arr[], int size, int n)
    {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        map.put(arr[0],0);
        for (int i = 1; i < size; ++i)
        {
            if (map.containsKey(arr[i]-n)) return true;
            if (map.containsKey(arr[i]+n)) return true;
            map.put(arr[i],i);
        }
        return false;
    }
}