/*https://leetcode.com/problems/longest-increasing-subsequence-ii/*/

class Solution {
    public int lengthOfLIS(int[] nums, int k) {
        List<TreeSet<Integer>> list = new ArrayList<TreeSet<Integer>>();
        for (int num : nums)
        {
            int l = 0, r = list.size()-1;
            int index = -1;
            while (l <= r)
            {
                int m = l+(r-l)/2;
                Integer smaller = list.get(m).lower(num);
                if (smaller == null)
                    r = m-1;
                else if (smaller+k < num)
                    l = m+1;
                else
                {
                    index = m;
                    l = m+1;
                }
            }
            if (index+1 == list.size())
                list.add(new TreeSet<Integer>());
            list.get(index+1).add(num);
        }
        return list.size();
    }
}