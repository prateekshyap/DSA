/*https://leetcode.com/problems/count-of-smaller-numbers-after-self/*/

class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length, i;
        List<Integer> covered = new ArrayList<Integer>();
        List<Integer> result = new ArrayList<Integer>();
        result.add(0);
        covered.add(nums[n-1]);
        for (i = n-2; i >= 0; --i)
            result.add(getCount(covered,nums[i]));
        Collections.reverse(result);
        return result;
    }
    private int getCount(List<Integer> covered, int elem)
    {
        int low = 0, mid, high = covered.size()-1, index = -1;
        while (low <= high)
        {
            mid = low+(high-low)/2;
            if (covered.get(mid) < elem)
            {
                index = mid;
                low = mid+1;
            }
            else
                high = mid-1;
        }
        covered.add(index+1,elem);
        return index+1;
    }
}