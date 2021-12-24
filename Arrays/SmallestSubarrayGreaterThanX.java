/*https://practice.geeksforgeeks.org/problems/smallest-subarray-with-sum-greater-than-x5651/1*/

class Solution {

    public static long sb(long a[], long n, long x) {
        long sum = 0, minLen = Integer.MAX_VALUE;
        int start = 0, end = 0;
        
        //till elements left
        while (start < n && end < n) {
            
            //add the next element
            sum += a[start];
            
            //if end is within the array and current sum is greater than required sum
            while (end < n &&sum > x)
            {
                //calculate the minimum length from between start and end
                minLen = Math.min(minLen,start-end+1);
                
                //if minimum length becomes 1, no need to check further
                if (minLen == 1) break;
                
                //if end is within the array, subtract the element
                if (end < n) sum -= a[end];
                
                //increment index
                ++end;
            }
            
            //if minimum length becomes 1, no need to check further
            if (minLen == 1) break;
            
            //increment start
            ++start;
        }
        return minLen;
    }
}