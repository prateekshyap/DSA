/*https://leetcode.com/problems/maximum-length-of-repeated-subarray/*/

/*Simple DP solution*/

class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int max = 0;
        int[][] table = new int[nums1.length][nums2.length];
        for (int i = 0; i < table[0].length; ++i)
        {
            table[0][i] = nums1[0] == nums2[i] ? 1 : -1;
            max = Math.max(max,table[0][i]);
        }
        for (int i = 0; i < table.length; ++i)
        {
            table[i][0] = nums1[i] == nums2[0] ? 1 : -1;
            max = Math.max(max,table[i][0]);
        }
        for (int i = 1; i < table.length; ++i)
        {
            for (int j = 1; j < table[0].length; ++j)
            {
                if (nums1[i] != nums2[j])
                    table[i][j] = -1;
                else if (table[i-1][j-1] == -1)
                    table[i][j] = 1;
                else
                    table[i][j] = table[i-1][j-1]+1;
                max = Math.max(max,table[i][j]);
            }
        }
        return max;
    }
}

/*Efficient solution*/

class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        long[] h1 = new long[m + 1], h2 = new long[n + 1];
        long P = 131L;
        long[] pow = new long[n + 1];
        pow[0] = 1L;
        
        for (int i = 0; i < m; i++) {
            h1[i + 1] = h1[i] * P + nums1[i];
        }
        for (int i = 0; i < n; i++) {
            h2[i + 1] = h2[i] * P + nums2[i];
            pow[i + 1] = pow[i] * P;
        }
        
        int l = 0, r = Math.min(n, m);
        while (l < r) {
            int mid = l + (r - l + 1 >> 1);
            if (check(mid, nums1, nums2, h1, h2, pow)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        
        return l;
    }
    
    private boolean check(int len, int[] nums1, int[] nums2, long[] h1, long[] h2, long[] pow) {
        Set<Long> set = new HashSet<>();
        for (int i = len - 1; i < nums1.length; i++) {
            set.add(hash(h1, i - len + 1, i, pow));
        }
        
        for (int i = len - 1; i < nums2.length; i++) {
            if (set.contains(hash(h2, i - len + 1, i, pow))) {
                return true;
            }
        }
        
        return false;
    }
    
    private long hash(long[] ha, int l, int r, long[] pow) {
        return ha[r + 1] - ha[l] * pow[r - l + 1];
    }
}