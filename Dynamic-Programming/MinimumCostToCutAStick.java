/*https://leetcode.com/problems/minimum-cost-to-cut-a-stick/*/

class Solution {
    int[] newCuts;
    int[][] table;
    public int minCost(int n, int[] cuts) {
        int m = cuts.length;
        newCuts = new int[m+2];
        System.arraycopy(cuts,0,newCuts,1,m);
        newCuts[m+1] = n;
        for (int i = 0; i < m; ++i)
            System.out.print(cuts[i]+" ");
        System.out.println();
        for (int i = 0; i <= m+1; ++i)
            System.out.print(newCuts[i]+" ");
        Arrays.sort(newCuts);
        
        table = new int[m+2][m+2];
        for (int r = 0; r < m+2; ++r)
            Arrays.fill(table[r],-1);
        
        return cut(0, newCuts.length-1);
    }
    public int cut(int left, int right)
    {
        if (table[left][right] != -1) return table[left][right];
        
        if (right-left == 1) return 0;
        
        int result = Integer.MAX_VALUE;
        for (int mid = left+1; mid < right; ++mid)
        {
            int cost = cut(left,mid)+cut(mid,right)+newCuts[right]-newCuts[left];
            result = Math.min(result,cost);
        }
        
        table[left][right] = result;
        return result;
    }
}