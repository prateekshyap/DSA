/*https://practice.geeksforgeeks.org/problems/sort-an-array-of-0s-1s-and-2s4231/1*/

class Solution
{
    public static void sort012(int a[], int n)
    {
        int[] counter = new int[3];
        for (int i = 0; i < n; ++i)
            ++counter[a[i]];
        int index = 0;
        for (int i = 0; i < counter[0]; ++i)
            a[index++] = 0;
        for (int i = 0; i < counter[1]; ++i)
            a[index++] = 1;
        for (int i = 0; i < counter[2]; ++i)
            a[index++] = 2; 
    }
}
