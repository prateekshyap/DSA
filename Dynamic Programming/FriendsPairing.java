/*https://practice.geeksforgeeks.org/problems/friends-pairing-problem5425/1/*/

class Solution
{
    public long countFriendsPairings(int n) 
    {
    	//base cases
        if (n == 1) return 1;
        if (n == 2) return 2;
        long[] table = new long[n+1];
        table[1] = 1;
        table[2] = 2;

        //for other cases
        for (int i = 3; i <= n; ++i)
        	//keep i single or pair it with someone
            table[i] = (table[i-1]+(i-1)*table[i-2])%1000000007;
        return table[n];
    }
}