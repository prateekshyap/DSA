/*
https://leetcode.com/problems/flood-fill/
733. Flood Fill

*/

//LeetCode
class Solution {
public:
    int newTarget, oldTarget;
    int m,n;
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int newColor) {
        
        m = image.size();
        n = image[0].size();
        newTarget = newColor;
        oldTarget = image[sr][sc];
        
        bfsFloodFill(image, sr,  sc);
		
		// dfsFloodFill(image, sr, sc, newColor, image[sr][sc], image.size(), image[0].size());
            
        return image;
        
    }// end
    
    void bfsFloodFill(vector<vector<int>>& matrix, int r, int c)
    {
        queue<pair<int,int>> q;
        // int r, c;

        q.push({r,c});

        while(!q.empty())
        {
            auto [r,c] = q.front();
            q.pop();

            if(matrix[r][c] == newTarget)
                continue;

            matrix[r][c]=newTarget;

            if(r-1>=0 && matrix[r-1][c] == oldTarget)
                q.push({r-1, c}); // top
            if(r+1<m && matrix[r+1][c] == oldTarget)
                q.push({r+1, c}); // bottom 
            if(c-1>=0 && matrix[r][c-1] == oldTarget)
                q.push({r, c-1}); // left
            if(c+1<n && matrix[r][c+1] == oldTarget)
                q.push({r, c+1}); // right  
        }

    }//
	
	//oldColor is what needed to change orginally.
    //newColor is what is needed to update
    void dfsFloodFill(vector<vector<int>>& image, int sr, int sc, int newColor, int oldColor, int m, int n){
        
        if(image[sr][sc] == newColor) return;       // if it is already updated then no need to change
        
           image[sr][sc] = newColor;            // update with new color.
        
        // it should be within bound and pixel value should be oldColor.
        if(sc-1 >=0 && image[sr][sc-1] == oldColor)
            dfsFloodFill(image, sr, sc-1, newColor, oldColor, m, n);  //left
        if(sr-1 >=0 && image[sr-1][sc] == oldColor)
            dfsFloodFill(image, sr-1, sc, newColor, oldColor, m, n);  //top
        if(sc+1 <n && image[sr][sc+1] == oldColor)
            dfsFloodFill(image, sr, sc+1, newColor, oldColor, m, n);  //right
        if(sr+1 <m && image[sr+1][sc] == oldColor)
            dfsFloodFill(image, sr+1, sc, newColor, oldColor, m, n);  // bottom

        
    }//dfsFloodFill
};