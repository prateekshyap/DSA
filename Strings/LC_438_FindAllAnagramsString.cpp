/*
https://leetcode.com/problems/find-all-anagrams-in-a-string/
438. Find All Anagrams in a String

*/

class Solution {
public:
    vector<int> findAnagrams(string s, string p) {
        int sl = s.length();
        int pl = p.length();
    
        if(sl<=0 || pl<=0 || pl>sl) return {};
        
        vector<int> hash(26,0);
    
        for(char c: p)
        {
            ++hash[c-'a']; // store pattern char in hashtable
        }
        
        for(int i=0; i<pl; i++)
        {
            --hash[s[i]-'a'];
        }
        
        bool flag = true;
        vector<int> ans;
        //sliding window approach
        for(int i=0; i< sl-pl; i++)
        {
            
             flag = true;
            for(int k=0; k< hash.size(); k++)
            {
                if(hash[k] != 0)
                    flag =false;
            }
            if(flag)
                ans.push_back(i);
            
            //remove first character
            // add next character
            
            ++hash[s[i]-'a'];
            --hash[s[i+pl] - 'a'];
                
            
        }
         
        flag = true;
        for(int k=0; k< hash.size(); k++)
        {
            if(hash[k] != 0)
                flag =false;
        }
        if(flag)
            ans.push_back(sl-pl);
        
        return ans;
    }//end
};