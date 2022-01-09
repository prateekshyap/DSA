/*https://practice.geeksforgeeks.org/problems/large-factorial4721/1/*/

class Solution {
    long[] hash;
    public long[] factorial(long a[], int n) {
        long[] result = new long[a.length];
        int max = Integer.MIN_VALUE;

        //find out the maximum value
        for (int i = 0; i < n; ++i)
            if (a[i] > max)
                max = (int) a[i];

        //find out all the factorials till maximum value
        hash = new long[max+1];
        hash[0] = hash[1] = 1;
        for (int i = 2; i <= max; ++i)
            hash[i] = (hash[i-1]*i)%(1000000007);

        //store the required results
        for (int i = 0; i < n; ++i)
            result[i] = hash[(int)a[i]];
        return result;
    }
}