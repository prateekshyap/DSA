/*https://leetcode.com/problems/count-number-of-teams/*/

//simple dp
class Solution {
    public int numTeams(int[] rating) {
        int n = rating.length;
        Integer[] dp1 = new Integer[n];
        Integer[] dp2 = new Integer[n];
        int count = 0, i, j, k;
        
        for (i = 0; i < n-2; ++i)
        {
            for (j = i+1; j < n-1; ++j)
            {
                if (rating[i] < rating[j])
                {
                    if (dp1[j] == null)
                    {
                        dp1[j] = new Integer(0);
                        for (k = j+1; k < n; ++k)
                            if (rating[j] < rating[k])
                                ++dp1[j];
                    }
                    count += dp1[j];
                }
                else if (rating[i] > rating[j])
                {
                    if (dp2[j] == null)
                    {
                        dp2[j] = new Integer(0);
                        for (k = j+1; k < n; ++k)
                            if (rating[j] > rating[k])
                                ++dp2[j];
                    }
                    count += dp2[j];
                }
            }
        }
        
        return count;
    }
}

//efficient solultion
class Solution {
    public int numTeams(int[] rating) {
        int left = 0;
        int right = 0;
        int n = rating.length;
        int res = 0;
        for(int i = 1; i < n-1; i++) {
            left = 0;
            right = 0;
            for(int j = 0; j < i; j++) {
                if(rating[j] > rating[i]) left++;
            }
            for(int k = i+1; k < n; k++) {
                if(rating[k] < rating[i]) right++;
            }
            res += left * right + (i-left) * (n-i-right-1);
        }
        return res;
    }
}