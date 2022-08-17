/*https://leetcode.com/problems/last-stone-weight-ii/*/

class Solution {
    Integer[][] table;
    public int lastStoneWeightII(int[] stones) {
        Arrays.sort(stones);
        int sum = 0;
        for (int stone : stones)
            sum += stone;
        int breakPoint = sum/2;
        table = new Integer[stones.length][breakPoint+1];
        int nearest = solve(stones,stones.length-1,breakPoint);
        return sum-(2*nearest);
    }
    private int solve(int[] stones, int index, int breakPoint)
    {
        if (breakPoint == 0 || index < 0) return 0;
        if (table[index][breakPoint] != null) return table[index][breakPoint];
        int stone = stones[index];
        int max = solve(stones,index-1,breakPoint);
        if (stone <= breakPoint)
            max = Math.max(max,stone+solve(stones,index-1,breakPoint-stone));
        return table[index][breakPoint] = max;
    }
}