/*https://leetcode.com/problems/continuous-subarray-sum/*/

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int sum = 0, prev = 0, i;
        Set<Integer> set = new HashSet<Integer>();
        
        for (i = 0; i < nums.length; ++i)
        {
            sum += nums[i];
            int temp = (k != 0) ? sum%k : sum;
            
            if (set.contains(temp)) return true;
            
            set.add(prev);
            prev = temp;
        }
        
        return false;
        
        /*int n = nums.length, i, j;
        int[] prefixArr = new int[n+1];
        prefixArr[0] = 0;
        for (i = 1; i <= n; ++i)
            prefixArr[i] = prefixArr[i-1]+nums[i-1];
        for (i = 0; i < n+1; ++i)
            System.out.print(prefixArr[i]+",");
        System.out.println();
        for (i = 2; i <= n; ++i)
        {
            for (j = 0; j < i-1; ++j)
            {
                if ((prefixArr[i]-prefixArr[j])%k == 0)
                    return true;
            }
        }
        return false;*/
    }
}