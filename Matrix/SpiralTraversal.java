/*https://leetcode.com/problems/spiral-matrix/*/

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int rs = 0, re = matrix.length-1, cs = 0, ce = matrix[0].length-1;
        List<Integer> l = new ArrayList<Integer>();
        int i = 0, j = 0;

        //till we have more elements
        while (rs <= re && cs <= ce)
        {
        	//add the top row
            for (j = cs; j <= ce; ++j)
            {
                if (matrix[i][j] != -1000)
                {
                    l.add(matrix[i][j]);
                    matrix[i][j] = -1000;
                }
            }

            //delete top row
            ++rs; --j;

            //add right column
            for (i = rs; i <= re; ++i)
            {
                if (matrix[i][j] != -1000)
                {
                    l.add(matrix[i][j]);
                    matrix[i][j] = -1000;
                }
            }

            //delete right column
            --ce; --i;

            //add bottom row
            for (j = ce; j >= cs; --j)
            {
                if (matrix[i][j] != -1000)
                {
                    l.add(matrix[i][j]);
                    matrix[i][j] = -1000;
                }
            }

            //delete bottom row
            --re; ++j;

            //add left column
            for (i = re; i >= rs; --i)
            {
                if (matrix[i][j] != -1000)
                {
                    l.add(matrix[i][j]);
                    matrix[i][j] = -1000;
                }
            }

            //delete left column
            ++cs; ++i;
        }
        return l;
    }
}