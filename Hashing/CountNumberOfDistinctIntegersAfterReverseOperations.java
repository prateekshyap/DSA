/*https://leetcode.com/problems/count-number-of-distinct-integers-after-reverse-operations/*/

class Solution {
    public int countDistinctIntegers(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        for (int num : nums)
        {
            set.add(num);
            int rev = 0;
            while (num > 0)
            {
                rev = rev*10+(num%10);
                num /= 10;
            }
            set.add(rev);
        }
        return set.size();
    }
}