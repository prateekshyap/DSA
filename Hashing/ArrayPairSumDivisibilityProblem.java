/*https://practice.geeksforgeeks.org/problems/array-pair-sum-divisibility-problem3257/1/*/

class Solution {
    public boolean canPair(int[] nums, int k) {
        // Code here
        int sum = 0, n = nums.length, i;
        for (i = 0; i < n; ++i) sum += nums[i];
        if (sum%k != 0) return false;
        boolean turn = true;
        for (i = 0; i < n; ++i)
        {
            nums[i] = nums[i]%k;
            if (nums[i] == 0)
            {
                if (turn) nums[i] = k;
                turn = !turn;
            }
        }
        int pairs = 0;
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for (i = 0; i < n; ++i)
        {
            if (map.containsKey(k-nums[i]) && (Integer)map.get(k-nums[i]) > 1)
            {
                map.put(k-nums[i],(Integer)map.get(k-nums[i])-1);
                ++pairs;
            }
            else if (map.containsKey(k-nums[i]))
            {
                map.remove(k-nums[i]);
                ++pairs;
            }
            else map.put(nums[i],(map.containsKey(nums[i]) ? (Integer)map.get(nums[i])+1 : 1));
        }
        if (map.size() == 0) return true;
        return false;
    }
}

class Solution {
    public boolean canPair(int[] nums, int k) {
        // Code here
        int[] rem = new int[k];
        for (int x : nums)
        	++rem[x % k];
        	
        if (rem[0] % 2 != 0)
        	return false;
        	
        for (int i = 1; i < k; ++i)
        	if (rem[i] != rem[k - i])
        		return false;
        		
        return true;
    }
}