/*https://leetcode.com/problems/distribute-candies/*/

class Solution {
    public int distributeCandies(int[] candyType) {
        Set<Integer> candySet = new HashSet<Integer>();
        int maxPossible = candyType.length/2;
        for (int candy : candyType)
        {
            candySet.add(candy);
            if (candySet.size() > maxPossible) return maxPossible;
        }
        return Math.min(maxPossible,candySet.size());
    }
}