/*https://practice.geeksforgeeks.org/problems/find-the-distance-between-two-nodes4402/1*/

class Solution
{
    static int distance(int X,int Y)
    {
        // code here
        int result = 0;
        while (X != Y)
        {
            if (X > Y) X /= 2;
            else Y /= 2;
            ++result;
        }
        return result;
    }
}