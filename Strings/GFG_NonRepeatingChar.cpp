
/*
https://practice.geeksforgeeks.org/problems/non-repeating-character-1587115620/1/#

Non-Repeating Character

https://leetcode.com/problems/first-unique-character-in-a-string/
387. First Unique Character in a String

*/

/***************** LEETCODE **************************/
class Solution {
public:
    int firstUniqChar(string s) {
        
        vector<int> hash(26,-1);
        
        for(int i=0; i<s.size(); i++)
        {
            int ind = s[i]-'a';
            if(hash[ind] == -1)
                hash[ind] = i;
            else
                hash[ind] = -2;
            
        }
        
        int res = INT_MAX;
        for(int i=0; i<hash.size(); i++)
        {
           if(hash[i]>=0)
           {
               res = min(res, hash[i]);
           }
        }
        
        if(res != INT_MAX) return res;
        return -1;
    }//end
};


/***************** GFG **************************/
// { Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


 // } Driver Code Ends


class Solution
{
    public:
    //Function to find the first non-repeating character in a string.
    char nonrepeatingCharacter(string S)
    {
       //Your code here
       vector<int> hash(26,-1);

       
       for(int i=0; i<S.size(); i++)
       {
           int ind = S[i]-'a';
           if(hash[ind] == -1) // first time occurance
             hash[ind] = i;
           else
             hash[ind] = -2; //more than once
       }
       
       int res = INT_MAX;
       for(int i=0; i<hash.size(); i++)
       {
           if(hash[i]>=0)
            res = min(res, hash[i]);
       }
       if(res != INT_MAX) return (S[res]);
       return '$';
    }//end

};

// { Driver Code Starts.

int main() {
	
	int T;
	cin >> T;
	
	while(T--)
	{
	
	    string S;
	    cin >> S;
	    Solution obj;
        char ans = obj.nonrepeatingCharacter(S);
        
        if(ans != '$')
	    cout << ans;
        else cout << "-1";
            
        cout << endl;
	    
	}
	
	return 0;
}
  // } Driver Code Ends