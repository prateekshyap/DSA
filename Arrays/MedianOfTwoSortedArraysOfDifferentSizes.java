/*https://practice.geeksforgeeks.org/problems/median-of-2-sorted-arrays-of-different-sizes/1/*/
/*https://leetcode.com/problems/median-of-two-sorted-arrays/*/

class GFG 
{ 
    static double medianOfArrays(int m, int n, int a[], int b[]) 
    {
        // Your Code Here
        int i = 0, j = 0, len = m+n, targetIndex = (len-1)/2, elem1 = 0, elem2 = 0;

        while (targetIndex >= -1)
        {
            elem2 = elem1;
            if (i >= m) elem1 = b[j++];
            else if (j >= n) elem1 = a[i++];
            else if (a[i] <= b[j]) elem1 = a[i++];
            else elem1 = b[j++];
            --targetIndex;
        }
        if (len%2 == 0) return ((double)(elem1+elem2))/2;
        return elem2;
    }
}

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        if (m > n) return findMedianSortedArrays(nums2, nums1);
        int target = (m+n+1)/2;
        int s1, s2, low = 0, high = m, mid;
        double l1, r1, l2, r2;
        while (low <= high)
        {
            mid = low+(high-low)/2;
            s1 = mid;
            s2 = target-mid;
            l1 = s1 > 0 ? nums1[s1-1] : Integer.MIN_VALUE;
            l2 = s2 > 0 ? nums2[s2-1] : Integer.MIN_VALUE;
            r1 = s1 < m ? nums1[s1] : Integer.MAX_VALUE;
            r2 = s2 < n ? nums2[s2] : Integer.MAX_VALUE;
            // System.out.println(l1+" "+l2+" "+r1+" "+r2);
            if (l1 <= r2 && l2 <= r1)
            {
                if ((m+n)%2 == 0)
                    return (Math.max(l1,l2)+Math.min(r1,r2))/2;
                return Math.max(l1,l2);
            }
            else if (l1 > r2)
                high = mid-1;
            else low = mid+1;
        }
        return -1;
    }
}