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
