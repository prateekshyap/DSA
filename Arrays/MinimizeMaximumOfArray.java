/*https://leetcode.com/problems/minimize-maximum-of-array/*/

class Solution {
    public int minimizeArrayValue(int[] nums) {
        long max = 0, sum = 0;
        for(int i = 0; i < nums.length; i ++) {
            if(nums[i]>max){
                sum += nums[i];
                int temp = (int) Math.ceil((double) sum/(i+1));
                max = (long) Math.max(max,temp);
            }else{
                sum += nums[i];
            }
        }  
        return (int)max;          
    }

}