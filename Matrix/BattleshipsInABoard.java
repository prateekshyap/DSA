/*https://leetcode.com/problems/battleships-in-a-board/*/

class Solution {
    public int countBattleships(char[][] board) {
        int battleshipCount = 0;
        int R = board.length, C = board[0].length;
        for (int i = 0; i < R; ++i)
        {
            for (int j = 0; j < C; ++j)
            {
                int hvInd = 0;
                if (board[i][j] == 'X')
                {
                    if (i+1 < R && board[i+1][j] == 'X') hvInd = 1;
                    else if (j+1 < C && board[i][j+1] == 'X') hvInd = 2;
                    else hvInd = -1;
                }
                if (hvInd == -1)
                {
                    board[i][j] = '.';
                    ++battleshipCount;
                }
                else if (hvInd != 0)
                {
                    if (hvInd == 1)
                    {
                        int r = i, c = j;
                        while (r < R && board[r][c] == 'X')
                        {
                            board[r][c] = '.';
                            ++r;
                        }
                    }
                    else
                    {
                        int r = i, c = j;
                        while (c < C && board[r][c] == 'X')
                        {
                            board[r][c] = '.';
                            ++c;
                        }
                    }
                    ++battleshipCount;
                }
            }
        }
        return battleshipCount;
    }
}