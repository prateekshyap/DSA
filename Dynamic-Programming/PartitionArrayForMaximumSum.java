/*https://leetcode.com/problems/partition-array-for-maximum-sum/*/

/*
recur for the rest of the array by taking the maximum of the current subarray

e.g.

1,4,1,5,7,3,6,1,9,9,3
k = 4

maximum of (	recursion on 1,4,1,5,7,3,6,1,9,9 + maximum of (3),
				recursion on 1,4,1,5,7,3,6,1,9 + maximum of (9,3),
				recursion on 1,4,1,5,7,3,6,1 + maximum of (9,9,3),
				recursion on 1,4,1,5,7,3,6 + maximum of (1,9,9,3),	)

base case will be when the size of the remaining subarray on the left is less than k

*/

class Solution {
    Integer[] dp;
    public int maxSumAfterPartitioning(int[] arr, int k) {
        dp = new Integer[arr.length+1];
        return recur(arr, k, arr.length-1);
    }
    public int recur(int[] a, int k, int end)
    {
        if (dp[end] != null) return dp[end]; //if already calculated, return it
        
        if (end < k) //when subarray size goes below k
        {
        	//find the maximum of the subarray
            int max = a[0];
            for (int i = 1; i <= end; ++i) if (a[i] > max) max = a[i];
            dp[end] = max*(end+1); //store in table by multiplying the number of elements in the subarray
            return dp[end]; //return the result
        }
        
        int result = 0, max = 0, rest, i, j;
        
        for (i = end-1; i >= end-k; --i) //move from the end of the current subarray towards left
        {
            rest = recur(a,k,i); //call recursion for the rest of the subarray
            //find maximum of the current subarray
            max = a[end];
            for (j = end; j > i; --j)
                max = Math.max(max,a[j]);
            result = Math.max(result,(max*(end-i))+rest); //result will be the sum of maximum of current subarray and the result of the recursion call
        }
        
        //store the result and return
        dp[end] = result;
        return dp[end];
    }
}

//faster on leetcode, same time complexity
class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[] dp=new int[arr.length+1];
        dp[0]=0;
        dp[1]=arr[0];
        for(int i=1;i<arr.length;i++)
             dp[i+1]=getMax(arr,i,k,dp);
        return dp[dp.length-1]; 
    }
    
    public int getMax(int[] arr,int i,int k,int[] dp){
        int max=0;
        int c=1;
        int v=0;
        while(i>=0 && k>0){
            max=Math.max(arr[i],max);
            v=Math.max(v,dp[i]+c*max);
            i--;
            k--;
            c++;
        }
        return v;
    }
    
}