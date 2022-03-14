/*
https://leetcode.com/problems/longest-substring-without-repeating-characters/
3. Longest Substring Without Repeating Characters

*/

//GFG
// { Driver Code Starts
#include<bits/stdc++.h>
using namespace std;


 // } Driver Code Ends
class Solution{
    public:
    int longestUniqueSubsttr(string S){
        //code
        
    int n = S.length();
    
    int maxSoFar=0;
    int left = 0;
    vector<int> seen(26);
    
    for(int right=0; right<n; right++)
    {
        seen[S[right]-'a']++;
        
        while(seen[S[right]-'a']>1)
        {
            seen[S[left]-'a']--;
            left++;
        }
        maxSoFar = max(maxSoFar, right-left+1);
    }
    
    return maxSoFar;
    }//end
};

// { Driver Code Starts.
int main()
{
    int t;
    cin>>t;
    while(t--)
    {
        string str;
        cin>>str;
        Solution ob;
        cout<<ob.longestUniqueSubsttr(str)<<endl;
    }
    return 0;
}  // } Driver Code Ends


//LEECTODE
class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        
        int n = s.length();
        
        if(n==1) return 1; // String with one character is always unique, return 1
        
        int max_so_far =0;
        
       
        /***** NAIVE APPROACH - Iterating all substrings ****/
        
//         for(int start=0; start<n; start++)
//         {
//           for(int end=start; end<n; end++)
//           {
//               vector<bool> visited(256,false);
//               bool isUniqueSubstring = true;
//               //check if the substring contains all unique characters
//               for(int k=start;k<=end;k++)
//               {
//                   if(visited[s[k]] == true) 
//                   {
//                       isUniqueSubstring = false;
//                        break;
//                   }
//                   visited[s[k]] = true;
//               }
              
//               if(isUniqueSubstring)
//               {
//                   max_so_far = max(max_so_far, end-start+1);
//               }
//           }
//         }
        
        
//         // vector<bool> visited(256,false);
//         bitset<256> visited;
//         visited.reset();
//         int start=0;
//         for(int end=0; end<n; end++)
//         {
//             if(visited[s[end]] == false)
//             {
//                 // visited[s[end]]=true;
//                 visited.set(s[end]);
//                 max_so_far = max(max_so_far, end-start+1);
//             }
//             else
//             {
//                 // visited[s[start]]=false;
//                 visited.reset(s[start]);
//                 start++;
//                 end--;
                
//             }
//         }
        
//         return max_so_far;
        
        /*** Sliding window ****/
        
        unordered_map<char,int> seen_freq;
        int start=0;
        
        for(int e=0; e<n; e++)
        {
           seen_freq[s[e]]++;  // increase the seen freq of character
            
            while(seen_freq[s[e]] > 1) // end char found is duplcate
            {
                seen_freq[s[start]]--; // from start decrease the freq of all till we find the duplicate character
                start++;
            }
            
            max_so_far = max(max_so_far, e-start+1);
        }
        
       
        
        return max_so_far;
    }//end
};