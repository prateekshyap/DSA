/*https://leetcode.com/problems/positions-of-large-groups/*/

class Solution {
    public List<List<Integer>> largeGroupPositions(String s) {
        char curr = s.charAt(0);
        int streak = 0;
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = 0; i < s.length(); ++i)
        {
            if (s.charAt(i) == curr)
                ++streak;
            else
            {
                if (streak >= 3)
                    result.add(Arrays.asList(i-streak,i-1));
                streak = 1;
                curr = s.charAt(i);
            }
        }
        if (streak >= 3)
            result.add(Arrays.asList(s.length()-streak,s.length()-1));
        return result;
    }
}