/*https://practice.geeksforgeeks.org/problems/max-circular-subarray-sum-1587115620/1*/

class Solution{

    // a: input array
    // n: size of array
    //Function to find maximum circular subarray sum.
    static int circularSubarraySum(int a[], int n){
        
         // Corner Case
	    if (n == 1) return a[0];
	 
	    // Initialize sum variable which store total sum of
	    // the array.
	    int sum = 0;
	    for (int i = 0; i < n; i++)
	    	sum += a[i];
	 
	    // Initialize every variable with first value of
	    // array.
	    int currMax = a[0], maxSoFar = a[0],
	    currMin = a[0], minSoFar = a[0];
	 
	    // Concept of Kadane's Algorithm
	    for (int i = 1; i < n; i++)
	    {
	 
	      // Kadane's Algorithm to find Maximum subarray
	      // sum.
			currMax = Math.max(currMax + a[i], a[i]);
			maxSoFar = Math.max(maxSoFar, currMax);

			// Kadane's Algorithm to find Minimum subarray
			// sum.
			currMin = Math.min(currMin + a[i], a[i]);
			minSoFar = Math.min(minSoFar, currMin);
	    }
	    if (minSoFar == sum) return maxSoFar;
	 
	    // returning the maximum value
	    return Math.max(maxSoFar, sum - minSoFar);
    }   
}