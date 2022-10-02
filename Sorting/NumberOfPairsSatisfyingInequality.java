/*https://leetcode.com/problems/number-of-pairs-satisfying-inequality/description/*/

// merge sort variant
class Solution {
    public long numberOfPairs(int[] nums1, int[] nums2, int diff) {
        int[] nums = new int[nums1.length];
        for (int i = 0; i < nums.length; ++i)
            nums[i] = nums1[i]-nums2[i];
        long result = 0;
        
        return mergeSort(nums,0,nums.length-1,diff);
    }
    
    static long mergeSort(int[] arr, int low, int high, int diff)
    {
        long count = 0;
        if (low < high)
        {
            int mid = (low+high)/2;
            long left = mergeSort(arr,low,mid,diff);
            long right = mergeSort(arr,mid+1,high,diff);
            long getCount = merge(arr,low,mid,high,diff);
            count += left+right+getCount;
        }
        return count;
    }
    
    static long merge(int[] arr, int low, int mid, int high, int diff)
    {
        int n1 = mid-low+1;
        int n2 = high-mid;
        int[] arr1 = new int[n1];
        int[] arr2 = new int[n2];
        int x = low;
        for (int i = 0; i < n1; ++i)
            arr1[i] = arr[x++];
        for (int j = 0; j < n2; ++j)
            arr2[j] = arr[x++];
        int i = 0, j = 0;
        long count = 0;
        x = low;
        while (i < n1 && j < n2)
        {
            if (arr1[i] <= arr2[j]+diff)
            {
                count += n2-j;
                ++i;
            }
            else
                ++j;
        }
        i = 0;
        j = 0;
        x = low;
        while (i < n1 && j < n2)
        {
            if (arr1[i] <= arr2[j])
                arr[x++] = arr1[i++];
            else
                arr[x++] = arr2[j++];
        }
        while (i < n1)
            arr[x++] = arr1[i++];
        while (j < n2)
            arr[x++] = arr2[j++];
        return count;
    }
}