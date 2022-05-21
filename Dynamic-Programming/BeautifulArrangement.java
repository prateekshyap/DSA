/*https://leetcode.com/problems/beautiful-arrangement/solution/*/

/*TLE Brute Force*/
class Solution
{
    int count;
    int[] primes = {419,421,431,433,439,443,449,457,461,463,467,479,487,491,499,503,509,521,523,541};
    public int countArrangement(int n)
    {
        int[] nums = new int[n];
        int i;
        for (i = 1; i <= n; ++i)
            nums[i-1] = i;

        count = 0;
        
        //recursion call
        recurPerm(nums,0,n-1);
        
        return count;
    }
    
    public void recurPerm(int[] nums, int l, int r)
    {
        //base case
        if (l == r)
        {
        	//add the permutation to the list
            if (isBeautiful(nums)) ++count;
        }
        else
        {
        	//for every integer in the range
            for (int i = l; i <= r; ++i)
            {
                nums = swap(nums,l,i); //backtracking step-1 - swap
                recurPerm(nums,l+1,r); //backtracking step-2 - recur
                nums = swap(nums,l,i); //backtracking step-3 - backtrack
            }
        }
    }
    
    public int[] swap(int[] nums, int l, int i)
    {
        int temp = nums[l];
        nums[l] = nums[i];
        nums[i] = temp;
        return nums;
    }
    
    public boolean isBeautiful(int[] nums)
    {
        for (int i = 0; i < nums.length; ++i)
            if (nums[i]%(i+1) != 0 && (i+1)%nums[i] != 0) return false;
        return true;
    }
}

/*Small Condition checking*/

class Solution
{
    int count;
    int[] primes = {419,421,431,433,439,443,449,457,461,463,467,479,487,491,499,503,509,521,523,541};
    public int countArrangement(int n)
    {
        int[] nums = new int[n];
        int i;
        for (i = 1; i <= n; ++i)
            nums[i-1] = i;

        count = 0;
        
        //recursion call
        recurPerm(nums,0,n-1);
        
        return count;
    }
    
    public void recurPerm(int[] nums, int l, int r)
    {
        //base case
        if (l == r)
        {
        	//add the permutation to the list
            if (isBeautiful(nums)) ++count;
        }
        else
        {
        	//for every integer in the range
            for (int i = l; i <= r; ++i)
            {
                nums = swap(nums,l,i); //backtracking step-1 - swap
                if (nums[l]%(l+1) == 0 || (l+1)%nums[l] == 0)
                    recurPerm(nums,l+1,r); //backtracking step-2 - recur
                nums = swap(nums,l,i); //backtracking step-3 - backtrack
            }
        }
    }
    
    public int[] swap(int[] nums, int l, int i)
    {
        int temp = nums[l];
        nums[l] = nums[i];
        nums[i] = temp;
        return nums;
    }
    
    public boolean isBeautiful(int[] nums)
    {
        for (int i = 0; i < nums.length; ++i)
            if (nums[i]%(i+1) != 0 && (i+1)%nums[i] != 0) return false;
        return true;
    }
}

/*DP and backtracking*/

class Solution
{
    boolean[] visited;
    int count;
    public int countArrangement(int n)
    {
        count = 0;
        visited = new boolean[n+1];
        recur(n,1);
        return count;
    }
    public void recur(int n, int pos)
    {
        if (pos > n) ++count;
        for (int i = 1; i <= n; ++i)
        {
            if (!visited[i] & (pos%i == 0 || i%pos == 0))
            {
                visited[i] = true;
                recur(n,pos+1);
                visited[i] = false;
            }
        }
    }
}