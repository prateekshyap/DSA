/*https://practice.geeksforgeeks.org/problems/diagonal-morning-assembly0028/1/*/

class Solution
{
    void diagonalSort(int matrix[][], int n, int m)
    {
        //initialize variables to the bottom left element
        int rStart = n-1, cStart = 0, rEnd = n-1, cEnd = 0;

        //till we reach the topright corner
        while (rStart != 0 || cStart != m-1)
        {
            //skip the principal diagonal
            if (rStart != 0 || cStart != 0)
            {
                ArrayList<Integer> list = new ArrayList<Integer>();
                
                //from start to end, add to the list
                for (int i = rStart, j = cStart; i <= rEnd && j <= cEnd; ++i, ++j)
                    list.add(matrix[i][j]);

                //sort appropriately
                if (rStart != 0)
                    Collections.sort(list);
                else
                    Collections.sort(list,Collections.reverseOrder());
                
                //store back
                int iterator = 0;
                for (int i = rStart, j = cStart; i <= rEnd && j <= cEnd; ++i, ++j)
                    matrix[i][j] = list.get(iterator++);
            }

            //move upwards after reaching bottom right corner
            if (cEnd != m-1)
                ++cEnd;
            else
                --rEnd;

            //move right after reaching top left corner
            if (rStart != 0)
                --rStart;
            else
                ++cStart;
        }
    }
}