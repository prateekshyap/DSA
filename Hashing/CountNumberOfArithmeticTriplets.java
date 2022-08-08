/*https://leetcode.com/problems/number-of-arithmetic-triplets/*/

class Solution {
    public int arithmeticTriplets(int[] nums, int diff) {
        int count = 0;
        HashMap<Integer,TreeSet<Integer>> map = new HashMap<Integer,TreeSet<Integer>>();
        for (int i = 0; i < nums.length; ++i)
        {
            if (!map.containsKey(nums[i]))
                map.put(nums[i],new TreeSet<Integer>());
            map.get(nums[i]).add(i);
        }
        for (int i = 0; i < nums.length-2; ++i)
        {
            if (map.containsKey(nums[i]+diff) && map.containsKey(nums[i]+(2*diff)))
            {
                Integer j = map.get(nums[i]+diff).higher(i);
                if (j == null) continue;
                Integer k = map.get(nums[j]+diff).higher(j);
                if (k != null) ++count;
            }
        }
        return count;
    }
}

class Solution {
    public int arithmeticTriplets(int[] nums, int diff) {
        boolean [] visited = new boolean [201];
        
        for (int num : nums)
            visited[num] = true;
        
        int result = 0;
        
        for (int i = diff; i <= 200-diff; ++i)
        {
            if (visited[i] && visited[i-diff] && visited[i+diff])
                ++result;
        }
        
        return result;
    }
}