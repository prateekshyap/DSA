/*https://leetcode.com/problems/triangle/*/

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 1) return triangle.get(0).get(0);
        int i, j;
        int r = triangle.size(), c;
        List<Integer> currRow, nextRow;
        for (i = r-2; i > 0; --i)
        {
            currRow = triangle.get(i);
            nextRow = triangle.get(i+1);
            c = triangle.get(i).size();
            for (j = 0; j < c; ++j)
            {
                currRow.set(j,currRow.get(j)+Math.min(nextRow.get(j),nextRow.get(j+1)));
            }
        }
        return triangle.get(0).get(0)+Math.min(triangle.get(1).get(0),triangle.get(1).get(1));
    }
}