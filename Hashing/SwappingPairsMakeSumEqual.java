/*https://practice.geeksforgeeks.org/problems/swapping-pairs-make-sum-equal4142/1/*/

class Solution
{
    long findSwapValues(long A[], int n, long  B[], int m)
    {
        // Your code goes here
        long sum1 = 0, sum2 = 0;
        int i, j;
        for (long element : A) sum1 += element;
        for (long element : B) sum2 += element;
        long diff = sum1-sum2;
        if (diff%2 != 0) return -1;
        diff /= 2;
        HashSet<Long> set = new HashSet<Long>();
        for (long element : A) set.add(element);
        for (long element : B) if (set.contains(element+diff)) return 1;
        return -1;
    }
}