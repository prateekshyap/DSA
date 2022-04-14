/*https://practice.geeksforgeeks.org/problems/geekss-garden/0*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Position implements Comparable<Position>
{
    int r, c;
    Position(int r, int c)
    {
        this.r = r;
        this.c = c;
    }
    @Override
    public int compareTo(Position p)
    {
        return 0;
    }
}


class GFG
{
public static void main (String[] args) throws IOException
{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int cases = Integer.parseInt(br.readLine());
    String[] tokens;
    String token;
    int n, m, i, j;
    char[][] rosarium;
    Queue<Position> queue;
    boolean[][] visited;
    int currCount, maxCount;
    Position p;
    for (int ii = 0; ii < cases; ++ii)
    {
    	tokens = br.readLine().trim().split(" +");
        n = Integer.parseInt(tokens[0]);
        m = Integer.parseInt(tokens[1]);
        rosarium = new char[n][m];
        visited = new boolean[n][m];
        for (i = 0; i < n; ++i)
        {
            token = br.readLine();
            for (j = 0; j < m; ++j)
                rosarium[i][j] = token.charAt(j);
        }
        maxCount = 0; currCount = 0;
        queue = new LinkedList<Position>();
        for (i = 0; i < n; ++i)
        {
            for (j = 0; j < m; ++j)
            {
                if (!visited[i][j] && rosarium[i][j] == '1')
                {
                    queue.add(new Position(i,j));
                    currCount = 0;
                    while (!queue.isEmpty())
                    {
                        p = queue.poll();
                        if (visited[p.r][p.c]) continue;
                        visited[p.r][p.c] = true;
                        ++currCount;
                        if (p.r+1 < n && !visited[p.r+1][p.c] && rosarium[p.r+1][p.c] == '1')
                            queue.add(new Position(p.r+1,p.c));
                        if (p.r-1 >= 0 && !visited[p.r-1][p.c] && rosarium[p.r-1][p.c] == '1')
                            queue.add(new Position(p.r-1,p.c));
                        if (p.r+1 < n && p.c+1 < m && !visited[p.r+1][p.c+1] && rosarium[p.r+1][p.c+1] == '1')
                            queue.add(new Position(p.r+1,p.c+1));
                        if (p.r-1 >= 0 && p.c+1 < m && !visited[p.r-1][p.c+1] && rosarium[p.r-1][p.c+1] == '1')
                            queue.add(new Position(p.r-1,p.c+1));
                        if (p.r+1 < n && p.c-1 >= 0 && !visited[p.r+1][p.c-1] && rosarium[p.r+1][p.c-1] == '1')
                            queue.add(new Position(p.r+1,p.c-1));
                        if (p.r-1 >= 0 && p.c-1 >= 0 && !visited[p.r-1][p.c-1] && rosarium[p.r-1][p.c-1] == '1')
                            queue.add(new Position(p.r-1,p.c-1));
                        if (p.c+1 < m && !visited[p.r][p.c+1] && rosarium[p.r][p.c+1] == '1')
                            queue.add(new Position(p.r,p.c+1));
                        if (p.c-1 >= 0 && !visited[p.r][p.c-1] && rosarium[p.r][p.c-1] == '1')
                            queue.add(new Position(p.r,p.c-1));
                    }
                    if (currCount > maxCount) maxCount = currCount;
                }
            }
        }
        if (currCount > maxCount) maxCount = currCount;
        System.out.println(maxCount);
    }
}
}