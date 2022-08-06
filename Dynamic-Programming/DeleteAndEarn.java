/*https://leetcode.com/problems/delete-and-earn/*/

class Solution {
    HashMap<Integer,Integer> freq;
    Integer[][] table;
    public int deleteAndEarn(int[] nums) {
    	//count and store the frequency of each element
        freq = new HashMap<Integer,Integer>();
        for (int num : nums)
            freq.put(num,freq.getOrDefault(num,0)+1);

        //get all unique elements in sorted order
        TreeSet<Integer> set = new TreeSet<Integer>();
        for (int num : nums) set.add(num);
        int[] arr = new int[set.size()];
        int j = 0;
        for (Integer num : set)
            arr[j++] = num;
        table = new Integer[arr.length+1][2];

        //recursion
        int result = Math.max(delete(arr,arr.length-1,0),delete(arr,arr.length-1,1));
        return result;
    }
    private int delete(int[] nums, int index, int state)
    {
    	//base case
        if (index == -1) return 0;
        
        if (state != -1 && table[index][state] != null) return table[index][state];
        int result = 0;
        if (freq.containsKey(nums[index]) && state == 1) //if current element is to be deleted and it has occurrences left
        {
            int highCount = -1, lowCount = -1, count = -1;

            //keep their frequencies safe
            if (freq.containsKey(nums[index]+1)) highCount = freq.get(nums[index]+1);
            if (freq.containsKey(nums[index]-1)) lowCount = freq.get(nums[index]-1);
            count = freq.get(nums[index]);

            //remove them from map
            freq.remove(nums[index]-1); freq.remove(nums[index]+1); freq.remove(nums[index]);
            
            //if current index is 0 or map contains the previous element
            if (index == 0 || freq.containsKey(nums[index-1]))
                result = Math.max(result,(nums[index]*count)+delete(nums,index-1,1)); //call delete on previous element
            result = Math.max(result,(nums[index]*count)+delete(nums,index-1,0)); //call non-delete on previous element

            //baxtrack the counts
            if (highCount != -1) freq.put(nums[index]+1,highCount);
            if (lowCount != -1) freq.put(nums[index]-1,lowCount);
            freq.put(nums[index],count);
        }
        else if (state == 0) //if current element can't be deleted
        {
            if (index == 0 || freq.containsKey(nums[index-1])) //if current index is 0 or map contains the previous element
                result = Math.max(result,delete(nums,index-1,1)); //call delete on previous element
            result = Math.max(result,delete(nums,index-1,0)); //call non-delete on previous element
        }
        
        table[index][state] = result; //memoize the result
        return result;
    }
}

class Solution {
    public int deleteAndEarn(int[] nums) {
        int max = 0;
        for(int i = 0 ; i < nums.length ; i++){
            max = Math.max(max,nums[i]);
        }

        int dp[] = new int[max+1];
        int include = 0;
        int exclude = 0;
       for(int i= 0 ; i < nums.length ; i++)dp[nums[i]]++;

       for(int i= 0 ; i < dp.length ; i++){
           int included = exclude + dp[i]*i;
           int notIncluded = Math.max(include,exclude);
           include = included;
           exclude = notIncluded;
       }
        return Math.max(include,exclude);
    }
}