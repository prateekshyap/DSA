/*https://leetcode.com/problems/arithmetic-subarrays/*/

class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> result = new ArrayList<Boolean>();
        for (int i = 0; i < l.length; ++i)
        {
            ArrayList<Integer> list = new ArrayList<Integer>();
            for (int j = l[i]; j <= r[i]; ++j)
                list.add(nums[j]);
            Collections.sort(list);
            int k = 0, j = 1;
            while (j < list.size())
            {
                int currGap = (Integer)list.get(j)-(Integer)list.get(k);
                int start = k;
                while (j < list.size() && (Integer)list.get(j)-(Integer)list.get(k) == currGap)
                {
                    ++k; ++j;
                }
                if (j == list.size()) result.add(true);
                else
                {
                    result.add(false);
                    break;
                }
            }
        }
        return result;
    }
}