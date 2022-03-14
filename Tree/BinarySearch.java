/*https://practice.geeksforgeeks.org/problems/ffd66b6a0bf7cefb9987fa455974b6ea5695709e/1*/

class Solution
{
    static int find_height(int tree[], int n, int k)
    {
        int min = 0, max = Integer.MIN_VALUE, mid = 0, currSum = 0;
        for (int i = 0; i < n; ++i)
            max = Math.max(tree[i],max);
        while (min <= max)
        {
            mid = min+(max-min)/2;
            currSum = 0;
            for (int i = 0; i < n; ++i)
                currSum += tree[i] > mid ? tree[i]-mid : 0;
            if (currSum == k) return mid;
            else if (currSum > k) min = mid+1;
            else max = mid-1;
        }
        return -1;
    }
}