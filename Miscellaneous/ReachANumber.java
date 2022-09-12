/*https://leetcode.com/problems/reach-a-number/*/

class Solution {
    public int reachNumber(int target) {
        int step = 0, sum = 0;
        target = Math.abs(target);
        while (sum < target)
        {
            sum += step;
            ++step;
        }
        // if (sum == target) return step;
        while ((sum-target)%2 != 0)
        {
            sum += step;
            ++step;
        }
        return step-1;
    }
}