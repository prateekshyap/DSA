/*https://leetcode.com/problems/profitable-schemes/*/

class Solution {
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        Integer[][][] table = new Integer[101][101][101];
        return find(0,0,0,n,minProfit,group,profit,table);
    }
    private int find(int pos, int count, int profit, int n, int minProfit, int[] group, int[] profits, Integer[][][] table)
    {
        if (pos == group.length) return profit >= minProfit ? 1 : 0;
        
        if (table[pos][count][profit] != null) return table[pos][count][profit];
        
        //skip the current crime
        int totalWays = find(pos+1, count, profit, n, minProfit, group, profits, table);
        
        if (count+group[pos] <= n) // if there are enough criminals available
            totalWays += find(pos+1, count+group[pos], Math.min(minProfit,profit+profits[pos]), n, minProfit, group, profits, table); //commit the crime and add the number of ways to do it
        
        return table[pos][count][profit] = totalWays%(int)(1e9+7);
    }
}