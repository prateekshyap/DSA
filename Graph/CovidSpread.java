/*https://practice.geeksforgeeks.org/problems/269f61832b146dd5e6d89b4ca18cbd2a2654ebbe/1/*/

//BFS approach
class Cell implements Comparable<Cell>
{
    int r, c;
    Cell(int r, int c)
    {
        this.r = r;
        this.c = c;
    }
    public int compareTo(Cell c)
    {
        return 0;
    }
}

class Solution{
    public int helpaterp(int[][] hospital) {
        int time = 0;
        int R = hospital.length;
        int C = hospital[0].length;
        Queue<Cell> queue = new LinkedList<Cell>();

        //add infected wards to the queue
        for (int i = 0; i < R; ++i)
        {
            for (int j = 0; j < C; ++j)
            {
                if (hospital[i][j] == 2)
                {
                    queue.add(new Cell(i,j));
                }
            }
        }

        //till the queue becomes empty
        while (!queue.isEmpty())
        {
        	//initialize a boolean variable to indicate new infections in this iteration
            boolean isInfected = false;

            //for the currently infected wards
            int len = queue.size();
            for (int i = 0; i < len; ++i)
            {
            	//get the infected cell
                Cell c = queue.poll();

                //check if any adjacent cells can be infected and mark it
                if (c.r+1 < R && hospital[c.r+1][c.c] == 1)
                {
                    isInfected = true;
                    hospital[c.r+1][c.c] = 2;
                    queue.add(new Cell(c.r+1,c.c));
                }
                if (c.c+1 < C && hospital[c.r][c.c+1] == 1)
                {
                    isInfected = true;
                    hospital[c.r][c.c+1] = 2;
                    queue.add(new Cell(c.r,c.c+1));
                }
                if (c.r-1 >= 0 && hospital[c.r-1][c.c] == 1)
                {
                    isInfected = true;
                    hospital[c.r-1][c.c] = 2;
                    queue.add(new Cell(c.r-1,c.c));
                }
                if (c.c-1 >= 0 && hospital[c.r][c.c-1] == 1)
                {
                    isInfected = true;
                    hospital[c.r][c.c-1] = 2;
                    queue.add(new Cell(c.r,c.c-1));
                }
            }

            //if new infections occured, increase time
            if (isInfected) ++time;
        }

        //if any uninfected patient present, store -1 in time
        for (int i = 0; i < R; ++i)
        {
            for (int j = 0; j < C; ++j)
            {
                if (hospital[i][j] == 1)
                {
                    time = -1;
                    break;
                }
            }
        }
        
        return time;
    }
}