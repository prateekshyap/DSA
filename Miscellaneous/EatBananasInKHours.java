/*Eat Bananas in K Hours

Medium

You are given a list of integers piles and an integer k. piles[i] represents the number of bananas on pile i. On each hour, you can choose any pile and eat r number of bananas in that pile. If you pick a pile with fewer than r bananas, it still takes an hour to eat the pile.

Return the minimum r required such that you can eat all the bananas in less than or equal to k hours.

Constraints

    n ≤ 100,000 where n is the length of piles
    n ≤ k

Example 1
Input

piles = [6, 4, 3]

k = 5

Output

3

Explanation

At r = 3 bananas per hour, we can eat the first pile in 2 hours, eat the second in 2 hours, and eat the last pile in 1 hour.
*/

/*https://practice.geeksforgeeks.org/problems/binary-search/1*/

import java.util.*;

class Solution {
    int[] isPossibleArr;
    public int solve(int[] piles, int k)
    {
        int maxPileSize = 0;

        //finding the maximum pile size, that is the maximum r possible
        for (int i = 0; i < piles.length; ++i)
            if (piles[i] > maxPileSize)
                maxPileSize = piles[i];
        
        //a table to store which r values can be considered
        isPossibleArr = new int[maxPileSize+2];

        //set low, high and mid
        int low = 1, high = maxPileSize, mid;

        //two boolean variables to keep track of r and r+1 whether they can be considered or not
        boolean midPossible = false, nextPossible = false;
        
        //simple binary search
        while (low <= high)
        {
            mid = low+(high-low)/2; //get mid
            midPossible = isPossibleArr[mid] == 0 ? isPossible(piles,k,mid) : (isPossibleArr[mid] == 1 ? true : false); //check mid is considerable or not
            nextPossible = isPossibleArr[mid+1] == 0 ? isPossible(piles,k,mid+1) : (isPossibleArr[mid+1] == 1 ? true : false); //check mid+1 is considerable or not
            if (!midPossible && nextPossible) //if mid is not considerable but mid+1 is
                return mid+1; //return mid+1
            else if (midPossible && nextPossible && mid == 1)
                return 1; //return the edge case
            else if (midPossible && nextPossible) //move left if current value is considerable
                high = mid-1;
            else //move right is current value is not considerable
                low = mid+1;
        }
        return -1;
    }
    public boolean isPossible(int[] piles, int k, int r)
    {
        int total = 0;
        for (int i = 0; i < piles.length; ++i)
        {
            if (piles[i]%r == 0) total += piles[i]/r;
            else total += (piles[i]/r)+1;
        }
        isPossibleArr[r] = total <= k ? 1 : 2;
        return isPossibleArr[r] == 1 ? true : false;
    }
}