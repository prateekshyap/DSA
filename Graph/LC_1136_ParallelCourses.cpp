/*
https://leetcode.com/problems/parallel-courses/
https://www.codingninjas.com/codestudio/problems/parallel-courses_1376444
*/

int parallelCourses(int n, vector<vector<int>> &relations)
{
    int semesters=0;
    queue<int> q;
    vector<int> ind(n,0); // indegree
    vector<int> adj[n+1];  // adjacency list

    for(const auto& p: relations){
        adj[p[0]-1].push_back(p[1]-1); // numbered 1 to N
        ind[p[1]-1]++;
    }


    for(int i=0; i<n; i++)
    {
        if(ind[i]==0)
            q.push(i);
    }

    int cnt=0;

    while(!q.empty())
    {
        int qsize = q.size();
        while(qsize--)
        {
            const int e = q.front(); q.pop();
            cnt++;
            for(const auto& x: adj[e] )
            {
                if(--ind[x] == 0)
                    q.push(x);
            }
        }
        semesters++;
    }

    return cnt == n ? semesters : -1;
}
