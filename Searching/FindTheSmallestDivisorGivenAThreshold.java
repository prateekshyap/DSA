/*https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/*/

class Solution {
    int[] nums;
    int threshold;
    public int smallestDivisor(int[] nums, int threshold) {
        this.nums=  nums;
        this.threshold = threshold;
        int n = nums.length, low = 1, high = 0, mid, result = -1;
        for (int num : nums)
            high = Math.max(high,num);
        
        while (low <= high)
        {
            mid = low+(high-low)/2;
            if (isFeasible(mid))
            {
                result = mid;
                high = mid-1;
            }
            else low = mid+1;
        }
        
        return result;
    }
    private boolean isFeasible(int target)
    {
        double sum = 0;
        for (int num : nums)
            sum += Math.ceil((double)num/(double)target);
        return (int)sum <= threshold;
    }
}

class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int left = 1, right = Integer.MIN_VALUE;
        for(int num : nums) right = Math.max(right, num);
        
        while(left <= right) {
            int pivot = left + (right - left) / 2;
            int count = 0;
            for(int num : nums) count += (num - 1) / pivot + 1;
            
            if(count > threshold) left = pivot + 1;
            else right = pivot - 1;
        }
        
        return left;
    }
}