/*https://leetcode.com/problems/snakes-and-ladders/*/

class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int win = n*n;
        Map<Integer,Integer> map = new HashMap<>();
        int dir = 1;
        for (int i = 1; i <= win; ++i)
        {
            int c = i%n-1;
            if (c < 0) c = n-1;
            int r = n-(((i-1)/n)+1);
            if (dir == 0)
                c = n-c-1;
            // System.out.println(r+" "+c);
            if (board[r][c] != -1)
                map.put(i,board[r][c]);
            if (i%n == 0) dir = 1-dir;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        
        boolean[] visited = new boolean[win+1];
        int step = 0;
        while (!queue.isEmpty())
        {
            int size = queue.size();
            while (size-- > 0)
            {
                int cur = queue.poll();
                if (cur == win)
                    return step;
                for (int next = cur + 1; next <= Math.min(cur + 6, win); ++next)
                {
                    int dest = map.containsKey(next) ? map.get(next) : next;
                    if (!visited[dest])
                    {
                        visited[dest] = true;
                        queue.offer(dest);
                    }
                }
            }
            step++;
        }
        
        return -1;
    }
}

