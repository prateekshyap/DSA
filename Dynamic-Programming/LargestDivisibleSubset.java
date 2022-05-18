/*https://leetcode.com/problems/largest-divisible-subset/*/

class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length, i, j, maxVal = -1, maxValIndex = -1;
        int[] dp = new int[n], len = new int[n], indices = new int[n];
        Arrays.sort(nums);
        List<Integer> result = new ArrayList<Integer>();
        
        //base case
        dp[0] = nums[0];
        len[0] = 1;
        indices[0] = -1;
        
        for (i = 1; i < n; ++i) //for each element
        {
            for (j = 0; nums[j] <= nums[i]/2; ++j) //for all previous elements till its half
            {
                if (nums[i]%dp[j] == 0 && len[i] < len[j]+1) //if it can be added to the subset
                {
                    dp[i] = nums[i]; //store in table
                    len[i] = len[j]+1; //store increased length
                    indices[i] = j; //store the previous index of the streak
                    if (len[i] > maxVal) //if size is increased, update it
                    {
                        maxVal = len[i];
                        maxValIndex = i;
                    }
                }    
            }
            if (dp[i] == 0) //if table is not updated, start a new streak
            {
                dp[i] = nums[i];
                len[i] = 1;
                indices[i] = -1;
            }
        }

        //backtrack to get the elements
        while (maxValIndex != -1)
        {
            result.add(dp[maxValIndex]);
            maxValIndex = indices[maxValIndex];
        }
        
        //if no elements added, simply add the first element
        if (result.size() == 0) result.add(nums[0]);
        
        //sort and return
        Collections.sort(result);
        return result;
    }
}