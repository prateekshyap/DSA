/*
https://practice.geeksforgeeks.org/problems/stock-span-problem-1587115621/1#
Stock span problem

*/
// { Driver Code Starts
#include<bits/stdc++.h>
using namespace std;


 // } Driver Code Ends


class Solution
{
    public:
    //Function to calculate the span of stockâ€™s price for all n days.
    
    vector <int> calculateSpan(int price[], int n)
    {
       // Your code here
       stack<int> st; // to store index price
       vector<int> ans(n,0);
       
       ans[0] = 1; // span of first element is 1
       st.push(0); //push first element into stack
       
       for(int i = 1; i<n; i++)
        {
            // while(!st.empty() && price[st.top()] <= price[i])
            // {   
            //     ans[i] = ans[i] + ans[st.top()];
            //     st.pop();
            // }
                
            // st.push(i); 
            
            // ans[i] = ans[i] + 1;
            
            while(!st.empty() && price[st.top()] <= price[i])
                st.pop();
            
            ans[i] = (st.empty()) ? i+1 : i - st.top();
            // i+1 when current price is greater than all 
            // and i - st.top() is span when it is greater than midway some price
            
            st.push(i);
            
        }
    
        return ans;
    }//end 
    
    
    // vector <int> calculateSpan(int price[], int n)
    // {
    //   // Your code here
    //   vector<int> ans(n,0);
       
    //   ans[0] = 1;
       
    //   for(int i = 1; i<n; i++)
    //     {
    //         ans[i] = 1;
            
    //         for(int j=i-1; j>=0 && (price[j] <= price[i]) ; j--)
    //                 ans[i]++;
                
    //     }
    
    //     return ans;
    // }//end 
    
};



// { Driver Code Starts.

int main()
{
	int t;
	cin>>t;
	while(t--)
	{
		int n;
		cin>>n;
		int i,a[n];
		for(i=0;i<n;i++)
		{
			cin>>a[i];
		}
		Solution obj;
		vector <int> s = obj.calculateSpan(a, n);
		
		for(i=0;i<n;i++)
		{
			cout<<s[i]<<" ";
		}
		cout<<endl;
	}
	return 0;
}
  // } Driver Code Ends