/*https://practice.geeksforgeeks.org/problems/perfect-sum-problem5633/1/*/

class Solution{
    Integer[][] countStore;
    private final int m = (int)1e9+7;
	public int perfectSum(int arr[],int n, int sum) 
	{ 
	    // Your code goes here
	    countStore = new Integer[n+1][sum+1];
	    countStore[0][0] = count(arr, n, 0, sum, 0);
	    return countStore[0][0];
	} 
	private int count(int[] a, int n, int index, int target, int currSum)
	{
	    if (index == n) return 0;
	    if (currSum > target) return 0;
	    if (countStore[index][currSum] != null) return countStore[index][currSum];
	    int result = 0;
	    
	    result = (result+count(a, n, index+1, target, currSum))%m;
	    if (currSum+a[index] < target) result = (result+count(a, n, index+1, target, currSum+a[index]))%m;
	    if (currSum+a[index] == target) result = (result+1+count(a, n, index+1, target, currSum+a[index]))%m;
	    countStore[index][currSum] = result;
	    return result;
	}
}