/*https://binarysearch.com/problems/Optimal-Decrement*/

import java.util.*;

class Solution {
    public int solve(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(Collections.reverseOrder());
        for (int elem : nums) heap.add(elem);
        for (int i = 0; i < k; ++i) heap.add(heap.poll()-1);
        return heap.poll();
    }
}