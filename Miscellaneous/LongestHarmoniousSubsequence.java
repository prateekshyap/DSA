/*https://leetcode.com/problems/longest-harmonious-subsequence/*/

class Solution {
    public int findLHS(int[] nums) {
        TreeMap<Integer,Integer> map = new TreeMap<Integer,Integer>();
        for (int num : nums)
            map.put(num,map.getOrDefault(num,0)+1);
        int[][] entry = new int[map.size()][2];
        int i = 0;
        for (Map.Entry e : map.entrySet())
        {
            entry[i][0] = (Integer)e.getKey();
            entry[i][1] = (Integer)e.getValue();
            ++i;
        }
        i = 0; int j = 1, result = 0;
        // for (int k = 0; k < entry.length; ++k)
        // {
        //     System.out.println(entry[k][0]+" "+entry[k][1]);
        // }
        while (j < entry.length)
        {
            if (entry[i][0] == entry[j][0]-1)
                result = Math.max(result,entry[i][1]+entry[j][1]);
            ++i;++j;
        }
        return result;
    }
}