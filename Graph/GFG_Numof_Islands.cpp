/* https://practice.geeksforgeeks.org/problems/find-the-number-of-islands/1#
 * Given a grid consisting of '0's(Water) and '1's(Land). Find the number of islands.
 * Note: An island is surrounded by water and is formed by connecting adjacent lands
 * horizontally or vertically or diagonally i.e., in all 8 directions.
 */

// { Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
class Solution {
public:
    vector<pair<int,int>> coordinates = {
            {-1, -1}, {-1,0}, {-1,1},
            {0, -1}, {0, 1},
            {1, -1}, {1,0}, {1,1}
    };
    int new_x, new_y;
    // Function to find the number of islands.
    int numIslands(vector<vector<char>>& grid) {

        int m = grid.size();
        int n = grid[0].size();
        int cnt_lands=0;

        if(m==0) return 0;

        // vector<vector<bool>> visited(m, vector<bool>(n, false));

        for(int r = 0; r<m; r++)
        {
            for(int c = 0; c<n; c++){

                // cout<<grid[r][c]<<" ";
                if(grid[r][c]=='1'){  // we mark it 2 in order to connect all adj lands
                    // dfsLands(grid, r, c, m, n);
                    bfsLands(grid, r, c, m, n);
                    cnt_lands++;            // grid value 1 means atleast one land we have find.
                }//if
            }//for c
            // cout<<endl;
        }// for r

        return cnt_lands;
    }// numIsLands

    // original grid, visited matrix, x and y coordinate
    void dfsLands(vector<vector<char>>& grid,  int x, int y, int m, int n){

        if(x<0 || x>=m || y <0 || y>=n || grid[x][y]!='1') return;

        grid[x][y]='2';         // mark 2 in order to make it detected
        for (int i=0; i<8; i++)         // checking all the 8 directions
        {
            new_x = x + coordinates[i].first;
            new_y = y + coordinates[i].second;

            dfsLands(grid, new_x, new_y, m, n);
        }
    }//dfsLands

    void bfsLands(vector<vector<char>>& grid,  int x, int y, int m, int n)
    {
        queue<pair<int,int>> q;
        q.push({x,y});

        while(!q.empty()){
            x = q.front().first;
            y = q.front().second; q.pop();

            for (int i=0; i<8; i++)         // checking all the 8 directions
            {
                new_x = x + coordinates[i].first;
                new_y = y + coordinates[i].second;

                if(new_x>=0 && new_x<m && new_y>=0 && new_y<n && grid[new_x][new_y]=='1')
                {
                    grid[new_x][new_y]='2';
                    q.push({new_x, new_y});
                }
            }

        }//while q

    }//bfsLands
};

// { Driver Code Starts.
int main() {
    int tc;
    cin >> tc;
    while (tc--) {
        int n, m;
        cin >> n >> m;
        vector<vector<char>> grid(n, vector<char>(m, '#'));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                cin >> grid[i][j];
            }
        }
        Solution obj;
        int ans = obj.numIslands(grid);
        cout << ans << '\n';
    }
    return 0;
}  // } Driver Code Ends