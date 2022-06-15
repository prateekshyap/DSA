/*https://leetcode.com/problems/summary-ranges/*/

class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<String>();
        if (nums.length == 1)
        {
            result.add(Integer.toString(nums[0]));
            return result;
        }
        int n = nums.length, i = 0, j = 0;
        while (j < n)
        {
            ++j;
            if (j == n)
            {
                StringBuffer s = new StringBuffer(Integer.toString(nums[i]));
                if (i != j-1)
                {
                    s.append("->");
                    s.append(nums[j-1]);
                }
                result.add(s.toString());
                break;
            }
            if (nums[j] != nums[j-1]+1)
            {
                StringBuffer s = new StringBuffer(Integer.toString(nums[i]));
                if (i != j-1)
                {
                    s.append("->");
                    s.append(nums[j-1]);
                }
                result.add(s.toString());
                i = j;
            }
        }
        /*StringBuffer s = new StringBuffer(Integer.toString(nums[i]));
        s.append("->");
        s.append(nums[j-1]);
        result.add(s.toString());*/
        return result;
    }
}