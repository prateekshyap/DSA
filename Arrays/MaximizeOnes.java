/*https://practice.geeksforgeeks.org/problems/maximize-number-of-1s0905/1*/

class Solve {
    int findZeroes(int arr[], int n, int m) {
        int max = 0, flipCounter = 0;
        int start = 0, end = -1;

        //run till the penultimate index
        while (end < n-1)
        {
        	//if the next index of the current window is 1, increase the window size
            if (arr[end+1] == 1)
                ++end;
            else
            {
            	//if increasing the flip count stays within the limit
                if (flipCounter+1 <= m)
                {
                	//increase flip count and window size
                    ++end;
                    ++flipCounter;
                }
                else
                {
                	//reach the least recent zero
                    while (arr[start] == 1)
                        ++start;
                    //decrease flip count
                    --flipCounter;
                    //decrease window size
                    ++start;
                }
            }

            //keep updating the max window size
            max = Math.max(max,end-start+1);
        }
        return max;
    }
}