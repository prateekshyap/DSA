/*
Minimum Swaps to Sort
https://practice.geeksforgeeks.org/problems/minimum-swaps/1
*/

class Solution 
{
    public:
    //Function to find the minimum number of swaps required to sort the array. 
	int minSwaps(vector<int>&nums)
	{
	    vector<pair<int,int>> x;
	    int n = nums.size();
	    for(int i=0; i<n; i++)
	        x.push_back({nums[i], i});
	        
	   sort(x.begin(), x.end());
	   //int swaps=0;
	   //for(int i=0; i<n; i++)
	   //{
	   //    int j=x[i].second;
	   //    //if(i==j)
	   //    // continue;
	   //    //else
	   //    int cyclesize=0;
	   //    while(i!=j)
	   //     {
	   //         cyclesize++;
	   //         swap(x[i], x[j]);
	   //         j = x[i].second;
	   //     }
	   //     if(cyclesize>0)
	   //         swaps += cyclesize;
	   //}
	   ////for(int i=0; i<n; i++) cout<<x[i].first<<" "<<x[i].second<<") ";
	   //return swaps;
	   
	   int swaps=0;
	   vector<bool> vis(n, 0);
	   for(int i=0; i<n; i++)
	   {
	       int j=x[i].second;
	       if(vis[i] || j == i) continue;
	       
	       int cyclesize=0;
	       j=i;
	       while(!vis[j])
	        {
	            cyclesize++;
	            vis[j]=true;
	            j = x[j].second;
	        } 
            swaps += cyclesize-1;
	   }
	   //for(int i=0; i<n; i++) cout<<x[i].first<<" "<<x[i].second<<") ";
	   return swaps;
	}
};