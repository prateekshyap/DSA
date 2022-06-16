/*https://practice.geeksforgeeks.org/problems/minimum-swaps-for-bracket-balancing2704/1*/

class Solution{
    static int minimumNumberOfSwaps(String S){
        // code here
        int swap = 0, x = 0, i, n = S.length();
        for (i = 0; i < n; ++i)
        {
            if (S.charAt(i) == '[')
                --x;
            else
            {
                ++x;
                if (x > 0)
                    swap += x;
            }
        }
        return swap;
    }
}