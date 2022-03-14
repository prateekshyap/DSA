/*
https://leetcode.com/problems/uncommon-words-from-two-sentences/
884. Uncommon Words from Two Sentences
*/

class Solution {
public:
    
   
    vector<string> uncommonFromSentences(string s1, string s2) {
        
        vector<string> ans;
        
        unordered_map<string, int> smp;
        
        string orig = s1 + " "+ s2;
        
        stringstream ss(orig);
            
        string buff="";
        
        while(ss >> buff)
        {
            smp[buff]++;
        }
        
        for(auto it: smp)
        {
            if(it.second == 1)
            {
                ans.push_back(it.first);
            }
        }
        
        return ans;
    }//end
};

/*
vector<string> uncommonFromSentences(string s1, string s2) {
        
        string s = s1+" "+s2;
        unordered_map<string, int> mp;
        
        vector<string> ans;
        string word; 
        
        // stringstream ss(s); 
        //  while (ss >> word)
        //     mp[word]++;
        
        for(char c: s){
            if(c==' '){
                mp[word]++;
                word="";
            }
            else{
                word+=c;
            }
        }
        mp[word]++;
        
        for(auto i: mp){
            if(i.second == 1)
                ans.push_back(i.first);
        }
        return ans;   
    }
	
*/