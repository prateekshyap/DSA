/*
https://leetcode.com/problems/permutation-in-string/
567. Permutation in String

*/

class Solution {
public:
    /*
    bool checkInclusion(string s1, string s2) {
//         sort(s1.begin(), s1.end());
//         do
//         {
//              if(s2.find(s1)!=string::npos)
//                 return true;
//         }while(next_permutation(s1.begin(), s1.end()));
       
//         return false;
        if(s2.size()< s1.size()) return false;
        
        vector<int> freq(26, 0);
        
        for(char c: s1)
            freq[c-'a']++;
        
        for(int i=0; i<s1.size(); i++)
            freq[s2[i]-'a']--;
        
        bool flag = true;
        for(int x: freq)
            if(x!=0)
            {
                flag = false;
            }
        if(flag) return flag;
        
        for(int i=s1.size(); i<s2.size(); i++)
        {
            flag = true;
            freq[s2[i-s1.size()]-'a']++;
            freq[s2[i]-'a']--;
            for(int x: freq)
                if(x!=0)
                {
                    flag = false;
                }
            if(flag) return flag;
        }
            
        
        return flag;
        
    }
    */
    
    bool checkInclusion(string s1, string s2) {
        int m = s1.length();
        int n = s2.length();
        
        if(n<m) return false;
        
        array<int, 26> s1cnt{0}, s2cnt{0};
        
        for(int i=0; i<m; i++)
        {
            s1cnt[s1[i]-'a']++;
            s2cnt[s2[i]-'a']++;
        }
        
        if(s1cnt == s2cnt)
            return true;
        
        for(int i=m; i<n; i++)
        {
            s2cnt[s2[i-m]-'a']--;
            s2cnt[s2[i]-'a']++;
            if(s1cnt == s2cnt)
                return true;
        }
        return false;
    }
};