/*https://leetcode.com/problems/water-and-jug-problem/*/

class Solution {
    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        int[] dir = {jug1Capacity,-jug1Capacity,jug2Capacity,-jug2Capacity};
        if (targetCapacity > jug1Capacity+jug2Capacity) return false;
        boolean[] visited = new boolean[jug1Capacity+jug2Capacity+1];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        visited[0] = true;
        while (q.size() > 0)
        {
            int size = q.size();
            while (size-- > 0)
            {
                int rem = q.remove();
                if (rem == targetCapacity) return true;
                for (int k = 0; k < 4; ++k)
                {
                    int pos = rem+dir[k];
                    if (pos > jug1Capacity+jug2Capacity || pos < 0 || visited[pos] == true) continue;
                    q.add(pos);
                    visited[pos] = true;
                }
            }
            
        }
        return false;
    }
}