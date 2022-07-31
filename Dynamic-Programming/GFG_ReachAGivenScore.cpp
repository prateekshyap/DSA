/*
https://practice.geeksforgeeks.org/problems/reach-a-given-score-1587115621/1#
Reach a given score 
*/

// { Driver Code Starts
// Driver Code
#include<bits/stdc++.h>
#define ll long long int
using namespace std;

 // } Driver Code Ends
// Complete this function

long long int solve(int , long long int);

vector<int> combinations = {3,5,10};
vector<vector<long long int>> memo(4, vector<long long int>(1001, -1));

long long int count(long long int n)
{
	long long int table[n+1],i;
	memset(table, 0, sizeof(table));
	table[0]=1;                 // If 0 sum is required number of ways is 1.
	
	// Your code here
	for(int ci: combinations)
	{
	    for(int sum=ci; sum<=n; sum++)
	    {
	        table[sum] += table[sum-ci];
	    }
	}
	
	return table[n];

    // return solve(0, n);
}

long long int solve(int idx, long long int sum)
{
    if(sum == 0)
        return 1;
    
    if(sum < 0)
        return 0;
    
    if(memo[idx][sum] !=-1)
        return memo[idx][sum];
    
    long long int cnt = 0;
    for(int i=idx; i<3; i++)
    {
        cnt+= solve(i, sum-combinations[i]);
    }
    
    return memo[idx][sum] = cnt;
}

// { Driver Code Starts.



int main()
{
	int t;
	cin>>t;
	while(t--)
	{
		ll n;
		cin>>n;
		cout<<count(n)<<endl;
	}
	return 0;
}  // } Driver Code Ends