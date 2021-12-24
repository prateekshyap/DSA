/* https://leetcode.com/problems/flood-fill/
 * An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.
 * You are also given three integers sr, sc, and newColor.
 * You should perform a flood fill on the image starting from the pixel image[sr][sc].
 * To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally to
 * the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally
 * to those pixels (also with the same color), and so on. Replace the color of all of the aforementioned pixels with newColor.
 */
class Solution {
public:


    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int newColor) {

        dfsFloodFill(image, sr, sc, newColor, image[sr][sc], image.size(), image[0].size());

        return image;

    }//floodFill

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