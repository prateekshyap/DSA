/*
https://leetcode.com/problems/guess-number-higher-or-lower/
374. Guess Number Higher or Lower

*/
/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

class Solution {
public:
    int guessNumber(int n) {
        
        int low=1, high = n, mid;
        
        while(low<=high)
        {
            mid = low + ((high-low)>>1);
            // switch(guess(mid))
            // {
            //     case -1:
            //         high = mid-1;
            //         break;
            //     case 1:
            //         low = mid+1;
            //         break;
            //     case 0:
            //         return mid;
            //         break;
            // }
            int pick = guess(mid);
            if(pick == 0)
                return mid;
            else if(pick == 1)
                low = mid+1;
            else
                high = mid-1;
        }
        return -1;
        
    }//end
};