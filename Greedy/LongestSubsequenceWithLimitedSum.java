/*https://leetcode.com/problems/longest-subsequence-with-limited-sum/*/

class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int[] temp = new int[queries.length];
        for (int i = 0; i < queries.length; ++i)
            temp[i] = queries[i];
        Arrays.sort(queries);
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        int i = 0, j = 0, sum = 0, count = 0, n = nums.length, m = queries.length;
        int[] result = new int[m];
        i = 0;
        while (i < n && j < m)
        {
            if (sum+nums[i] <= queries[j])
            {
                sum += nums[i];
                ++count;
                ++i;
            }
            else
            {
                map.put(queries[j],count);
                ++j;
            }
        }
        while (j < m)
            map.put(queries[j++],count);
        for (j = 0; j < queries.length; ++j)
            result[j] = map.getOrDefault(temp[j],0);
        return result;
    }
}

class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        
        int [] result = new int [queries.length];
        int count;
        int sum;
        
        for (int i = 0; i < result.length; ++i){
            count = 0;
            sum = queries[i];
            
            for (int j = 0; j < nums.length; ++j){
                sum -= nums[j];
                
                if (sum < 0) break;
                
                ++count;
            }
            
            result[i] = count;
        }
        
        return result;
    }
}