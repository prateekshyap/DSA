/*https://practice.geeksforgeeks.org/problems/union-of-two-sorted-arrays/1*/

class Solution
{
    public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m)
    {
        HashMap<Integer,Boolean> map = new HashMap<Integer,Boolean>();
        for (int i = 0; i < n; ++i)
            map.put(arr1[i],true);
        for (int i = 0; i < m; ++i)
            map.put(arr2[i],true);
        ArrayList<Integer> list = new ArrayList<Integer>(map.keySet());
        Collections.sort(list);
        return list;
    }
}