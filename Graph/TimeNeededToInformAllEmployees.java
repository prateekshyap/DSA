/*https://leetcode.com/problems/time-needed-to-inform-all-employees/*/

//tle
class Solution {
    boolean[] visited;
    int max;
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        int i, j;
        max = Integer.MIN_VALUE;
        visited = new boolean[n];
        dfs(manager,informTime,headID,n,0);
        return max;
    }
    public void dfs(int[] manager, int[] times, int head, int n, int currTime)
    {
        visited[head] = true;
        if (times[head] == 0)
        {
            if (currTime > max) max = currTime;
            return;
        }
        int i;
        for (i = 0; i < n; ++i)
            if (manager[i] == head)
                dfs(manager,times,i,n, currTime+times[head]);
    }
}

//efficient
class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        int res=0;
        for(int i=0;i<n;i++)
        {
            res=Math.max(res,check(i,manager,informTime));
        }
        return res;
    }
    public int check(int m,int[] manager,int[] informTime)
    {
        if(manager[m]!=-1)
        {
            informTime[m]=informTime[m]+check(manager[m],manager,informTime);
            manager[m]=-1;
        }
        return informTime[m];
    }
}