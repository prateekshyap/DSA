/*https://practice.geeksforgeeks.org/problems/union-of-two-arrays3538/1*/

class Solution{
    public static int doUnion(int a[], int n, int b[], int m) 
    {
        HashMap<Integer,Boolean> map = new HashMap<Integer,Boolean>();
        for (int i = 0; i < n; ++i)
            map.put(a[i],true);
        for (int i = 0; i < m; ++i)
            map.put(b[i],true);
        return map.size();
    }
}