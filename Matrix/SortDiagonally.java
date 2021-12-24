/*https://practice.geeksforgeeks.org/problems/diagonal-morning-assembly0028/1/*/
/*Prateekshya's Solution*/
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
/*Pratik's Solution*/
class Solution
{
    void diagonalSort(int matrix[][], int n, int m)
    {
        // code here 
        int i = n-1, j = 0, diff = n-1 ;
        PriorityQueue<Integer> pq;
        while(diff!=(1-m))
        {
            if(diff==0)
            {
                i = 0;
                j += 1;
                diff--;
            }
            else if(diff>0)
            {
                pq = new PriorityQueue<Integer>(Collections.reverseOrder());
                while(i<n && j<m)
                {
                    pq.add(matrix[i][j]);
                    i++;
                    j++;
                }
                i--;
                j--;
                while(!pq.isEmpty())
                {
                    matrix[i][j] = pq.poll();
                    i--;
                    j--;
                }
                diff--;
                i = diff;
                j = 0;
            }
            else
            {
                pq = new PriorityQueue<Integer>();
                while(i<n && j<m)
                {
                    pq.add(matrix[i][j]);
                    i++;
                    j++;
                }
                i--;
                j--;
                while(!pq.isEmpty())
                {
                    matrix[i][j] = pq.poll();
                    i--;
                    j--;
                }
                diff--;
                i = 0;
                j = Math.abs(diff);
            }
        }
    }
}