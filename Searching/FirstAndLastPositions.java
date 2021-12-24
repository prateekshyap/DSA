/*https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/*/

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = res[1] = -1;
        res[0] = findLeftMost(nums,target,0,nums.length-1);
        res[1] = findRightMost(nums,target,0,nums.length-1);
        return res;
    }
    public int findRightMost(int[] a, int t, int s, int e)
    {
        if (s <= e)
        {
            int m = (s+e)/2;
            if (a[m] == t && (m == a.length-1 || a[m+1] != t))
                return m;
            else if (a[m] > t)
                return findRightMost(a,t,s,m-1);
            else if (a[m] <= t)
                return findRightMost(a,t,m+1,e);
        }
        return -1;
    }
    public int findLeftMost(int[] a, int t, int s, int e)
    {
        if (s <= e)
        {
            int m = (s+e)/2;
            if (a[m] == t && (m == 0 || a[m-1] != t))
                return m;
            else if (a[m] >= t)
                return findLeftMost(a,t,s,m-1);
            else if (a[m] < t)
                return findLeftMost(a,t,m+1,e);
        }
        return -1;
    }
}