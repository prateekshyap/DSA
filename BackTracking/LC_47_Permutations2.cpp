/*
https://leetcode.com/problems/permutations-ii/
47. Permutations II

*/
class Solution {
public:
    
    vector<vector<int>> ans;
    int high_ind;
    set<vector<int>> s;
    
    
    vector<vector<int>> permuteUnique(vector<int>& nums) {
        high_ind = nums.size()-1;
        
        findPermute(0, nums);
        
        return ans;    
    }// end
    
    void findPermute(int ind, vector<int>& nums)
    {
        if(ind==high_ind)
        {
            // if(find(ans.begin(),ans.end(),nums)==ans.end()){
            //     ans.push_back(nums);
            // } // 250ms+
            if(s.find(nums)==s.end())
            {   s.insert(nums);
                ans.push_back(nums);
            }//19ms+
                // ans.push_back(nums);
            return;
        }
        bool flag=true;
        for(int i=ind; i<=high_ind; i++)
        {
            if(ind !=i && nums[ind]==nums[i]) continue;
                
            swap(nums[i],nums[ind]);
            findPermute(ind+1, nums);
            swap(nums[i],nums[ind]);
        }
    }
    
    vector<vector<int>> permuteUnique1(vector<int>& nums) 
    {
        sort(nums.begin(), nums.end());
        
        vector<vector<int>>ans;
        
        ans.push_back(nums);
        
        while(next_permutation(nums.begin(), nums.end())){
            ans.push_back(nums);
        }
        
        return ans;
    }
};