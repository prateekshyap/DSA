/*https://leetcode.com/problems/jump-game-ii/*/

//recursion+memo
class Solution {
    int[] nums;
    Integer[] stepsStore;
    public int jump(int[] nums) {
        this.nums = nums;
        int N = nums.length;
        stepsStore = new Integer[N];
        stepsStore[N-1] = steps(N-1);
        return stepsStore[N-1];
    }
    private int steps(int n)
    {
        if (n == 0) return 0;
        
        if (stepsStore[n] != null) return stepsStore[n];
        
        int result = Integer.MAX_VALUE;
        for (int i = n-1; i >= 0; --i)
            if (i+nums[i] >= n)
                result = Math.min(result,1+steps(i));
        
        return stepsStore[n] = result;
    }
}

//tabulation
class Solution {
    public int jump(int[] nums) {
        int N = nums.length;
        int[] steps = new int[N];
        for (int i = 1; i < N; ++i)
        {
            steps[i] = Integer.MAX_VALUE;
            for (int j = i-1; j >= 0; --j)
                if (j+nums[j] >= i)
                    steps[i] = Math.min(steps[i],1+steps[j]);
        }
        return steps[N-1];
    }
}

//extension to jump game
class Solution {
    public int jump(int[] nums) {
        int curr, maxReach = 0, N = nums.length;
        int[] steps = new int[N];
        Arrays.fill(steps,Integer.MAX_VALUE);
        steps[0] = 0;
        if (N == 1) return 0;
        for (int i = 0; i < N; ++i)
        {
            curr = i+nums[i];
            curr = Math.min(curr,N-1);
            for (int j = i+1; j <= curr; ++j)
                steps[j] = Math.min(steps[j], steps[i]+1);
        }
        return steps[N-1];
    }
}

//optimal extension
class Solution {
    public int jump(int[] nums) {
        int jumps = 0, currentJumpEnd = 0, farthest = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            // we continuously find the how far we can reach in the current jump
            farthest = Math.max(farthest, i + nums[i]);
            // if we have come to the end of the current jump,
            // we need to make another jump
            if (i == currentJumpEnd) {
                jumps++;
                currentJumpEnd = farthest;
            }
        }
        return jumps;
    }
}