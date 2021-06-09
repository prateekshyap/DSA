/*https://practice.geeksforgeeks.org/problems/the-celebrity-problem/1*/


/*Here a celebrity will have 1 in the entire column
except its own position
and 0 in the entire row*/
 
class Solution
{
    int celebrity(int M[][], int n)
    {
    	for (int i = 0; i < n; ++i) //for each row
        {
        	//check if the row is completely 0 or not
            boolean isCeleb = true;
            for (int j = 0; j < n; ++j)
            {
                if (M[i][j] == 1)
                {
                    isCeleb = false;
                    break;
                }
            }

            /*if the row is 0, i is a potential candidate to be a celebrity*/

            if (isCeleb == true)
            {
                boolean retCeleb = true;

                //for each row 
                for (int k = 0; k < n; ++k)
                {
                	//if ith column at kth row is 0 i.e. if k doesn't know i, then i is not a celebrity
                    if (k != i && M[k][i] != 1)
                        retCeleb = false;                
                }

                //if the loop is uninterrupted, i is a celebrity
                if (retCeleb == true)  
                    return i;
            }
        }
        return -1;
    }
}