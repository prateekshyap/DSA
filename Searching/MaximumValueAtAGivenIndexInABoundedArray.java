/*https://leetcode.com/problems/maximum-value-at-a-given-index-in-a-bounded-array/*/

class Solution {
    public int maxValue(int n, int index, int maxSum) {
        int low = 1, high = maxSum, result = -1;
        while (low <= high)
        {
            int mid = low+(high-low)/2;
            if (isMaximized(mid, index, (long)maxSum, n)) // if mid is maximized
            {
                result = mid; // store it as the current result
                low = mid+1; // increase low
            }
            else high = mid-1; // if mid could not be handled, decrease high
        }
        return result;
    }
    private boolean isMaximized(int mid, int index, long maxSum, int n)
    {
        // int left = index-1, right = index+1;
        // long currSum = mid--;
        // while (left >= 0 || right < n)
        // {
        //     if (left >= 0) currSum += mid;
        //     if (right < n) currSum += mid;
        //     if (mid > 1) --mid;
        //     --left;
        //     ++right;
        // }
        // if (currSum <= maxSum) return true;
        // return false;
        
        long currSum = 0;

        if (mid > index) // 5+6+7+8+9 = (1+2+3+4+5)*((9-5)*5) = (5*6/2)+(4*5)
            currSum += (long)(index+1)*(long)(index+2)/2+(long)(index+1)*(long)(mid-index-1);
        else
            currSum += (long)(mid+1)*mid/2+index-mid+1;
        
        if (mid >= n-index) // 
            currSum += (long)(n-index)*(n-index+1)/2+(long)(n-index)*(long)(mid-n+index);
        else
            currSum += (long)(mid+1)*mid/2+n-index-mid;
        
        return currSum-mid <= maxSum;
    }
}