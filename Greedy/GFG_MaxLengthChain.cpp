/*
https://practice.geeksforgeeks.org/problems/max-length-chain/1
Max length chain 
*/

// { Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

struct val{
	int first;
	int second;
};



int maxChainLen(struct val p[],int n);
int main() {
	// your code goes here
	int t;
	cin>>t;
	while(t--)
	{
		int n;
		cin>>n;
		val p[n];
		for(int i=0;i<n;i++)
		{
			cin>>p[i].first>>p[i].second;
		}
		
		cout<<maxChainLen(p,n)<<endl;
	}
	return 0;
}// } Driver Code Ends


/*
The structure to use is as follows
struct val{
	int first;
	int second;
};*/
bool compare(const val &a, const val &b)
{
    if(a.second == b.second) return a.first < b.first;
      return a.second < b.second;  
}
/*You are required to complete this method*/
int maxChainLen1(struct val p[],int n)
{
    // auto compare1 = [](const val &a, const val &b){
    //   return a.first < b.first;  
    // };
    
    sort(p, p+n, compare);
    
    vector<struct val> chains;
    
    chains.push_back(p[0]);
    
    for(int i=1; i<n; i++)
    {
        if(chains.back().second <  p[i].first )
        {
            chains.push_back(p[i]);
        }
    }
    
    return chains.size();
}

int maxChainLen(struct val p[],int n)
{
    auto compare1 = [](const val &a, const val &b){
      return a.first < b.first;  
    };
    
    sort(p, p+n, compare1);
    
    vector<int> dp(n, 1);
    int max=0;
    
    for(int i=1; i<n; i++)
    {
        for(int j=0; j<i; j++)
        {
            if(p[j].second < p[i].first && dp[j]+1 > dp[i])
            {    dp[i] = dp[j]+1;
                if(dp[i]>max) max = dp[i];
            }
        }
    }
    for(int i=0; i<n; i++)
    {
        cout<<p[i].first<<" "<<p[i].second<<endl;
    }
    for(int i=0; i<n; i++)
    {
        cout<<"i="<<i<<" "<<dp[i]<<endl;
    }
    
    return max;
}