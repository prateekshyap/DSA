/*https://leetcode.com/problems/minimum-number-of-increments-on-subarrays-to-form-a-target-array/*/

class Solution {
    public int minNumberOperations(int[] target) {
        int totalOperations=target[0];
        for(int i=1;i<target.length;i++){
            if(target[i] > target[i-1])
                totalOperations+=target[i]-target[i-1];
        }
        return totalOperations;
    }
}