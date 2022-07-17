/*https://leetcode.com/problems/k-divisible-elements-subarrays/*/

class Solution {
    public int countDistinct(int[] nums, int k, int p) {
        int limit = 0, count = 0;
        HashSet<String> set = new HashSet<String>();
        int i = 0, j = 0;
        while (j < nums.length)
        {
            if (nums[j]%p == 0) ++limit;
            if (limit <= k)
            {
                String key = getKey(nums,i,j);
                if (!set.contains(key)) ++count;
                set.add(key);
            }
            ++j;
            if (limit > k || j == nums.length)
            {
                i++;
                j = i;
                limit = 0;
            }
        }
        return count;
    }
    private String getKey(int[] arr, int start, int end)
    {
        StringBuilder result = new StringBuilder("#");
        for (int i = start; i <= end; ++i)
        {
            result.append(arr[i]);
            result.append("#");
        }
        return result.toString();
    }
}

class Solution {
    public int countDistinct(int[] nums, int k, int p) {
        int limit = 0, count = 0;
        HashSet<Long> set = new HashSet<Long>();
        int i = 0, j = 0;
        long hash = 0;
        while (j < nums.length)
        {
            if (nums[j]%p == 0) ++limit;
            if (limit <= k)
            {
                hash *= 201;
                hash += nums[j];
                set.add(hash);
            }
            ++j;
            if (limit > k || j == nums.length)
            {
                i++;
                j = i;
                limit = 0;
                hash = 0;
            }
        }
        return set.size();
    }
}