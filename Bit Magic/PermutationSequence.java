/*https://leetcode.com/problems/permutation-sequence/*/

class Solution {
    int[] facts;
    public String getPermutation(int n, int k) {
        --k; //reduce k by 1
        StringBuffer perm = new StringBuffer("");
        StringBuffer currChar = new StringBuffer("");
        int currDigit = -1;

        //store factorials from 1 to n
        facts = new int[n+1];
        storeFactorial(n);

        int[] hash = new int[n];
        
        //till k is greater than 0
        while (k > 0)
        {
            currDigit = getMin(hash,n); //get the minimum available digit from hash
            currChar = new StringBuffer(Integer.toString(currDigit)); //convert to string
            while (facts[n-(perm.length()+1)] <= k) //if the permutations after fixing this digit is less than or equal to k
            {
                k -= facts[n-(perm.length()+1)]; //subtract it from k
                currDigit = getNextMin(hash,n,currDigit); //get the next minimum available digit from hash
                currChar = new StringBuffer(Integer.toString(currDigit)); //convert to string
            }
            perm.append(currChar); //append the current character to final answer
            hash[currDigit-1] = 1; //mark it as added
        }
        for (int i = 0; i < n; ++i) //for each digit
            if (hash[i] == 0) //if not already appended
                perm.append(Integer.toString(i+1)); //append it
        return perm.toString();
    }
    public void storeFactorial(int n)
    {
        facts[0] = 1;
        facts[1] = 1;
        for (int i = 2; i <= n; ++i)
            facts[i] = facts[i-1]*i;
    }
    public int getMin(int[] hash, int n)
    {
        for (int i = 0; i < n; ++i)
            if (hash[i] == 0)
                return i+1;
        return -1;
    }
    public int getNextMin(int[] hash, int n, int currMin)
    {
        for (int i = currMin; i < n; ++i)
            if (hash[i] == 0)
                return i+1;
        return -1;
    }
}