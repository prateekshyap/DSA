/*https://leetcode.com/problems/longest-continuous-increasing-subsequence/*/

class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int size = nums.length;
        int[] result = new int[size];
        for (int i = 0; i < size; ++i)
            result[i] = 1;
        for (int i = 1; i < size; ++i)
            if (nums[i] > nums[i-1] && result[i] < result[i-1]+1)
                result[i] = result[i-1]+1;
        int max = result[0];
        for (int i = 1; i < size; ++i)
            if (result[i] > max)
                max = result[i];
        return max;
    }
}

class Solution {
    public int findLengthOfLCIS(int[] nums) {
          int count=1;int temp = 1;
        if(nums.length == 1) return 1;
        int i = nums.length-1;
        while(i > 0) {
        	if(nums[i] > nums[i-1]) temp++;
        	else {
        		if(temp > count) 
        			count=temp;
        		temp = 1;
        	}
        	i--;
        }
        return  temp > count? temp :count;
    }
}