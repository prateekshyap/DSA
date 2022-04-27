/*https://leetcode.com/problems/spiral-matrix-iii/*/

class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] result = new int[rows*cols][2];
        int[][] a = new int[rows][cols];
        
        int i = rStart, j = cStart, len = 2, index = 0, loop = 0;
        //store the first index
        result[index][0] = rStart;
        result[index][1] = cStart;
        ++index;
        boolean resultB = true;
        
        //till we have more elements
        while (index < rows*cols)
        {
            ++j; //move right by one step
            for (loop = 0; loop < len; ++loop) //keep moving for len length
            {
                if (i >= 0 && i < rows && j >= 0 && j < cols) //if the element exists
                {
                    //store it
                    result[index][0] = i;
                    result[index][1] = j;
                    ++index;
                    if (index == rows*cols){resultB = false; break;} //break if no more elements are present
                }
                ++i; //move down
            }
            if (!resultB) break;
            --i; //move up by one step
            --j; //move left by one step
            for (loop = 0; loop < len; ++loop) //keep moving for len length
            {
                if (i >= 0 && i < rows && j >= 0 && j < cols) //if the element exists
                {
                    //store it
                    result[index][0] = i;
                    result[index][1] = j;
                    ++index;
                    if (index == rows*cols){resultB = false; break;} //break if no more elements are present
                }
                --j; //move left
            }
            if (!resultB) break;
            ++j; //move right by one step
            --i; //move up by one step
            for (loop = 0; loop < len; ++loop) //keep moving for len length
            {
                if (i >= 0 && i < rows && j >= 0 && j < cols) //if the element exists
                {
                    result[index][0] = i;
                    result[index][1] = j;
                    ++index;
                    if (index == rows*cols){resultB = false; break;} //break if no more elements are present
                }
                --i; //move up
            }
            if (!resultB) break;
            ++i; //move down by one step
            ++j; //move right by one step
            for (loop = 0; loop < len; ++loop) //keep moving for len length
            {
                if (i >= 0 && i < rows && j >= 0 && j < cols) //if the element exists
                {
                    result[index][0] = i;
                    result[index][1] = j;
                    ++index;
                    if (index == rows*cols){resultB = false; break;} //break if no more elements are present
                }
                ++j; //move right
            }
            --j; //move left by one step
            len += 2; //increase len by 2
            if (!resultB) break;
        }
        return result;
    }
}