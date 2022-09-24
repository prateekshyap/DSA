/*https://leetcode.com/problems/brick-wall/*/

class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        int notCrossed = 0, n = wall.size();
        for (List<Integer> row : wall)
        {
            int bricksCount = 0;
            for (int i = 0; i < row.size()-1; ++i)
            {
                int brick = row.get(i);
                bricksCount += brick;
                int value = map.getOrDefault(bricksCount,0)+1;
                map.put(bricksCount,value);
                notCrossed = Math.max(notCrossed,value);
            }
        }
        return n-notCrossed;
    }
}