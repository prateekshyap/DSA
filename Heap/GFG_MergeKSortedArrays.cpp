/*
https://practice.geeksforgeeks.org/problems/merge-k-sorted-arrays/1#
Merge k Sorted Arrays 
*/
// { Driver Code Starts
//Initial Template for C++

#include<bits/stdc++.h>
#define N 105
using namespace std;
void printArray(vector<int> arr, int size)
{
for (int i=0; i < size; i++)
	cout << arr[i] << " ";
}


 // } Driver Code Ends
//User function Template for C++


class Solution
{
    public:
    //Function to merge k sorted arrays.
    
     vector<int> mergeKArrays(vector<vector<int>> arr, int K)
    {
        vector<int> ans;
        priority_queue<pair<int,pair<int,int>>, vector<pair<int,pair<int,int>>>, greater<pair<int,pair<int,int>>>> pq;
        
        for(int i=0; i<K; i++)
        {
            // pushing all first min element
            pq.push({arr[i][0], {i,0}});
        }
        
        while(!pq.empty())
        {
            int ele = pq.top().first;
            int i = pq.top().second.first;
            int j = pq.top().second.second;
            
            pq.pop();
            
            if(j== K-1) // last column
            {
                ans.push_back(ele);
                continue;
            }
            else
            {
                ans.push_back(ele);
                j++;
                pq.push({arr[i][j], {i,j}});
            }
            
        }
        return ans;
    }// end
    
    //USING Min Heap and pushing all elements
    /*
    vector<int> mergeKArrays(vector<vector<int>> arr, int K)
    {
        vector<int> ans;
        priority_queue<int, vector<int>, greater<int>> pq;
        
        for(int i=0; i<K; i++)
        {
            for(int j=0; j<K; j++)
            {
                pq.emplace(arr[i][j]);
            }
        }
        
        while(!pq.empty())
        {
            ans.push_back(pq.top());
            pq.pop();
        }
        return ans;
    }// end
    */
    
    //USING SORT and Single ARRAY
    /*
    vector<int> mergeKArrays(vector<vector<int>> arr, int K)
    {
        vector<int> ans;
        for(int i=0; i<K; i++)
        {
            for(int j=0; j<K; j++)
            {
                ans.push_back(arr[i][j]);
            }
        }
        
        sort(begin(ans), end(ans));
        return ans;
    }// end
    */
};

// { Driver Code Starts.

int main()
{
	int t;
	cin>>t;
	while(t--){
	    int k;
	    cin>>k;
	    vector<vector<int>> arr(k, vector<int> (k, 0));
	    for(int i=0; i<k; i++){
	        for(int j=0; j<k; j++)
	        {
	            cin>>arr[i][j];
	        }
	    }
	    Solution obj;
    	vector<int> output = obj.mergeKArrays(arr, k);
    	printArray(output, k*k);
    	cout<<endl;
    }
	return 0;
}





  // } Driver Code Ends