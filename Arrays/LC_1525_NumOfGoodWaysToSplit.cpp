/*
https://leetcode.com/problems/number-of-good-ways-to-split-a-string/
1525. Number of Good Ways to Split a String
*/
class Solution {
public:
    int numSplits(string s) {
        
        if(s.length() <= 1) return 0;

        int count=0;
        int d=0 ;
        
        // /*
        vector<int> lhash(26,0); //left hash
        vector<int> rhash(26,0); //right hash
        
        int ldc=0; // left distinct count
        int rdc=0; // right distinct count
        
        lhash[s[0]-'a']=1;
        ldc=1;
        
        for(int i=1; i<s.length(); i++)
        {
             d = s[i]-'a';
            rhash[d]++;
            if(rhash[d] == 1) rdc++; // count all distinct char in right hash
        }
        
        for(int i=1; i<s.length(); i++)
        {
           if(ldc == rdc) count++;
            
            d = s[i]-'a';
            lhash[d]++;
           if(lhash[d] == 1) ldc++; // if it is new char inc distinct count
            
           rhash[d]--;
            if(rhash[d] == 0) rdc--; // if char is no more in right side, dec count
            
        }
        // */
        
         // if(ldc == rdc) count++;
        
        // cout<<"rdc "<<rdc<<endl;
        // cout<<"ldc "<<ldc<<endl;
        // for(int i=0; i<lhash.size(); i++)
        // {
        //     cout<<(char)(i+97)<<lhash[i]<<" ";
        // }
        // cout<<endl;
        // for(int i=0; i<lhash.size(); i++)
        // {
        //     cout<<(char)(i+97)<<rhash[i]<<" ";
        // }
        
        
        /*
        // Approach 2 using unorderd Set
        unordered_set<char> ss;
        vector<int> prefix(s.size(),0);
        vector<int> suffix(s.size(),0);
        for(int i=0; i<s.size(); i++)
        {
            if(ss.find(s[i]) == ss.end())
            {
                d++;
                prefix[i]=d;
                ss.insert(s[i]);
            }
            else
                prefix[i]=d;
        }
        
        d=0;
        ss.clear();
        for(int i=s.size()-1; i>=0; i--)
        {
            if(ss.find(s[i]) == ss.end())
            {
                d++;
                suffix[i]=d;
                ss.insert(s[i]);
            }
            else
                suffix[i]=d;
        }
        
        // for(int i=0; i<prefix.size(); i++)
        // {
        //     cout<<prefix[i]<<" ";
        // }
        // cout<<endl;
        // for(int i=0; i<suffix.size(); i++)
        // {
        //     cout<<suffix[i]<<" ";
        // }
        // cout<<endl;
        for(int i=1; i<s.length(); i++)
        {
            if(prefix[i-1] == suffix[i]) count++;
        }
         */
        
        return count;
    }//end
};