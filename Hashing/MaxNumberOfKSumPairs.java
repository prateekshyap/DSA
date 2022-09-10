/*https://leetcode.com/problems/max-number-of-k-sum-pairs/*/

class Solution {
    public int maxOperations(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for (int num : nums)
            map.put(num,map.getOrDefault(num,0)+1);
        // System.out.println(map);
        int pairsCount = 0;
        for (Map.Entry elem : map.entrySet())
        {
            int key = (Integer)elem.getKey();
            int value = (Integer)elem.getValue();
            pairsCount += Math.min(value,map.getOrDefault(k-key,0));
        }
        return pairsCount/2;
    }
}

class Solution {
    public int maxOperations(int[] nums, int k) 
    {
        Arrays.sort(nums);
    
        int p1 = 0, p2 = nums.length - 1;
        
        int count = 0;
        while(p1 < p2)
        {
            int sum = nums[p1] + nums[p2];
            
            if(sum == k)
            {
                ++count; ++p1; --p2;
            }
            else if(sum > k)
                --p2;
            else
                ++p1;
        }
        
        return count;
    }
}