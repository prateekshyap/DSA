/*https://leetcode.com/problems/count-primes/*/

class Solution {
    public int countPrimes(int n) {
        // initialize boolean array, false is prime ,true is composite
        boolean [] isPrime = new boolean[n] ;
        int count = 0;
        // start from i = 2, as 0 and 1 are not prime.
        for (int i = 2; i < n; ++i)
        {
            if (isPrime[i] == false)
            {
                // if ith index is prime
                count++;
                // start from i and keep jumping to muliples of i and keep marking them as composite
                for (int j = i ; j < n; j = j+i)
                    isPrime[j] = true;
            }
        }
        return count;
    }
}