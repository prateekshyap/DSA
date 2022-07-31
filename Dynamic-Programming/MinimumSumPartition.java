/*https://practice.geeksforgeeks.org/problems/minimum-sum-partition3317/1/*/

class Solution
{
	public int minDifference(int arr[], int n) 
	{ 
	    // Your code goes here
	    int sum = 0, i, j;
	    for (i = 0; i < n; ++i) sum += arr[i];
	    boolean[][] table = new boolean[n][sum+1];
	    int diff = sum;
	    table[0][0] = true;
	    table[0][arr[0]] = true;
	    diff = Math.min(diff,Math.abs((sum-arr[0])-arr[0])); //store the minimum diffrence by including the first element
	    for (i = 1; i < n; ++i) //for next elements
	    {
	        for (j = 0; j <= sum; ++j) //for each sum value
	        {
	            if (table[i-1][j]) //if the previous element could produce jth sum value
	            {
	                table[i][j] = true; //current element can be excluded to produce the same sum, so mark as true
	                if (table[i][j+arr[i]]) continue; //current element can be included the produce a new sum, but if this sum value is already checked, continue
	                table[i][j+arr[i]] = true; //mark the new sum value as true
	                diff = Math.min(diff,Math.abs(j-(sum-j))); //find the minimum difference for including the new element
	            }
	        }
	    }
	    return diff;
	}
}