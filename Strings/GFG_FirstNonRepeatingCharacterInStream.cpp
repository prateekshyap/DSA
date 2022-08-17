/*
https://practice.geeksforgeeks.org/problems/first-non-repeating-character-in-a-stream1216/1
First non-repeating character in a stream 
*/

// { Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

 // } Driver Code Ends
class Solution {
	public:
		string FirstNonRepeating(string A){
		   int order[26] = {0};
		   queue<char> q;
		   
		   for(int i=0; i<A.size(); i++)
		   {
		       int ind = A[i]-'a';
		       order[ind]++;
		       if(order[ind] == 1)
		            q.push(A[i]);
		        
		       while(!q.empty() && order[q.front()-'a'] != 1)
		            q.pop();
		       
		       if(q.empty())
		          A[i] = '#';
		       else
		         A[i]  = q.front();
		   }
		   
		   return A;
		}

};

// { Driver Code Starts.
int main(){
	int tc;
	cin >> tc;
	while(tc--){
		string A;
		cin >> A;
		Solution obj;
		string ans = obj.FirstNonRepeating(A);
		cout << ans << "\n";
	}
	return 0;
}  // } Driver Code Ends