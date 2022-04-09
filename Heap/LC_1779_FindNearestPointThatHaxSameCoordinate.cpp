/*
https://leetcode.com/problems/find-nearest-point-that-has-the-same-x-or-y-coordinate/
1779. Find Nearest Point That Has the Same X or Y Coordinate

*/
class Solution {
public:
    int nearestValidPoint(int x, int y, vector<vector<int>>& points) {
        
        int X,Y, dis=0;
        int min_dis = INT_MAX;
        int ans_index = -1;
        
        for(int i=0; i<points.size(); i++)
        {
            X = points[i][0]; 
            Y = points[i][1];
            
            // if valid point
            if(x == X || y == Y)
            {
               dis = abs(x-X)+abs(y-Y);
               if(dis < min_dis )
               {
                   ans_index = i;
                   min_dis = dis;
               }
                else if(dis == min_dis)
                {
                    if(X < points[ans_index][0] && Y < points[ans_index][1])
                    {
                        ans_index = i;
                        min_dis = dis;
                    }
                }
            }
        }
        
        return ans_index;
    }//end
};