/*https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/*/

class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int n = nums.length, i, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE, start = 0, end = -1, result = 0;
        TreeSet<Integer> set = new TreeSet<Integer>();
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        while (end < n-1)
        {
            ++end; //increase the window size
            map.put(nums[end],map.containsKey(nums[end]) ? (Integer)map.get(nums[end])+1 : 1); //increment its count in hashmap
            set.add(nums[end]); //add to treeset
            if (nums[end] > max) max = nums[end]; //update max in the window
            if (nums[end] < min) min = nums[end]; //update min in the window
            while (max-min > limit) //till the difference is more than limit
            {
                if (map.get(nums[start]) == 1) //if the first element of the window is present only once
                {
                    map.remove(nums[start]); //remove it from hashmap
                    set.remove(nums[start]); //remove it from treeset
                }
                else map.put(nums[start],(Integer)map.get(nums[start])-1); //otherwise decrease its count
                if (!map.containsKey(nums[start])) //if the element is removed from the map and set
                {
                    if (max == nums[start]) max = set.lower(nums[start]); //update max from treeset
                    if (min == nums[start]) min = set.higher(nums[start]); //update min from treeset
                }
                ++start; //reduce the window size
            }
            if (max-min <= limit && end-start+1 > result) result = end-start+1; //update the result
        }
        return result;
    }
}

class Solution {
    public int longestSubarray(int[] nums, int limit) {
        
        
        if (nums.length == 1) return 1;
        
        int i = 0, j;
        
        int[] maxd = new int[nums.length + 2];
        int hhmax = 0, ttmax = -1;
        int[] mind = new int[nums.length + 2];
        int hhmin = 0, ttmin = -1;
        
        for (j = 0; j < nums.length; ++j) {
            
            while (hhmax <= ttmax && nums[maxd[ttmax]] <= nums[j]) --ttmax;
            while (hhmin <= ttmin && nums[mind[ttmin]] >= nums[j]) --ttmin;
            
            maxd[++ttmax] = j;
            mind[++ttmin] = j;
            
            if (nums[maxd[hhmax]] - nums[mind[hhmin]] > limit) {
                if (maxd[hhmax] == i) ++hhmax;
                if (mind[hhmin] == i) ++hhmin;
                ++i;
            }
            
        }
        
        return j-i;
    }
}