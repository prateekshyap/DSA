/*https://leetcode.com/problems/find-subsequence-of-length-k-with-the-largest-sum/*/

class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        int[] result = new int[k];
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        for (int i = 0; i < k; ++i)
            minHeap.add(nums[i]);
        for (int i = k; i < nums.length; ++i)
            if (minHeap.peek() < nums[i])
            {
                minHeap.poll();
                minHeap.add(nums[i]);
            }
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for (Integer num : minHeap) map.put(num,map.containsKey(num) ? (Integer)map.get(num)+1 : 1);
        
        int index = 0;
        for (int i = 0; i < nums.length; ++i)
        {
            if (map.containsKey(nums[i]) && (Integer)map.get(nums[i]) > 0)
            {
                result[index++] = nums[i];
                map.put(nums[i],(Integer)map.get(nums[i])-1);
            }
        }
        return result;
    }
}