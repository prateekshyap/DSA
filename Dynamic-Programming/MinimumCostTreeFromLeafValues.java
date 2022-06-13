/*https://leetcode.com/problems/minimum-cost-tree-from-leaf-values/*/

//initial thought : recursive version
class Solution {
    public int mctFromLeafValues(int[] arr) {
        int i, n = arr.length, minSum = Integer.MAX_VALUE;
        int[] sum;
        for (i = 0; i < n-1; ++i)
        {
            sum = recur(arr, 0, i, i+1, n-1);
            sum[0] = sum[0] == Integer.MAX_VALUE ? 0 : sum[0];
            sum[0] += sum[1]*sum[2];
            if (sum[0] < minSum) minSum = sum[0];
        }
        return minSum;
    }
    public int[] recur(int[] arr, int ls, int le, int rs, int re)
    {
        int i, minLeft = Integer.MAX_VALUE, minRight = Integer.MAX_VALUE;
        int[] result = new int[3], left, right;
        result[0] = Integer.MAX_VALUE;
        if (ls == le && rs == re)
        {
            result[0] = Integer.MAX_VALUE;
            result[1] = arr[ls];
            result[2] = arr[rs];
            return result;
        }
        if (ls == le)
        {
            for (i = rs; i < re; ++i)
            {
                right = recur(arr, rs, i, i+1, re);
                right[0] = right[0] == Integer.MAX_VALUE ? 0 : right[0];
                right[0] += right[1]*right[2];
                if (right[0] < result[0])
                {
                    result[0] = right[0];
                    result[2] = Math.max(right[1],right[2]);
                }
            }
            result[1] = arr[ls];
            return result;
        }
        if (rs == re)
        {
            for (i = ls; i < le; ++i)
            {
                left = recur(arr, ls, i, i+1, le);
                left[0] = left[0] == Integer.MAX_VALUE ? 0 : left[0];
                left[0] += left[1]*left[2];
                if (left[0] < result[0])
                {
                    result[0] = left[0];
                    result[1] = Math.max(left[1],left[2]);
                }
            }
            result[2] = arr[rs];
            return result;
        }
        for (i = ls; i < le; ++i)
        {
            left = recur(arr, ls, i, i+1, le);
            left[0] = left[0] == Integer.MAX_VALUE ? 0 : left[0];
            left[0] += left[1]*left[2];
            if (left[0] < minLeft)
            {
                minLeft = left[0];
                result[1] = Math.max(left[1],left[2]);
            }
        }
        for (i = rs; i < re; ++i)
        {
            right = recur(arr, rs, i, i+1, re);
            right[0] = right[0] == Integer.MAX_VALUE ? 0 : right[0];
            right[0] += right[1]*right[2];
            if (right[0] < minRight)
            {
                minRight = right[0];
                result[2] = Math.max(right[1],right[2]);
            }
        }
        result[0] = minLeft+minRight;
        return result;
    }
}

//optimized recursive version
class Solution {
    public int mctFromLeafValues(int[] arr) {
        int i, n = arr.length, minSum = Integer.MAX_VALUE;
        int[] sum;
        for (i = 0; i < n-1; ++i)
        {
            sum = recur(arr, 0, i, i+1, n-1);
            sum[0] = sum[0] == Integer.MAX_VALUE ? 0 : sum[0];
            sum[0] += sum[1]*sum[2];
            if (sum[0] < minSum) minSum = sum[0];
        }
        return minSum;
    }
    public int[] recur(int[] arr, int ls, int le, int rs, int re)
    {
        int i, minLeft = Integer.MAX_VALUE, minRight = Integer.MAX_VALUE;
        int[] result = new int[3], left, right;
        result[0] = result[1] = result[2] = Integer.MAX_VALUE;
        if (rs != re)
        {
            for (i = rs; i < re; ++i)
            {
                right = recur(arr, rs, i, i+1, re);
                right[0] = right[0] == Integer.MAX_VALUE ? 0 : right[0];
                right[0] += right[1]*right[2];
                if (right[0] < minRight)
                {
                    minRight = right[0];
                    result[2] = Math.max(right[1],right[2]);
                }
            }
        }
        if (ls != le)
        {
            for (i = ls; i < le; ++i)
            {
                left = recur(arr, ls, i, i+1, le);
                left[0] = left[0] == Integer.MAX_VALUE ? 0 : left[0];
                left[0] += left[1]*left[2];
                if (left[0] < minLeft)
                {
                    minLeft = left[0];
                    result[1] = Math.max(left[1],left[2]);
                }
            }
        }
        minLeft = minLeft == Integer.MAX_VALUE ? 0 : minLeft;
        minRight = minRight == Integer.MAX_VALUE ? 0 : minRight;
        result[0] = minLeft+minRight;
        result[1] = result[1] == Integer.MAX_VALUE ? arr[ls] : result[1];
        result[2] = result[2] == Integer.MAX_VALUE ? arr[rs] : result[2];
        return result;
    }
}

