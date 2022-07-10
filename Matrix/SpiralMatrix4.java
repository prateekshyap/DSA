/*https://leetcode.com/problems/spiral-matrix-iv/*/

class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] matrix = new int[m][n];
        int i, j, rs = 0, re = m-1, cs = 0, ce = n-1;
        for (i = 0; i < m; ++i)
            Arrays.fill(matrix[i],-1);
        i = j = 0;
        ListNode temp = head;
        while (temp != null)
        {
            //add the top row
            for (j = cs; j <= ce; ++j)
            {
                if (temp != null)
                {
                    matrix[i][j] = temp.val;
                    temp = temp.next;
                }
                else break;
            }

            //delete top row
            ++rs; --j;

            //add right column
            for (i = rs; i <= re; ++i)
            {
                if (temp != null)
                {
                    matrix[i][j] = temp.val;
                    temp = temp.next;
                }
                else break;
            }

            //delete right column
            --ce; --i;

            //add bottom row
            for (j = ce; j >= cs; --j)
            {
                if (temp != null)
                {
                    matrix[i][j] = temp.val;
                    temp = temp.next;
                }
                else break;
            }

            //delete bottom row
            --re; ++j;

            //add left column
            for (i = re; i >= rs; --i)
            {
                if (temp != null)
                {
                    matrix[i][j] = temp.val;
                    temp = temp.next;
                }
                else break;
            }

            //delete left column
            ++cs; ++i;
        }
        
        return matrix;
    }
}