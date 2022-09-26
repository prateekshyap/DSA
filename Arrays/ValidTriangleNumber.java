/*https://leetcode.com/problems/valid-triangle-number/*/

class Solution {
    public int triangleNumber(int[] nums) {
        if (nums.length <= 2) return 0;
        Arrays.sort(nums);
        int n = nums.length;
        int i = 0, j = 0, result = 0;
        for (i = 0; i < n-2; ++i)
        {
            for (j = i+1; j < n-1; ++j)
            {
                int index = -1, low = j+1, high = n-1, mid;
                while (low <= high)
                {
                    mid = low+(high-low)/2;
                    if (nums[i]+nums[j] > nums[mid])
                    {
                        index = mid;
                        low = mid+1;
                    }
                    else high = mid-1;
                }
                result += Math.max(0,index-j);
            }
        }
        return result;
    }
}

class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int count = 0, n = nums.length;
        for (int i = n-1; i >= 2; --i)
        {
            int l = 0, r = i-1;
            while (l < r)
            {
                if (nums[l] + nums[r] > nums[i])
                {
                    count += r-l;
                    --r;
                }
                else ++l;
            }
        }
        return count;
    }
}