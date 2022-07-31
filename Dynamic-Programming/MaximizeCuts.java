/*https://practice.geeksforgeeks.org/problems/cutted-segments1642/1/*/

class Solution
{
    public int maximizeCuts(int n, int x, int y, int z)
    {
        int[] table = new int[n+1];
        /*
        If i-x is 0 then we can add 1 to it
        Otherwise if table[i-x] is non-zero then only we can add 1 to it
        If table[i-x] is 0, that simply means we cannot cut that further
        Same for y and z too
        */
        for (int i = 1; i <= n; ++i)
        {
            int max = Integer.MIN_VALUE;
            max = Math.max(max,(i-x == 0 || (i-x > 0 && table[i-x] > 0) ? table[i-x]+1 : 0));
            max = Math.max(max,(i-y == 0 || (i-y > 0 && table[i-y] > 0) ? table[i-y]+1 : 0));
            max = Math.max(max,(i-z == 0 || (i-z > 0 && table[i-z] > 0) ? table[i-z]+1 : 0));
            table[i] = max;
        }
        return table[n];
    }
}

class Solution
{
    Integer[] store;
    //Function to find the maximum number of cuts.
    public int maximizeCuts(int n, int x, int y, int z)
    {
       //Your code here
       store = new Integer[n+1];
       store[n] = cut(n,x,y,z);
       return store[n] == Integer.MIN_VALUE ? 0 : store[n];
    }
    public int cut(int n, int x, int y, int z)
    {
        if (n == 0) return 0;
        if (store[n] != null) return store[n];
        int result = 0;
        if (n >= x) result = Math.max(result,cut(n-x,x,y,z)+1);
        if (n >= y) result = Math.max(result,cut(n-y,x,y,z)+1);
        if (n >= z) result = Math.max(result,cut(n-z,x,y,z)+1);
        if (result == 0)
            store[n] = Integer.MIN_VALUE;
        else store[n] = result;
        return store[n];
    }
}
