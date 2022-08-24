/*https://leetcode.com/problems/jump-game-vi/*/

class Solution {
    public int maxResult(int[] nums, int k) {
        // edge cases
        if(nums == null || nums.length == 0){
            return 0;
        }
        // initialization
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> (b[0] - a[0]));
        // score to index mapping
        maxHeap.add(new int[] {nums[0], 0});
        int score = nums[0];
        
        // iterate over the elements
        for(int index = 1;index < nums.length;index++){
            // remove all the maximum while are out of the scope
            while(maxHeap.size() > 1 && maxHeap.peek()[1] < index - k){
                maxHeap.poll();
            }
            
            // add the maximum current score with the index value
            maxHeap.add(new int[] {(score = nums[index] + maxHeap.peek()[0]), index});
        }
        
        return score;
    }
}