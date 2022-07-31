/*
https://binarysearch.com/problems/Unique-String-Frequencies
Unique String Frequencies

https://leetcode.com/problems/minimum-deletions-to-make-character-frequencies-unique/
*/

int minDeletions(string s) {
        int ans=0;
        vector<int> freq(26, 0);

        for(char &c: s)
            freq[c-'a']++;

        sort(freq.begin(), freq.end(), greater<>());

        // for(int i=0; i<26; i++)
        //     cout<<freq[i]<<" "; 

        int i=0;
        int j=1, cnt=0;
        while(j<26 && freq[j])
        {
            cnt=0;
            // cout<<"["<<j<<"]";
            while(j<26 && freq[j] && freq[i]==freq[j])
            {
                // cout<<"("<<j<<")";
                freq[j]--;
                j++;
                cnt++;
            }

            ans += cnt;
            i++;
            j=i+1;

        }

        // cout<<endl;
        // for(int i=0; i<26; i++)
        //     cout<<freq[i]<<" "; 

        return ans;
    }

class Solution {
public:
    int minDeletions(string s) {
        int ans=0, cnt=0;
        int freq[26]= {0};

        for(char &c: s)
            freq[c-'a']++;

        sort(begin(freq), end(freq), greater<>());
        int mxfreq = freq[0]-1;
        // for(int i=0; i<26; i++)
        //     cout<<freq[i]<<" "; 

        for(int j=1; j<26 && freq[j]; j++)
        {
            if(freq[j] > mxfreq)
            {
                cnt = freq[j] - mxfreq;
                ans+=cnt;
                freq[j] -= cnt;
            }
            
            mxfreq = max(0, freq[j]-1);
        }
        // cout<<endl;
        // for(int i=0; i<26; i++)
        //     cout<<freq[i]<<" "; 

        return ans;
    }
    
    
};

// Binary Search -----------------------------------------------------------
int solve_2(string s) {
    
    int ans=0;
    vector<int> freq(26, 0);

    for(char &c: s)
        freq[c-'a']++;

    unordered_set<int> st;
    for(int f: freq)
    {
        while(f>0 and st.find(f) != st.end()) // same freq exist
        {
            f--;
            ans+=1;
        }
        if(f!=0) st.insert(f);
    }
    
    return ans;

}

int solve(string s) {
    
    int ans=0;
    vector<int> freq(26, 0);

    for(char &c: s)
        freq[c-'a']++;

    sort(freq.begin(), freq.end(), greater<>());

    vector<int> freqCounts;
    for(int i=0; i<26 && freq[i]; i++)
        freqCounts.push_back(freq[i]);

    int mxfreq = freq[0]-1;
    int cnt=0;

    for(int fc=1; fc<freqCounts.size(); fc++)
    {
        if(freqCounts[fc] > mxfreq)
        {
            cnt = freqCounts[fc] - mxfreq;
            ans+= cnt;
            freqCounts[fc] -= cnt;
        }
        mxfreq = max(0, freqCounts[fc]-1);

    }//for
    
    return ans;

}