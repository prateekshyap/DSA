/*https://leetcode.com/problems/flipping-an-image/*/

class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        int R = image.length, C = image[0].length;
        int[][] result = new int[R][C];
        for (int r = 0; r < R; ++r)
            for (int lc = 0, rc = C-1; lc < C; ++lc, --rc)
                result[r][lc] = 1-image[r][rc];
        return result;
    }
}