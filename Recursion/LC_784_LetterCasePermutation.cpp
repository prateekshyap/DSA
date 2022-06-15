/*
https://leetcode.com/problems/letter-case-permutation/
784. Letter Case Permutation

*/
class Solution {
public:
    vector<string> ans;
    
    vector<string> letterCasePermutation(string s) {
        
        backtrackHelper(s, "", 0);
        
        return ans;    
    }//end
    
    void backtrackHelper(string &input, string subset, int idx)
    {
        if(idx == input.size())
        {
            ans.push_back(subset);
            return;
        }
        
        if(isalpha(input[idx]))
        {
            
           backtrackHelper(input, subset += tolower(input[idx]), idx+1);
            subset.pop_back();
           backtrackHelper(input, subset += toupper(input[idx]), idx+1);
        }
        else
            backtrackHelper(input, subset + input[idx], idx+1);
        
    }
};