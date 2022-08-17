/*
https://www.interviewbit.com/problems/prettyprint/
*/

vector<vector<int> > Solution::prettyPrint(int A) {
    int n=2*A-1;
    vector<vector<int>> ans(n, vector<int>(n, A));
    
    // for(int i=0; i<A; i++)
    // {
    //     for(int j=i; j<A; j++)
    //     {
    //         ans[i][j] = A-1;
            
    //     }
    // }
    
    for(int i=1; i<A; i++)
    {
        for(int j=i; j<A; j++)
        {
            int val = A-i;
            ans[i][j] = val; // A-0, A-1, A-2 .. // top left to right
            ans[j][i] = val; // top left to down
            
            ans[n-1-i][j] = val; // left bottom to right
            ans[n-1-j][i] = val; // left bottom to top
            
            ans[i][n-1-j] = val; // right top to left
            ans[j][n-1-i] = val; // right top to down
            
            ans[n-1-i][n-1-j] = val; // right bottom to right
            ans[n-1-j][n-1-i] = val; // right bottom to top
        }
    }
    
    return ans;
}
