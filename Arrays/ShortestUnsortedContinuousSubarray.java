/*https://leetcode.com/problems/shortest-unsorted-continuous-subarray/*/

//nlogn solution using min heap and max heap
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());

        //add everyting to the heaps
        for (int i = 0; i < nums.length; ++i)
        {
            min.add(nums[i]);
            max.add(nums[i]);
        }
        int left = -1, right = -1;

        //traverse from left and find the first mismatch
        for (int i = 0; i < nums.length; ++i)
            if ((Integer)min.poll() != nums[i])
            {
                left = i;
                break;
            }

        //traverse from the right and find the first mismatch
        for (int i = nums.length-1; i >= 0; --i)
            if ((Integer)max.poll() != nums[i])
            {
                right = i;
                break;
            }

        //return
        if (left == -1 && right == -1) return 0;
        return (right-left+1);
    }
}

//n solution
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int left = -1, right = -1, min = nums[nums.length-1], max = nums[0];

        //find the rightmost index
        for (int i = 1; i < nums.length; ++i)
        {
            if (nums[i] < max) right = i;
            max = Math.max(max,nums[i]);
        }

        //find the leftmost index
        for (int i = nums.length-2; i >= 0; --i)
        {
            if (nums[i] > min) left = i;
            min = Math.min(min,nums[i]);
        }
        if (left == -1 && right == -1) return 0;
        return (right-left+1);
    }
}