/*
https://leetcode.com/problems/goat-latin/
824. Goat Latin

*/
class Solution {
public:
    string toGoatLatin(string sentence) {
        string ans;
        unordered_map<char,bool> vow = {
            {'a', true},
            {'e', true},
            {'i', true},
            {'o', true},
            {'u', true},
            {'A', true},
            {'E', true},
            {'I', true},
            {'O', true},
            {'U', true}
        };
        
        int cnt_a = 1;
        stringstream ss(sentence);
        string buff;
        
        while(ss>>buff)
        {
            if(vow.find(buff[0]) != vow.end())
            {
                ans+= buff+"ma" + string(cnt_a++, 'a')+ ' ';
            }
            else
            {
                ans += buff.substr(1) + buff[0] + "ma" + string(cnt_a++, 'a')+ ' ';
            }
        }
        
        ans.pop_back();
        
        return ans;
    }
};