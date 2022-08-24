/*https://leetcode.com/problems/jump-game-vii/*/

//tle
class Solution {
    int N;
    Boolean[] visited;
    public boolean canReach(String s, int minJump, int maxJump) {
        N = s.length();
        visited = new Boolean[N];
        visited[0] = jump(s.toCharArray(),0,minJump,maxJump);
        return visited[0];
    }
    private boolean jump(char[] s, int i, int min, int max)
    {
        if (i == N-1) return true;
        if (visited[i] != null) return visited[i];
        boolean result = false;
        for (int j = Math.min(N-1,i+max); j >= i+min; --j)
            if (s[j] == '0' && visited[j] == null)
            {
                result |= jump(s,j,min,max);
                if (result) return visited[i] = result;
            }
        return visited[i] = result;
    }
}

//bfs
class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        if(s.charAt(n-1) == '1')return false;
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        int maxRange = 0;
    
        while (!q.isEmpty())
        {
            int i = q.poll();
            int l = Math.max(i+minJump, maxRange);
            int r = Math.min(i + maxJump, n-1);
            for (int x = l; x <= r; ++x)
            {
                if (x == n-1) return true;
                if (s.charAt(x) == '0')
                    q.add(x);
            }
            maxRange = r+1;
        }
        return false;
    }
}