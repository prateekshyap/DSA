/*https://practice.geeksforgeeks.org/problems/partition-array-to-k-subsets/1*/

class Solution
{
    public boolean isKPartitionPossible(int a[], int n, int k)
    {
            
        if(n < k || k <= 0) return false;
            
        if(k == 1) return true;
        
        int sum = 0;
        
        for (int i : a) sum += i;
            
        if(sum%k != 0) return false;
            
        Arrays.sort(a);   // just to reduce TLE , no logic 
        int[] b = new int[k];
        
        return fun(a,n,k,n-1,b,sum/k,0);
    }
    
    boolean fun(int a[], int n, int k, int i, int[] b, int sum, int count){
        if (count == k-1) return true;
        
        for (int j = 0; j < k; ++j)
        {
            b[j] += a[i];
            
            if (b[j] == sum) ++count;
                
            if (b[j] <= sum) if (fun(a,n,k,i-1,b,sum,count)) return true;
            
            if (b[j] == sum) --count;
                
            b[j] -= a[i];
        }
        
        return false;
    }
}
