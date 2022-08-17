/*
https://leetcode.com/problems/check-if-a-string-contains-all-binary-codes-of-size-k/
1461. Check If a String Contains All Binary Codes of Size K

*/

class Solution {
public:
    /*
    bool hasAllCodes_1(string s, int k) {
        if(s.size() < k) return false;
        int total_strings = 1<<k;
        unordered_set<string> uset;
        
        for(int i=0; i<s.size()-k+1; i++)
        {
            string s1 = s.substr(i,k);
            uset.insert(s1);
        }
        
        return total_strings == uset.size();
    }
    */
    
    /*
     bool hasAllCodes(string s, int k) {
        ios_base::sync_with_stdio(0);
        cin.tie(nullptr);
        if(s.size() < k) return false;
         
        int total_strings = 1<<k;
        int left_strings = total_strings;
        vector<bool> seen(total_strings);
         
        for(int i=0; i<s.size()-k+1; i++)
        {
            string s1 = s.substr(i,k);
            int v = stoi(s1,0, 2);
            if(!seen[v])
            {
                 seen[v]= true;
                --left_strings;
                if(!left_strings) return true;
            }
        }
        return false;
    }
    */
    
    bool hasAllCodes(string s, int k) {
        ios_base::sync_with_stdio(0);
        cin.tie(nullptr);
        if(s.size() < k) return false;
         
        int total_strings = 1<<k; //2^k
        int left_strings = total_strings;
        vector<bool> seen(total_strings, false);
        int mask = total_strings-1; //all ones of length k
        // int v=0;
        int v = stoi(s.substr(0,k),0, 2);  //first k bit string value
        seen[v]= true;
        --left_strings;
        // cout<<bitset<8>(mask)<<endl;
        for(int i=0; i<s.size(); i++)
        {
            // v<<=1;
            // v |= s[i]-'0';
            // v&=mask;
            // cout<<bitset<8>(v)<<endl;
            v = ((v<<1) | (s[i]-'0')) & mask;
            if(!seen[v])
            {
                 seen[v]= true;
                --left_strings;
                if(!left_strings) return true;
            }
        }
        return false;
    }
};