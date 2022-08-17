/*
https://leetcode.com/problems/verifying-an-alien-dictionary/
953. Verifying an Alien Dictionary

*/

class Solution {
public:
    bool isAlienSorted(vector<string>& words, string order) {
        
        int hash[26] = {0};
        vector<string> translated;
        
        for(int o=0; o<order.size(); o++)
            hash[order[o]-'a'] = o;
        
//         for(int w=0; w<words.size(); w++)
//         {
//             string t;
//             for(char ch: words[w])
//                 t += hash[ch-'a']+'a';
//             translated.push_back(t);
            
//             // cout<<t<<" ";
            
//             if(w-1>=0 && translated[w-1] > translated[w])
//                 return false;
//         }
        
        for(int w=1; w<words.size(); w++)
        {
            string t1 = words[w-1];
            string t2 = words[w];
            
            int j1=0, j2=0;
            while(j1<t1.size() && j2<t2.size())
                if(t1[j1] == t2[j2])
                {
                    j1++; j2++;
                }else break;
            // printf("%d %d %d %d\n", j1, j2, order.find(t1[j1]), order.find(t2[j2]));
            // if(int(order.find(t1[j1])) > int(order.find(t2[j2])) )
            //     return false;
            
            if(j1 == t1.size()) continue;
            else if(j2 == t2.size()) return false;
            
            if(hash[t1[j1]-'a'] > hash[t2[j2]-'a'] )
                return false;
            
        }
        
        return true;
    }//end
};