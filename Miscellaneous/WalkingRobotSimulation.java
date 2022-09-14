/*https://leetcode.com/problems/walking-robot-simulation/*/

class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        int x = 0, y = 0, dir = 0;
        HashSet<String> obstacleSet = new HashSet<String>();
        for (int[] obstacle : obstacles)
        {
            StringBuilder build = new StringBuilder("");
            build.append(obstacle[0]);
            build.append(" ");
            build.append(obstacle[1]);
            obstacleSet.add(build.toString());
        }
        int dist = 0;
        for (int command : commands)
        {
            if (command == -1)
            {
                dir = (dir+1)%4;
            }
            else if (command == -2)
            {
                --dir;
                if (dir < 0) dir = 3;
            }
            else
            {
                int newX = x, destX = x;
                int newY = y, destY = y;
                StringBuilder coord = new StringBuilder("");
                for (int i = 1; i <= command; ++i)
                {
                    if (dir == 0)
                        ++newY;
                    else if (dir == 1)
                        ++newX;
                    else if (dir == 2)
                        --newY;
                    else if (dir == 3)
                        --newX;
                    coord = new StringBuilder("");
                    coord.append(newX);
                    coord.append(" ");
                    coord.append(newY);
                    if (obstacleSet.contains(coord.toString())) break;
                    else
                    {
                        destX = newX;
                        destY = newY;
                    }
                }
                x = destX;
                y = destY;
            }
            dist = Math.max(dist,(int)(Math.pow(x,2)+Math.pow(y,2)));
        }
        return dist;
    }
}

class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        int x = 0, y = 0, dir = 0;
        HashSet<Long> obstacleSet = new HashSet<Long>();
        for (int[] obstacle : obstacles)
        {
            obstacleSet.add((long)obstacle[0]*50001+(long)obstacle[1]);
        }
        int dist = 0;
        for (int command : commands)
        {
            if (command == -1)
            {
                dir = (dir+1)%4;
            }
            else if (command == -2)
            {
                --dir;
                if (dir < 0) dir = 3;
            }
            else
            {
                int newX = x, destX = x;
                int newY = y, destY = y;
                long coord = 0;
                for (int i = 1; i <= command; ++i)
                {
                    if (dir == 0)
                        ++newY;
                    else if (dir == 1)
                        ++newX;
                    else if (dir == 2)
                        --newY;
                    else if (dir == 3)
                        --newX;
                    coord = (long)newX*50001+(long)newY;
                    if (obstacleSet.contains(coord)) break;
                    else
                    {
                        destX = newX;
                        destY = newY;
                    }
                }
                x = destX;
                y = destY;
            }
            dist = Math.max(dist,(int)(Math.pow(x,2)+Math.pow(y,2)));
        }
        return dist;
    }
}