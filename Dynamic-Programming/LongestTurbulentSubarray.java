/*https://leetcode.com/problems/longest-turbulent-subarray/*/

class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int n = arr.length;
        int up = 1;
        int down = 1;
        int max = 1;
        for (int i = 1; i < n; ++i)
        {
            if (arr[i] > arr[i - 1])
            {
                up = down + 1;
                down = 1;
            }
            else if (arr[i] < arr[i - 1])
            {
                down = up + 1;
                up = 1;
            }
            else
                down = up = 1;
            max = Math.max(max, Math.max(down, up));
        }
        return max;
    }
}

class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int n = arr.length;
        int ans = 1;
        int anchor = 0;

        for (int i = 1; i < n; ++i)
        {
            int c = Integer.compare(arr[i-1], arr[i]);
            if (c == 0)
                anchor = i;
            else if (i == n-1 || c * Integer.compare(arr[i], arr[i+1]) != -1)
            {
                ans = Math.max(ans, i-anchor+1);
                anchor = i;
            }
        }

        return ans;
    }
}