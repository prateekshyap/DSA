/*https://leetcode.com/problems/single-number-iii/*/

class Solution {
    public int[] singleNumber(int[] nums) {
        int[] result = new int[2];

        //xor all numbers
        int xor = 0;
        for (int i = 0; i < nums.length; ++i)
            xor ^= nums[i];

        //xor the final value with its 2's complement
        xor = (xor&-xor);
        int xor1 = 0, xor2 = 0;

       	//xor into two separate groups
        for (int i = 0; i < nums.length; ++i)
            if ((nums[i]&xor) > 0)
                xor1 ^= nums[i];
            else
                xor2 ^= nums[i];

        //store and return
        result[0] = xor1;
        result[1] = xor2;
        Arrays.sort(result);
        return result;
    }
}