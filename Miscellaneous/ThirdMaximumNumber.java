/*https://leetcode.com/problems/third-maximum-number/*/

class Solution {
    public int thirdMax(int[] nums) {
        long m1 = Long.MIN_VALUE, m2 = Long.MIN_VALUE, m3 = Long.MIN_VALUE;
        boolean m3Updated = false;
        for (Integer num : nums)
        {
            if (num > m1)
            {
                m3 = m2;
                m2 = m1;
                m1 = num;
            }
            else if (num > m2 && num != m1)
            {
                m3 = m2;
                m2 = num;
            }
            else if (num > m3 && num != m1 && num != m2)
            {
                m3 = num;
            }
        }
        return m3 == Long.MIN_VALUE && !m3Updated ? (int)m1 : (int)m3;
    }
}