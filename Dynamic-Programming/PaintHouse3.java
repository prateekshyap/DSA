/*https://leetcode.com/problems/paint-house-iii/*/

class Solution {
    //int unPainted;
    int target;
    int result;
    int[][] cost;
    int m, n;
    Integer[][][] dp;
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        //unPainted = 0;
        this.target = target;
        this.cost = cost;
        this.m = m;
        this.n = n;
        dp = new Integer[100][100][21];
        result = recur(houses, 0, 0, 0);
        return result == 1000001 ? -1 : result;
    }
    public int recur(int[] houses, int index, int prevHouseColour, int neighbourhood)
    {
        if (index == m)
        {
            if (neighbourhood == target) return 0;
            return 1000001;
        }
        if (neighbourhood > target) return 1000001;
        
        if (dp[index][neighbourhood][prevHouseColour] != null) return dp[index][neighbourhood][prevHouseColour];
        
        int j, minCost = 1000001, currCost;
        
        if (houses[index] != 0)
            minCost = recur(houses, index+1, houses[index], neighbourhood+(houses[index] == prevHouseColour ? 0 : 1));
        else
        {
            for (j = 0; j < n; ++j)
            {
                //houses[index] = j+1;
                currCost = recur(houses, index+1, j+1, neighbourhood+(j+1 == prevHouseColour ? 0 : 1))+cost[index][j];
                if (currCost < minCost) minCost = currCost;
            }
        }
        dp[index][neighbourhood][prevHouseColour] = minCost;
        return minCost;
    }
 /*   public int getCurrentNeighbourhood(int[] nums)
    {
        int i, j = 0;
        int start = -1, end = -1, count = 0; //set to -1
        start = end = nums[0]; //initialize with the first element of the current interval
        for (i = 1; i < nums.length; ++i) //for each element
        {
            if (nums[i] == 0) ++unPainted;
            if (nums[i] == 0 && nums[j] != 0) continue;
            else if (nums[i] == nums[j])
            {
                end = nums[i]; //if streak exists, update end index
                j = i;
            }
            else //otherwise
            {
                if (start != 0) ++count;
                start = end = nums[i]; //update start and end to the first index of the next window
                j = i;
            }
        }
        
        //add the last interval
        if (start != 0) ++count;

        return count;
    }*/
}

class Solution {
    int[] houses;
    int[][] costs;
    int noc, noh, target;
    Integer[][][] minWays;
    static final int MAX_COST = (int)1e6+1;
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        this.houses = houses;
        this.costs = cost;
        this.noh = m;
        this.noc = n;
        this.target = target;
        minWays = new Integer[target+1][noc+2][noh+1];
        minWays[0][0][0] = solve(0,-1,0);
        if (minWays[0][0][0] >= MAX_COST) return -1;
        return minWays[0][0][0];
    }
    public int solve(int nCount, int prevColor, int index)
    {
        if (nCount > target) return MAX_COST;
        if (nCount == target && index == noh) return 0;
        if (index == noh) return MAX_COST;
        
        if (minWays[nCount][prevColor+1][index] != null) return minWays[nCount][prevColor+1][index];
        int result = MAX_COST, col, minCol = noc+1, curr;
        if (houses[index] != 0)
        {
            if (houses[index] == prevColor)
                result = Math.min(result, solve(nCount, houses[index], index+1));
            else result = Math.min(result, solve(nCount+1, houses[index], index+1));
        }
        else
        {
            for (col = 1; col <= noc; ++col)
            {
                if (col == prevColor)
                    result = Math.min(result, solve(nCount, col, index+1)+costs[index][col-1]);
                else result = Math.min(result, solve(nCount+1, col, index+1)+costs[index][col-1]);
            }
        }
        minWays[nCount][prevColor+1][index] = result;
        return result;
    }
}