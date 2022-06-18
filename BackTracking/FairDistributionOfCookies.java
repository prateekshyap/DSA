/*https://leetcode.com/problems/fair-distribution-of-cookies/*/

class Solution {
    int n;
    int min;
    public int distributeCookies(int[] cookies, int k) {
        int[] children = new int[k];
        n = cookies.length;
        min = Integer.MAX_VALUE;
        recur(cookies, n, 0, children, k);
        return min;
    }
    public void recur(int[] cookies, int n, int index, int[] children, int k)
    {
        int i;
        if (index >= n)
        {
            int currMax = 0;
            for (i = 0; i < k; ++i) if (children[i] > currMax) currMax = children[i];
            if (currMax < min) min = currMax;
            return;
        }
        for (i = 0; i < k; ++i)
        {
            children[i] += cookies[index];
            if (children[i] <= min) recur(cookies, n, index+1, children, k);
            children[i] -= cookies[index];
        }
    }
}