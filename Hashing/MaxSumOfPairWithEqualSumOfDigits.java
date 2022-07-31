/*https://leetcode.com/problems/max-sum-of-a-pair-with-equal-sum-of-digits/*/

class Solution {
    public int maximumSum(int[] nums) {
        HashMap<Integer,PriorityQueue<Integer>> map = new HashMap<Integer,PriorityQueue<Integer>>();
        int sum, copy;
        for (int num : nums)
        {
            sum = 0;
            copy = num;
            while (copy > 0)
            {
                sum += copy%10;
                copy /= 10;
            }
            if (!map.containsKey(sum))
                map.put(sum,new PriorityQueue<Integer>(Collections.reverseOrder()));
            map.get(sum).add(num);
        }
        int result = Integer.MIN_VALUE;
        PriorityQueue<Integer> heap;
        for (Map.Entry elem : map.entrySet())
        {
            heap = (PriorityQueue)elem.getValue();
            if (heap.size() < 2) continue;
            sum = (Integer)heap.poll()+(Integer)heap.poll();
            if (sum > result) result = sum;
        }
        return result == Integer.MIN_VALUE ? -1 : result;
    }
}