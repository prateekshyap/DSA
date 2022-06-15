/*
https://binarysearch.com/problems/Bomber-Man
Bomber Man

*/
int solve_(vector<vector<int>>& matrix) {
    
    int m = matrix.size();
    int n = matrix[0].size();

    vector<int> row(m,0), col(n,0);

    for(int i=0; i<m; i++)
        for(int j=0; j<n; j++)
        {
            if(matrix[i][j]==1)
            {
                row[i]=1;
                col[j]=1;
            }
        }
    
    int safe=0;
    for(int i=0; i<m; i++)
        for(int j=0; j<n; j++)
        {
            if(!row[i] && !col[j])
            {
                safe++;
            }
        }
    return safe;
}

int solve(vector<vector<int>>& matrix) {
    
    int m = matrix.size();
    int n = matrix[0].size();

    set<int> sr, sc;

    for(int i=0; i<m; i++)
        for(int j=0; j<n; j++)
        {
            if(matrix[i][j]==1)
            {
                sr.insert(i);
                sc.insert(j);
            }
        }
    
    return (m-sr.size())*(n-sc.size());
}