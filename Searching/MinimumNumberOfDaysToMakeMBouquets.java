/*https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/*/

class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length, low = 0, high = 0, mid, result = -1;
        for (int day : bloomDay)
            high = Math.max(high,day);
        while (low <= high)
        {
            mid = low+(high-low)/2;
            if (possible(bloomDay,mid,m,k,n))
            {
                result = mid;
                high = mid-1;
            }
            else low = mid+1;
        }
        return result;
    }
    public boolean possible(int[] bloomDay, int day, int m, int k, int n)
    {
        int consec = 0, bouquets = 0;
        for (int i = 0; i < n; ++i)
        {
            if (bloomDay[i] <= day) ++consec;
            else consec = 0;
            if (consec == k)
            {
                ++bouquets;
                consec = 0;
            }
        }
        if (consec == k)
            ++bouquets;
        return bouquets >= m;
    }
}

class Solution {
    int m,k;
    public int minDays(int[] bloomDay, int m, int k) {
        if(m*k > bloomDay.length) return -1;
        int max = 0;
        this.m = m;
        this.k=k;
        for(int v:bloomDay) max = Math.max(max,v);
        
        return binarySearch(bloomDay,1,max);
    }
    
    public int binarySearch(int[] a, int low,int high){
        while(low<high){
            int mid = (low+high)/2;
            if(isPossible(a,mid)) high = mid;
            else low = mid+1;
        }
        return low;
    }
    
    public boolean isPossible(int[] a,int val){
        int low = 0;
        int ans = 0;
        
        for(int i=0;i<a.length;i++){
            if(a[i] > val){
                ans+= ((i-low)/k);
                if(ans == m) return true;
                low=i+1;
            }
        }
        
        ans+= ((a.length-low)/k);
        return (ans>=m);
    }
}