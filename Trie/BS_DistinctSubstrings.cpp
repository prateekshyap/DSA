/*
https://practice.geeksforgeeks.org/problems/count-of-distinct-substrings/1
https://binarysearch.com/problems/Distinct-Substrings
*/

// GFG ---------------------------------------------------
// { Driver Code Starts
#include<bits/stdc++.h>

using namespace std;

int countDistinctSubstring(string s);

int main()
{
 int t,l,i,j;
 int temp;
    cin>>t;
 while(t--){
 string s;
  cin>>s;
  cout<<countDistinctSubstring(s)<<endl;

 }
}

// } Driver Code Ends


class TrieNode{
    public:
  TrieNode* child[26] = {nullptr};
  bool isEnd = false;
};

/*You are required to complete this method */
int countDistinctSubstring(string s)
{
    TrieNode *root = new TrieNode;
    int indx=0;
    int ans=1; // for null
    for(int i=0; i<s.length(); i++)
    {
        TrieNode *curr = root;
        for(int j=i; j<s.length(); j++)
        {
            indx = s[j]-'a';
            if(curr->child[indx] == nullptr)
                curr->child[indx] = new TrieNode;
            curr = curr->child[indx];
            
            if(curr->isEnd == false)
            {
                ans++;
                curr->isEnd = true;
            }
        }
    }
    return ans;
   
    /* TLE in 4th Test Case
     unordered_set<string> ans;
    for(int i=0; i<s.length(); i++)
    {
        for(int j=i; j<s.length(); j++)
            ans.insert(s.substr(i,j-i+1));
    }

    return ans.size()+1;
    */
    /* TLE in 20th test case
    unordered_set<unsigned long> ans;
    for(int i=0; i<s.length(); i++)
    {
        unsigned long hash = 5381;
        for(int j=i; j<s.length(); j++)
            {
                hash = ((hash<<5) + hash) + s[j] - 'a';
                ans.insert(hash);
            }
    }

    return ans.size()+1;
    */
}



// Binary Search ------------------------------------------------
int solve_1(string s) {
    
    unordered_set<string> ans;
    for(int i=0; i<s.length(); i++)
    {
        for(int j=i; j<s.length(); j++)
            ans.insert(s.substr(i,j-i+1));
    }

    return ans.size();
}

int solve_2(string s) {
    
    unordered_set<unsigned long> ans;
    for(int i=0; i<s.length(); i++)
    {
        unsigned long hash = 5381;
        for(int j=i; j<s.length(); j++)
            {
                hash = ((hash<<5) + hash) + s[j] - 'a';
                ans.insert(hash);
            }
    }

    return ans.size();
}

class TrieNode{
    public:
        TrieNode* child[26] = {nullptr};
        bool isEnd = false;
};

int solve(string s) {
    
    TrieNode* root = new TrieNode;
    int ans=0, indx=0;

    for(int i=0; i<s.size(); i++)
    {
        TrieNode* curr = root;
        for(int j=i; j<s.size(); j++)
        {
            indx = s[j]-'a';
            if(curr->child[indx] == nullptr)
                curr->child[indx] = new TrieNode;
            curr= curr->child[indx];
            if(curr->isEnd == false)
            {   
                ans++;
                curr->isEnd = true;
            }
        }
    }

    return ans;
}