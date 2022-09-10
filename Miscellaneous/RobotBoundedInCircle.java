/*https://leetcode.com/problems/robot-bounded-in-circle/*/

class Solution {
    public boolean isRobotBounded(String instructions) {
        int dir = 0, x = 0, y = 0;
        for (char ch : instructions.toCharArray())
        {
            if (ch == 'G')
            {
                if (dir == 0) ++y;
                else if (dir == 1) ++x;
                else if (dir == 2) --y;
                else --x;
            }
            else if (ch == 'L')
            {
                --dir;
                if (dir < 0) dir = 3;
            }
            else dir = (dir+1)%4;
        }
        return (x == 0 && y == 0) || dir != 0;
    }
}