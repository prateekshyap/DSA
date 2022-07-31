/*https://leetcode.com/problems/equal-row-and-column-pairs/*/

class Solution {
    public int equalPairs(int[][] grid) {
        int result = 0;
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        for (int[] row : grid)
        {
            StringBuilder build = new StringBuilder("");
            for (int num : row)
            {
                build.append(num);
                build.append("$");
            }
            String str = build.toString();
            map.put(str,map.getOrDefault(str,0)+1);
        }
        for (int j = 0; j < grid[0].length; ++j)
        {
            StringBuilder build = new StringBuilder("");
            for (int i = 0; i < grid.length; ++i)
            {
                build.append(grid[i][j]);
                build.append("$");
            }
            String str = build.toString();
            if (map.containsKey(str))
                result += map.get(str);
        }
        return result;
    }
}