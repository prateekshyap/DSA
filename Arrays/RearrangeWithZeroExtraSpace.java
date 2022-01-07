/*https://practice.geeksforgeeks.org/problems/rearrange-an-array-with-o1-extra-space3142/1*/

class Solution
{
    static void arrange(long arr[], int n)
    {
        // your code here
        for (int i = 0; i < n; ++i)
            arr[i] = arr[i]+((arr[(int)arr[i]]%n)*n);
        for (int i = 0; i < n; ++i)
            arr[i] = arr[i]/n;
    }
}