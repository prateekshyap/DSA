/*
https://binarysearch.com/problems/Condo-Developers
*/

vector<vector<int>> solve(vector<vector<int>>& matrix) {
    int m = matrix.size();
    int n = matrix[0].size();

    vector<int> we_row(m, 0); // west east max
    vector<int> ns_col(n, 0); // north south max
    int mxrow =0, mxcol=0;

    for(int r=0; r<m; r++)
    {
        for(int c=0; c<n; c++)
        {
            ns_col[c] = max(ns_col[c], matrix[r][c]);
            we_row[r] = max(we_row[r], matrix[r][c]);
        }
    }

    // for(int x: we_row)
    //     cout<<x<<endl;
    // for(int x: ns_col)
    //     cout<<x<<" ";

    for(int r=0; r<m; r++)
    {
        for(int c=0; c<n; c++)
        {
            matrix[r][c] = min(ns_col[c], we_row[r]);
        }
    }

    return matrix;
}