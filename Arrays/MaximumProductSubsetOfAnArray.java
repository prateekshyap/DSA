/*https://practice.geeksforgeeks.org/problems/maximum-product-subset-of-an-array/1/*/

class Solution {
    public static int findMaxProduct(int n, int[] arr) {
        int maxneg = Integer.MIN_VALUE;
        boolean hasOne = false;
        boolean hasZero = false;
        long prod = 1;
        long mod = (long)1e9+7;
        
        for(int i=0; i<n; i++)
        {
            if(arr[i] != 0)
                prod = (prod * arr[i])%mod;
            else
                hasZero = true;
            if(arr[i] == 1)
                hasOne = true;
            if(arr[i] < 0)
                maxneg = Math.max(maxneg, arr[i]);
        }
        if(prod < 0)
            prod /= maxneg;
        
        if(prod == 1 && !hasOne && hasZero)
            return 0;
        if(prod == 1 && !hasOne && !hasZero)
            return maxneg;
        
        return (int)(prod%mod);
    }
}