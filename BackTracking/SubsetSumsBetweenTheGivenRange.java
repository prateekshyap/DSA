/*https://practice.geeksforgeeks.org/problems/subset-sums-between-the-given-range/1/*/

class Solution {
    static long count;
    public static long countSubsets(int n, int[] arr, int l, int r) {
        // code here
        count = 0;
        
        solve(arr,0,0,n,l,r);
        
        return count;
    }
    public static void solve(int[] arr, int index, int sum, int n, int l, int r)
    {
        if (index == n)
        {
            if (sum >= l && sum <= r) ++count;
            return;
        }
        solve(arr,index+1,sum,n,l,r);
        solve(arr,index+1,sum+arr[index],n,l,r);
    }
}
        