//memoization (TLE)
class Solution {
    int[][][][][] dp;
    public int mctFromLeafValues(int[] arr) {
        int[] sum;
        int i, j, k, l, n = arr.length, minSum = Integer.MAX_VALUE;
        
        dp = new int[n][n][n][n][3];
        for (i = 0; i < n; ++i)
            for (j = 0; j < n; ++j)
                for (k = 0; k < n; ++k)
                    for (l = 0; l < n; ++l)
                        dp[i][j][k][l][0] = Integer.MAX_VALUE;
        
        for (i = 0; i < n-1; ++i)
        {
            sum = recur(arr, 0, i, i+1, n-1);
            sum[0] = sum[0] == Integer.MAX_VALUE ? 0 : sum[0];
            sum[0] += sum[1]*sum[2];
            if (sum[0] < minSum) minSum = sum[0];
        }
        return minSum;
    }
    public int[] recur(int[] arr, int ls, int le, int rs, int re)
    {
        if (dp[ls][le][rs][re][0] != Integer.MAX_VALUE) return dp[ls][le][rs][re];
        
        int i, minLeft = Integer.MAX_VALUE, minRight = Integer.MAX_VALUE, leftSum, rightSum;
        int[] result = new int[3], left, right;
        result[0] = result[1] = result[2] = Integer.MAX_VALUE;
        
        
        for (i = rs; i < re; ++i)
            {
                rightSum = 0;
                right = recur(arr, rs, i, i+1, re);
                right[0] = right[0] == Integer.MAX_VALUE ? 0 : right[0];
                rightSum += right[0]+right[1]*right[2];
                if (rightSum < minRight)
                {
                    minRight = rightSum;
                    result[2] = Math.max(right[1],right[2]);
                }
            }
        
        for (i = ls; i < le; ++i)
            {
                leftSum = 0;
                left = recur(arr, ls, i, i+1, le);
                left[0] = left[0] == Integer.MAX_VALUE ? 0 : left[0];
                leftSum += left[0]+left[1]*left[2];
                if (leftSum < minLeft)
                {
                    minLeft = leftSum;
                    result[1] = Math.max(left[1],left[2]);
                }
            }
        
        minLeft = minLeft == Integer.MAX_VALUE ? 0 : minLeft;
        minRight = minRight == Integer.MAX_VALUE ? 0 : minRight;
        result[0] = minLeft+minRight;
        result[1] = result[1] == Integer.MAX_VALUE ? arr[ls] : result[1];
        result[2] = result[2] == Integer.MAX_VALUE ? arr[rs] : result[2];
        
        dp[ls][le][rs][re][0] = result[0];
        dp[ls][le][rs][re][1] = result[1];
        dp[ls][le][rs][re][2] = result[2];
        
        return result;
    }
}

//efficient memoization
class Solution {
    public int mctFromLeafValues(int[] arr) {
        int[][][] dp = new int[arr.length][arr.length][2];
        int i, j;
        for (i = 0; i < arr.length; ++i)
            for (j = 0; j < arr.length; ++j)
                dp[i][j][0] = Integer.MAX_VALUE;
        int[] result = mctFromLeafValues(arr, 0, arr.length-1, dp);
        return result[0];
    }
    
    public int[] mctFromLeafValues(int[] arr, int start, int end, int[][][] dp) {
    
        if (start > end) return new int[]{0,0};
        if (end - start <= 1)
        {
            if(start == end) return new int[]{0,arr[start]}; 
            return new int[]{arr[start]*arr[end],Math.max(arr[start],arr[end])};
        }
        
        if (dp[start][end][0] != Integer.MAX_VALUE)
            return dp[start][end];
        
        int max = Integer.MIN_VALUE;
        int minSum = Integer.MAX_VALUE;
        for (int i = start; i < end; i++)
        {
            int sum = 0;
            int[] left = mctFromLeafValues(arr, start, i, dp);
            int[] right = mctFromLeafValues(arr, i + 1, end, dp);
            sum += left[0] + (left[1] * right[1]) + right[0];
            minSum = Math.min(minSum, sum);
            max = Math.max(max, Math.max(left[1], right[1]));
        }
        
        dp[start][end] = new int[]{minSum,max};
        
        return dp[start][end];
    }
}

//efficient solution without dp
class Solution {
    public int mctFromLeafValues(int[] arr) {
        int sum = 0;
        int top = 1;
        for (int i = 2; i <= arr.length; i++) {
            int val = i == arr.length ? Integer.MAX_VALUE : arr[i];   
            while (top >= 1 && val > arr[top-1]) {
                sum += arr[top-1]*arr[top];
                arr[top-1] = Math.max(arr[top-1], arr[top]);
                top--;
            }
            arr[++top] = val;
        }
        return sum;
    }
}