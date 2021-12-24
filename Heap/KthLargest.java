/*https://leetcode.com/problems/kth-largest-element-in-an-array/*/

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();

        //add the first k elements to min heap
        for (int i = 0; i < k; ++i)
            minHeap.add(nums[i]);

        //for rest of the elements
        for (int i = k; i < nums.length; ++i)
        {
            //if the element is greate than the root of the minheap
            if (nums[i] > (Integer)minHeap.peek())
            {
                //remove it and add the current element
                minHeap.poll();
                minHeap.add(nums[i]);
            }
        }

        /*this ensures that the largest k elements stay in the heap*/

        //return the root
        return minHeap.poll();
    }
}