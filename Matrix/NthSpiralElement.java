/*https://practice.geeksforgeeks.org/problems/find-nth-element-of-spiral-matrix/1*/

class GfG
{
    /*You are required to complete this method*/
    int findK(int matrix[][], int n, int m, int k)
    {
	// Your code here
	    int rs = 0, re = n-1, cs = 0, ce = m-1;
        List<Integer> l = new ArrayList<Integer>();
        int i = 0, j = 0;

        //till we have more elements
        while (rs <= re && cs <= ce && k >= 0)
        {
        	//add the top row
            for (j = cs; j <= ce; ++j)
            {
                if (matrix[i][j] != -1000)
                {
                    if (--k == 0) return matrix[i][j];
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
                    if (--k == 0) return matrix[i][j];
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
                    if (--k == 0) return matrix[i][j];
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
                    if (--k == 0) return matrix[i][j];
                    matrix[i][j] = -1000;
                }
            }

            //delete left column
            ++cs; ++i;
        }
        return -1;
    }
}