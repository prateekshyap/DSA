/*https://practice.geeksforgeeks.org/problems/number-of-pairs-1587115620/1/*/

class Solution {
    int getIndex(int y[] , int n , int ele)
    {
        int low = 0, high = n-1, ans = -1, mid = 0;
        while (low <= high)
        {
            mid = low+((high-low)/2);
            if (y[mid] > ele)
            {
                ans = mid;
                high = mid-1;
            }
            else
                low = mid+1;
        }
        return ans;
    }
    
    
    long countPairs(int[] x, int[] y, int m, int n)
    {
        int zeros = 0, one = 0, three = 0, four = 0, two = 0;
        Arrays.sort(x);
        Arrays.sort(y);
        int i, index;

        for (i = 0; i < n; ++i)
        {
            if (y[i] == 0) ++zeros;
            if (y[i] == 1) ++one;
            if (y[i] == 3) ++three;
            if (y[i] == 4) ++four;
            if (y[i] == 2) ++two;
        }
        
        //traversing x elements
        long ans = 0;
        for (i = 0; i < m; ++i)
        {
            if (x[i] == 0) continue;
            else if (x[i] == 1) ans += zeros;
            else if (x[i] == 2)
            {
                index = getIndex(y,n,2);
                if (index != -1)
                    ans += n-index;
                ans -= three;
                ans -= four;
                ans += one+zeros;
            }
            else
            {
                index = getIndex(y,n,x[i]);
                if (index != -1) ans += n-index;
                ans += one+zeros;
                if (x[i] == 3) ans += two;
            }
        }
        return ans;
    }
}