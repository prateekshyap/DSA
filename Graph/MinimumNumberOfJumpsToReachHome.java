/*https://leetcode.com/problems/minimum-jumps-to-reach-home/*/

class Solution {
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        // if (a >= b && a > x) return -1;
        Set<Integer> forbiddenSet = new HashSet<Integer>();
        for (int forbiddenPos : forbidden)
            forbiddenSet.add(forbiddenPos);
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.add(new int[]{0,1,0}); // [position,direction,jumpsCount]
        boolean[][] visited = new boolean[2000+(2*b)][2];
        while (!queue.isEmpty())
        {
            int[] pos = queue.poll();
            if (pos[0] == x) return pos[2]; //if position is home, return jumpsCount
            if (visited[pos[0]][pos[1]]) continue; //if already visited, continue
            visited[pos[0]][pos[1]] = true; //mark as visited
            int[] newPos = new int[]{pos[0]+a,1,pos[2]+1}; //move forward a steps
            if (newPos[0] < visited.length && !forbiddenSet.contains(pos[0]) && (pos[1] == 1 || newPos[1] != 0) && !visited[newPos[0]][newPos[1]])
                queue.add(newPos); //add to queue, if not visited, not forbidden and not negative
            newPos = new int[]{pos[0]-b,0,pos[2]+1}; //move backward b steps
            if (newPos[0] < 0) continue;
            if (newPos[0] < visited.length && !forbiddenSet.contains(pos[0]) && (pos[1] == 1 || newPos[1] != 0) && !visited[newPos[0]][newPos[1]])
                queue.add(newPos); //add to queue, if not visited, not forbidden and not negative
        }
        return -1;
    }
}