/*https://leetcode.com/problems/find-unique-binary-string/*/

class Solution {
    public String findDifferentBinaryString(String[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; ++i)
        {
            int power = 2;
            int decimal = nums[i].charAt(nums[i].length()-1) - '0';
            int j = nums[i].length()-2;
            for (; j >= 0; --j)
            {
                decimal += (nums[i].charAt(j)-'0')*power;
                power <<= 1;
            }
            set.add(decimal);
        }
        for (int i = (int)Math.pow(2,nums.length)-1; i >= 0; --i)
            if (!set.contains(i))
            {
                StringBuffer result = new StringBuffer(Integer.toBinaryString(i));
                while (result.length() < nums.length)
                {
                    StringBuffer temp = new StringBuffer("0");
                    temp.append(result);
                    result = temp;
                }
                return new String(result);
            }
        return Integer.toBinaryString(0);
    }
}