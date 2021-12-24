/*https://practice.geeksforgeeks.org/problems/flood-fill-algorithm1856/1*/

class Solution
{
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor)
    {
        // Code here
        if (image[sr][sc] == newColor) return image;
        Matrix m = new Matrix(image);
        flood(m,sr,sc,image[sr][sc],newColor);
        return m.m;
    }
    public void flood(Matrix m, int r, int c, int oldCol, int newCol)
    {
        if (r < 0 || r >= m.m.length || c < 0 || c >= m.m[0].length || m.m[r][c] != oldCol)
            return;
        m.m[r][c] = newCol;
        flood(m,r-1,c,oldCol,newCol); //up
        flood(m,r,c-1,oldCol,newCol); //left
        flood(m,r+1,c,oldCol,newCol); //down
        flood(m,r,c+1,oldCol,newCol); //right
        return;
    }
}