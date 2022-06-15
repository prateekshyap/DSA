/*https://leetcode.com/problems/maximum-distance-between-a-pair-of-values/*/

/*O(nlogn) solution*/
class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length, i, j, maxJ, maxDiff = 0, limit = Math.min(n1,n2);
        
        for (i = 0; i < limit; ++i) //for each element in nums1
        {
            if (nums1[i] <= nums2[i]) //only if nums1[i] <= nums2[i]
            {
                maxJ = binarySearch(nums2,i,n2-1,nums1[i]); //find the last index in nums2 which is larger than nums1[i]
                if (maxJ-i > maxDiff) maxDiff = maxJ-i;
            }
        }
        
        return maxDiff;
    }
    public int binarySearch(int[] arr, int low, int high, int target)
    {
        int mid, n2 = high;
        while (low <= high)
        {
            mid = low+((high-low)/2);
            if (target <= arr[mid] && (mid == n2 || target > arr[mid+1])) return mid;
            else if (target <= arr[mid]) low = mid+1;
            else high = mid-1;
        }
        return -1;
    }
}

/*Efficient Solution*/
class Solution
{
    public int maxDistance(int[] nums1, int[] nums2)
    {
        int n1 = nums1.length, n2 = nums2.length, i = 0, j = 0;
        
        while (i < n1 && j < n2)
        {
            while (j < n2-1 && nums2[j+1] >= nums1[i]) j++;
            i++;
            j++;
        }
        
        return j-i;
    }
}