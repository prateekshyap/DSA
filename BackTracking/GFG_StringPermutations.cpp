/*
https://practice.geeksforgeeks.org/problems/permutations-of-a-given-string-1587115620/1#
String Permutations
https://leetcode.com/problems/permutations/ 
46. Permutations

*/

// { Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

 // } Driver Code Ends
class Solution{
    public:
    //Complete this function
    vector<string> ans;
    int high_ind = 0;
    
    vector<string> permutation(string S)
    {
        high_ind=S.length()-1;
        
        permute(0, S);
        
        sort(ans.begin(),ans.end());
        
        return ans;
    }
    
    void permute(int ind, string& s)
    {
        if(ind==high_ind) 
        {
            ans.push_back(s);
            return ;
        }
        
        for(int i=ind; i<=high_ind; i++)
        {
            swap(s[i],s[ind]);
            permute(ind+1, s);
            swap(s[i], s[ind]);
        }
    }
};

// { Driver Code Starts.

int main()
{
	int T;
	cin>>T;
	while(T--)
	{
		string S;
		cin>>S;
		Solution ob;
		vector<string> vec = ob.permutation(S);
		for(string s : vec){
		    cout<<s<<" ";
		}
		cout<<endl;
	
	}
	return 0;
}  // } Driver Code Ends


//LC
class Solution {
public:
    vector<vector<int>> ans;
    int high_ind;
    
    vector<vector<int>> permute(vector<int>& nums) {
        
        high_ind = nums.size()-1;
        
        find(0, nums);
        
        return ans;    
    }// end
    
    void find(int ind, vector<int>& nums)
    {
        if(ind==high_ind)
        {
            ans.push_back(nums);
            return;
        }
        
        for(int i=ind; i<=high_ind; i++)
        {
            swap(nums[i],nums[ind]);
            find(ind+1, nums);
            swap(nums[i],nums[ind]);
        }
    }
    
};