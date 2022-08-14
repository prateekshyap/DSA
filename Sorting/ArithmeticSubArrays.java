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

class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> result = new ArrayList<Boolean>();
        for (int i = 0; i < l.length; ++i)
            result.add(check(nums,l[i],r[i]));
        return result;
    }
    private boolean check(int[] nums, int l, int r)
    {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = l; i <= r; ++i)
        {
            if (nums[i] < min) min = nums[i];
            if (nums[i] > max) max = nums[i];
        }
        int n = r-l+1;
        if ((max-min)%(n-1) != 0) return false;
        int diff = (max-min)/(n-1);
        if (diff == 0) return true;
        boolean[] added = new boolean[n];
        for (int i = l; i <= r; ++i)
        {
            if ((nums[i]-min)%diff != 0) return false;
            if (added[(nums[i]-min)/diff]) return false;
            added[(nums[i]-min)/diff] = true;
        }
        return true;
    }
}