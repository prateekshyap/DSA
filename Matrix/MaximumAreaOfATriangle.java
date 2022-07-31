/*https://www.interviewbit.com/problems/maximum-area-of-triangle/*/

public class Solution {
    public int solve(String[] A) {
        int fg, fr, fb, lg, lr, lb, i, j, m = A.length, n = A[0].length(), maxArea = 0;
        double currArea = 0;
        char[][] board = new char[m][n];
        for (i = 0; i < m; ++i)
            board[i] = A[i].toCharArray();
        int rg = -1, rb = -1, rr = -1, ig = -1, ib = -1, ir = -1;
        for (j = 0; j < n; ++j)
        {
            for (i = 0; i < m; ++i)
            {
                if (board[i][j] == 'r')
                {
                    if (ir == -1) ir = j;
                    rr = j;
                }
                else if (board[i][j] == 'b')
                {
                    if (ib == -1) ib = j;
                    rb = j;
                }
                else
                {
                    if (ig == -1) ig = j;
                    rg = j;
                }
            }
        }
        
        j = 0;
        while (j < n)
        {
            fg = fr = fb = lg = lr = lb = -1;
            for (i = 0; i < m; ++i)
            {
                if (board[i][j] == 'r')
                {
                    if (fr == -1) fr = lr = i; else lr = i;
                }
                else if (board[i][j] == 'b')
                {
                    if (fb == -1) fb = lb = i; else lb = i;
                }
                else if (board[i][j] == 'g')
                {
                    if (fg == -1) fg = lg = i; else lg = i;
                }
            }
            if (fg != -1 && fb != -1 && (rr > j || ir < j))
            {
                if (rr > j)
                {
                    currArea = 0.5*((double)Math.abs(Math.min(fg,lg)-Math.max(fb,lb))+1)*((double)(rr-j+1));
                    if (Math.ceil(currArea) > maxArea) maxArea = (int)Math.ceil(currArea);
                    currArea = 0.5*((double)Math.abs(Math.min(fb,lb)-Math.min(fg,lg))+1)*((double)(rr-j+1));
                    if (Math.ceil(currArea) > maxArea) maxArea = (int)Math.ceil(currArea);
                }
                if (ir < j)
                {
                    currArea = 0.5*((double)Math.abs(Math.min(fg,lg)-Math.max(fb,lb))+1)*((double)(j-ir+1));
                    if (Math.ceil(currArea) > maxArea) maxArea = (int)Math.ceil(currArea);
                    currArea = 0.5*((double)Math.abs(Math.min(fb,lb)-Math.min(fg,lg))+1)*((double)(j-ir+1));
                    if (Math.ceil(currArea) > maxArea) maxArea = (int)Math.ceil(currArea);
                }
            }
            if (fb != -1 && fr != -1 && (rg > j || ig < j))
            {
                if (rg > j)
                {
                    currArea = 0.5*((double)Math.abs(Math.min(fb,lb)-Math.max(fr,lr))+1)*((double)(rg-j+1));
                    if (Math.ceil(currArea) > maxArea) maxArea = (int)Math.ceil(currArea);
                    currArea = 0.5*((double)Math.abs(Math.min(fr,lr)-Math.max(fb,lb))+1)*((double)(rg-j+1));
                    if (Math.ceil(currArea) > maxArea) maxArea = (int)Math.ceil(currArea);
                }
                if (ig < j)
                {
                    currArea = 0.5*((double)Math.abs(Math.min(fb,lb)-Math.max(fr,lr))+1)*((double)(j-ig+1));
                    if (Math.ceil(currArea) > maxArea) maxArea = (int)Math.ceil(currArea);
                    currArea = 0.5*((double)Math.abs(Math.min(fr,lr)-Math.max(fb,lb))+1)*((double)(j-ig+1));
                    if (Math.ceil(currArea) > maxArea) maxArea = (int)Math.ceil(currArea);
                }
            }
            if (fr != -1 && fg != -1 && (rb > j || ib < j))
            {
                if (rb > j)
                {
                    currArea = 0.5*((double)Math.abs(Math.min(fr,lr)-Math.max(fg,lg))+1)*((double)(rb-j+1));
                    if (Math.ceil(currArea) > maxArea) maxArea = (int)Math.ceil(currArea);
                    currArea = 0.5*((double)Math.abs(Math.min(fg,lg)-Math.max(fr,lr))+1)*((double)(rb-j+1));
                    if (Math.ceil(currArea) > maxArea) maxArea = (int)Math.ceil(currArea);
                }
                if (ib < j)
                {
                    currArea = 0.5*((double)Math.abs(Math.min(fr,lr)-Math.max(fg,lg))+1)*((double)(j-ib+1));
                    if (Math.ceil(currArea) > maxArea) maxArea = (int)Math.ceil(currArea);
                    currArea = 0.5*((double)Math.abs(Math.min(fg,lg)-Math.max(fr,lr))+1)*((double)(j-ib+1));
                    if (Math.ceil(currArea) > maxArea) maxArea = (int)Math.ceil(currArea);
                }
            }
            ++j;
        }
        
        return maxArea;
    }
}

