/*https://leetcode.com/problems/count-number-of-ways-to-place-houses/*/

class Solution {
    Integer[][][] dp;
    public int countHousePlacements(int n) {
        dp = new Integer[n][2][2];
        return count(n,0,0,0);
    }
    public int count(int n, int index, int up, int down)
    {
        if (index == n) return 1;
        if (dp[index][up][down] != null) return dp[index][up][down];
        long result = 0;
        result += count(n,index+1,0,0); //not placing any house
        result %= 1000000007;
        if (up == 0 && down == 0) //if previous houses are not placed, any combination is possible
        {
            result += count(n,index+1,0,1);
            result += count(n,index+1,1,0);
            result += count(n,index+1,1,1);
            result %= 1000000007;
        }
        else if (up == 0) //if previous house is placed on the down lane, now we can only place in the up lane
        {
            result += count(n,index+1,1,0);
            result %= 1000000007;
        }
        else if (down == 0) //similar logic
        {
            result += count(n,index+1,0,1);
            result %= 1000000007;
        }
        dp[index][up][down] = (int)result;
        return (int)result;
    }
}

class Solution {
    public int countHousePlacements(int n) {
        long placed = 1, empty = 1, nextPlaced, nextEmpty;
        int i;
        for (i = 2; i <= n; ++i) //calculating only for up lane
        {
            nextPlaced = empty; //for all previous places, we have to leave the current as empty
            nextEmpty = (placed+empty)%1000000007; //for all previous empty, we can either place or keep empty
            placed = nextPlaced; //move
            empty = nextEmpty; //move
        }
        return (int)((placed+empty)%1000000007*(placed+empty)%1000000007); //up lane multiplied with down lane
    }
}