/*https://practice.geeksforgeeks.org/problems/reverse-spiral-form-of-matrix4033/1*/

class Solution
{
    public int[] reverseSpiral(int R, int C, int[][] a)
    {
        int[] result = new int[R*C];
        
        int rs = 0, re = R-1, cs = 0, ce = C-1;
        int i = 0, j = 0, index = R*C-1;

        //till we have more elements
        while (rs <= re && cs <= ce)
        {
            try{
        	//add the top row
            for (j = cs; j <= ce; ++j)
                result[index--] = a[i][j];

            //delete top row
            ++rs; --j;

            //add right column
            for (i = rs; i <= re; ++i)
                result[index--] = a[i][j];


            //delete right column
            --ce; --i;

            //add bottom row
            for (j = ce; j >= cs; --j)
                result[index--] = a[i][j];
                    

            //delete bottom row
            --re; ++j;

            //add left column
            for (i = re; i >= rs; --i)
                result[index--] = a[i][j];

            //delete left column
            ++cs; ++i;
            }catch(ArrayIndexOutOfBoundsException ae){break;}
        }
        return result;
        
    }
}