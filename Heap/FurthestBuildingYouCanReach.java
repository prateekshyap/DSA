/*https://leetcode.com/problems/furthest-building-you-can-reach/*/

class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int N = heights.length;
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(); //it will contain the highest gaps where we shall use all the ladders
        for (int i = 1; i < N; ++i) //for each next building
        {
            if (heights[i-1] < heights[i]) //if the previous building was smaller, we need either ladder or bricks
            {
                if (heap.size() == ladders) //if we have used all the ladders
                {
                    int brick = 0;
                    if (ladders == 0 || heap.peek() > heights[i]-heights[i-1]) //if no ladders are given or the heap's top is larger than the current gap
                        brick = heights[i]-heights[i-1]; //this is the minimum
                    else //otherwise
                    {
                        brick = heap.poll(); //heap's top is the minimum
                        heap.add(heights[i]-heights[i-1]); //add the current gap to the heap
                    }
                    if (brick > bricks) return i-1; //if required bricks are more than the available bricks we cannot move from i-1 further
                    bricks -= brick; //subtract the brick number of bricks
                }
                else heap.add(heights[i]-heights[i-1]); //add the difference to heap
            }
        }
        return N-1; //return the last bulilding if the loop was uninterrupted
    }
}