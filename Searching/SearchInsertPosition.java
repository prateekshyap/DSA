/*https://practice.geeksforgeeks.org/problems/search-insert-position-of-k-in-a-sorted-array/1/*/
/*https://binarysearch.com/problems/Insertion-Index-in-Sorted-List*/

class Solution
{
    static int searchInsertK(int Arr[], int N, int k)
    {
        return binarySearch(Arr, k, 0, N-1);
    }
    static int binarySearch(int[] a, int k, int l, int h)
    {
        if (l <= h)
        {
            int m = (l+h)/2;
            if (a[m] == k) return m;
            if (m == 0 && a[m] > k) return m;
            if (m != 0 && a[m] > k && a[m-1] < k) return m;
            if (m == a.length-1 && a[m] < k) return m+1;
            if (k < a[m]) return binarySearch(a, k, l, m-1);
            return binarySearch(a, k, m+1, h);
        }
        return -1;
    }
}

import java.util.*;

class Solution {
    public int solve(int[] nums, int target) {
        int low = 0, high = nums.length-1, mid;
        if (nums[0] > target) return 0;
        if (nums[nums.length-1] <= target) return nums.length;
        while (low <= high)
        {
            mid = low+(high-low)/2;
            if (nums[mid] > target && (mid == 0 || nums[mid-1] <= target)) return mid;
            else if (nums[mid] > target) high = mid-1;
            else low = mid+1;
        }
        return -1;
    }
}

import java.util.*;

class Solution {
    public int solve(int[] nums, int target) {
        int low = 0, high = nums.length-1, mid;
        if (nums[0] > target) return 0;
        if (nums[nums.length-1] <= target) return nums.length;
        while (low <= high)
        {
            mid = low+(high-low)/2;
            if (nums[mid] <= target)
                low = mid+1;
            else high = mid-1;
        }
        return low;
    }
}