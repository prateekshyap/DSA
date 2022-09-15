/*https://leetcode.com/problems/freedom-trail/*/

class Solution {
    Integer[][] table;
    public int findRotateSteps(String ring, String key) {
        table = new Integer[key.length()][ring.length()];
        table[0][0] = solve(ring.toCharArray(),key.toCharArray(),0,0);
        return table[0][0];
    }
    private int solve(char[] ring, char[] key, int index, int ringPos)
    {
        if (index == key.length) return 0;
        
        if (table[index][ringPos] != null) return table[index][ringPos];
        
        int minSteps = 100000;
        
        int newPos = ringPos, steps = 0;
        while (ring[newPos] != key[index])
        {
            newPos = (newPos+1)%ring.length;
            ++steps;
        }
        ++steps;
        minSteps = Math.min(minSteps,steps+solve(ring,key,index+1,newPos));
        newPos = ringPos; steps = 0;
        while (ring[newPos] != key[index])
        {
            newPos = newPos-1;
            if (newPos == -1) newPos = ring.length-1;
            ++steps;
        }
        ++steps;
        minSteps = Math.min(minSteps,steps+solve(ring,key,index+1,newPos));
        
        // System.out.println(minSteps+" "+index);
        return table[index][ringPos] = minSteps;
    }
}