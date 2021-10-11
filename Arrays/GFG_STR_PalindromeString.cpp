
/* 
 https://practice.geeksforgeeks.org/problems/palindrome-string0817/1
*/

 
#include <bits/stdc++.h>
using namespace std;


 // } Driver Code Ends
//User function template for C++
class Solution{
public:	
	
	
	int isPlaindrome(string S)
	{
	    unsigned int sl = S.length()-1; //string lenght-1
	    unsigned int n=sl;
	    int i=0;
	    //using for loop
	    for( ; i<(sl+1)/2 ; i++){   // sl=3, 012, i<2(0,1) sl=4 0123, i<2(0,1)
	        if(S[i] != S[n-i])
	            return 0;
	    }
	    
	   // //using while loop
	   // while(i<n){ //start<end
    //         if(S[i++]!=S[n--]) return 0;    
	   // }
	   
	   return 1;
	   
	   ////using reverse function
	   //string s=S;
	   //reverse(s.begin(),s.end());
	   //if(s==S)
	   // return 1;
	   //else
	   // return 0;
	    
	    
	}

};

// { Driver Code Starts.

int main() 
{
   	ios_base::sync_with_stdio(0);
    cin.tie(NULL);
    cout.tie(NULL);
   
   	int t;
   	cin >> t;
   	while(t--)
   	{
   		string s;
   		cin >> s;

   	    Solution ob;

   		cout << ob.isPlaindrome(s) << "\n";
   	}

    return 0;
}  // } Driver Code Ends
