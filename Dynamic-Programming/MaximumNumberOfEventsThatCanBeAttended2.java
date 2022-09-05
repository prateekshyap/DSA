/*https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended-ii/*/

class Solution {
    int n;
    Integer[][] values;
    public int maxValue(int[][] events, int k) {
        Arrays.sort(events,(a,b)->(a[0] == b[0] ? (a[1] == b[1] ? b[2]-a[2] : a[1]-b[1]) : a[0]-b[0]));
        n = events.length;
        values = new Integer[n+1][k+1];
        values[0][k] = count(events, k, 0);
        return values[0][k];
    }
    private int count(int[][] events, int k, int index)
    {
        if (k == 0 || index == n || index == -1) return 0;
        if (values[index][k] != null) return values[index][k];
        
        int result = 0;
        
        result = Math.max(result,count(events, k, index+1));
        if (k > 0)
        {
            int end = events[index][1];
            int nextIndex = -1, low = index+1, high = n-1, mid;
            while (low <= high)
            {
                mid = low+(high-low)/2;
                if (events[mid][0] > end)
                {
                    nextIndex = mid;
                    high = mid-1;
                }
                else low = mid+1;
            }
            result = Math.max(result,events[index][2]+count(events, k-1, nextIndex));
        }
        
        return values[index][k] = result;
    }
}