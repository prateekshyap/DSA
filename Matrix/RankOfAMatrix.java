/*https://practice.geeksforgeeks.org/problems/rank-of-matrix/0*/

/*Using Echelon Form Conversion*/

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static double[][] swapRows(double[][] mat, int r1, int r2)
    {
        double temp;
        for (int i = 0; i < 3; ++i)
        {
            temp = mat[r1][i];
            mat[r1][i] = mat[r2][i];
            mat[r2][i] = temp;
        }
        return mat;
    }
    public static void main (String[] args) throws IOException
    {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(br.readLine());
        String[] tokens;
        double[][] mat = new double[3][3];
        int i, j;
        double p, q;
        double[] temp;
        boolean isPrinted = false;
        for (int ii = 0; ii < cases; ++ii) //for each test case
        {
            //read the matrix
            for (i = 0; i < 3; ++i)
            {
                tokens = br.readLine().trim().split(" +");
                for (j = 0; j < 3; ++j)
                    mat[i][j] = Integer.parseInt(tokens[j]);
            }
            
            if (mat[2][0] == 0 && mat[2][1] == 0 && mat[2][2] == 0) //if last row is 0
            {
                if (mat[1][0] == 0 && mat[1][1] == 0 && mat[1][2] == 0) //if middle row is 0
                {
                    if (mat[0][0] == 0 && mat[0][1] == 0 && mat[0][2] == 0) //if 1st row is 0
                    {
                        System.out.println("0"); //rank is 0
                        isPrinted = true;
                    }
                    else //otherwise
                    {
                        System.out.println("1"); //rank is 1
                        isPrinted = true;
                    }
                }
            }
            if (!isPrinted){ //for all other cases
                //bring the minimum row to the top
                if (Math.abs(mat[0][0]) > Math.abs(mat[1][0]) && Math.abs(mat[2][0]) > Math.abs(mat[1][0])) swapRows(mat,0,1);
                else if (Math.abs(mat[0][0]) > Math.abs(mat[2][0]) && Math.abs(mat[1][0]) > Math.abs(mat[2][0])) swapRows(mat,0,2);
                
                //if (mat[0][0] is zero then swap with the other minimum one)
                if (mat[0][0] == 0)
                {
                    if (mat[1][0] == 0) swapRows(mat,0,2);
                    else if (mat[2][0] == 0) swapRows(mat,0,1);
                    else if (Math.abs(mat[1][0]) < Math.abs(mat[2][0])) swapRows(mat,0,1);
                    else swapRows(mat,0,2);
                }
        
                /*for R2-xR1*/
                //get the factor
                p = -1*mat[1][0];
                p /= mat[0][0];
                //multiply to upper row and add to lower row
                for (i = 0; i < 3; ++i)
                    mat[1][i] += mat[0][i]*p;
        
                /*for R3-xR1*/
                //get the factor
                p = -1*mat[2][0];
                p /= mat[0][0];
                //multiply to upper row and add to lower row
                for (i = 0; i < 3; ++i)
                    mat[2][i] += mat[0][i]*p;
            
                //swap if any of them is smaller
                if (mat[1][1] == 0 || (Math.abs(mat[1][1]) > Math.abs(mat[2][1]) && mat[2][1] != 0)) swapRows(mat,1,2);
                
                /*for R3-xR2*/
                //get the factor
                p = -1*mat[2][1];
                p /= mat[1][1];
                //multiply to upper row and add to lower row
                for (i = 1; i < 3; ++i)
                    mat[2][i] += mat[1][i]*p;
                
                if (mat[2][0] == 0 && mat[2][1] == 0 && mat[2][2] == 0)
                {
                    if (mat[1][0] == 0 && mat[1][1] == 0 && mat[1][2] == 0)
                    {
                        if (mat[0][0] == 0 && mat[0][1] == 0 && mat[0][2] == 0) System.out.println("0");
                        else System.out.println("1");
                    }
                    else System.out.println("2");
                }
                else System.out.println("3");
            }
        }
    }
}