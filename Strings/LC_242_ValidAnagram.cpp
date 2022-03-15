/*
https://leetcode.com/problems/valid-anagram/
https://www.geeksforgeeks.org/check-whether-two-strings-are-anagram-of-each-other/

*/

class Solution {
public:
    bool isAnagram(string s, string t) {
        
        if(s.size() != t.size()) return false;  // if both length are not same
        
        vector<int> hash(26,0);
        
        for(int i=0; i<s.length(); i++)
        {
            //add freq for s string character
            hash[s.at(i)-'a']++;
            
            //subtract freq for t string character
            hash[t.at(i)-'a']--;
        }
        
        
        for(auto it: hash)
        {
            if(it != 0) return false;
        }
        
        return true;
    }
};