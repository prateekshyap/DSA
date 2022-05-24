/*https://leetcode.com/problems/partition-to-k-equal-sum-subsets/*/

class Solution {
    HashMap<Integer, Integer> map = new HashMap<>();
    public boolean canPartitionKSubsets(int[] nums, int k)
    {
        if (nums == null || nums.length == 0 || k == 0) return false;
        Arrays.sort(nums);
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % k != 0 || sum < k) return false;
        sum = sum / k;
        return possible(nums, sum, new int[k], nums.length-1);
    }
    
    boolean possible(int[] nums, int sum, int[] p, int index)
    {
        if (index == -1)
        {
            for (int s : p) if (s != sum) return false;
            return true;
        }
        
        int num = nums[index];
        
        for (int i = 0; i < p.length; i++) {
            if (p[i] + num <= sum) {
                if (i> 0 && p[i] == p[i - 1]) continue;
                p[i] += num;
                if (possible(nums, sum, p, idx - 1)) return true;
                p[i] -= num;
            }
        }
        return false;
    }
}
