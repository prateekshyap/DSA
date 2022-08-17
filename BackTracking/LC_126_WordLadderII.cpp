/*
126. Word Ladder II
https://practice.geeksforgeeks.org/problems/word-ladder-ii/1
https://leetcode.com/problems/word-ladder-ii/
*/

class Solution {
public:
    string beginWord;
    vector<vector<string>> ans;
    
    vector<vector<string>> findLadders(string beginWord, string endWord, vector<string>& wordList) {
        
        // Step 1 Checking Part
       unordered_set<string> dict(wordList.begin(), wordList.end());
       if(dict.find(endWord) == dict.end()) return ans; // if end word does not exist
       if(dict.find(beginWord) == dict.end()){ // if begin word does not exist
           wordList.push_back(beginWord);
           dict.insert(beginWord);
       } 
        // Step 2 Preprocessing
        unordered_map<string, vector<string>> adj;
        int L = beginWord.size();
        // for(string& w: wordList)  {
        //     string orig = w;
        //     for(int i=0; i<L; i++)
        //     {
        //         char temp = w[i];
        //         for(char ch='a'; ch<='z'; ch++)
        //         {
        //             if(ch == temp) continue;
        //             w[i] = ch;
        //             if(dict.find(w) != dict.end())
        //                 adj[orig].push_back(w);
        //         }
        //         w[i] = temp;
        //     }
        // }
        for(string w: wordList) {
            string origw = w;
            for(int i=0; i<L; i++) {
                char prev = w[i];
                w[i]='*';
                adj[w].push_back(origw);
                w[i] = prev;
            }
        }
        
        //Step 3 BFS
        queue<string> q; q.push(beginWord); 
        unordered_map<string, int> minDepth;
        unordered_map<string, vector<string>> parent; 
        minDepth[beginWord] = 1;
        
        bool found = false;
        int depth = 0;
        
        while(!q.empty() )
        {
            int sz = q.size();
            depth++;
            while(sz--)
            {
                string cur = q.front(); q.pop(); 
                if(cur == endWord)
                {
                    found = true;
                    break;
                }
                if(dict.find(cur)==dict.end()) continue;
                dict.erase(cur);
                string orig = cur;
                for(int i=0; i<L; i++)
                {
                    char prev = cur[i];
                    cur[i]='*';
                    for(string& relatedw: adj[cur])
                    { 
                        if(minDepth.count(relatedw)==0 )
                        {
                            q.push(relatedw);
                            minDepth[relatedw] = 1+depth;
                        }
                        if(depth == minDepth[relatedw]-1)
                            parent[relatedw].push_back(orig);
                    } 
                    cur[i] = prev;
                }
                // if(dict.find(cur)==dict.end()) continue;
                // dict.erase(cur);
                // for(string& next: adj[cur])
                // { 
                //     if(minDepth.find(next) == minDepth.end())
                //     {
                //         q.push(next);
                //         minDepth[next] = 1+depth;
                //     }
                //     if(depth == minDepth[next]-1)
                //         parent[next].push_back(cur);
                // }
            }
        }
        
        
        // for(auto x: adj) {
        //     cout<<x.first<<"->"; for(string w: x.second) cout<<w<<" "; cout<<endl;
        // }
        // for(auto x: minDepth) {
        //     cout<<x.first<<"->"<<x.second<<" "; cout<<endl;
        // }
        // for(auto x: parent) {
        //     cout<<x.first<<"->"; for(string w: x.second) cout<<w<<" "; cout<<endl;
        // }
        
        
        // Step 4: DFS
        if(found)
        { 
            this->beginWord = beginWord;
            vector<string> out(1, endWord);
            solve(endWord, parent, out);
        }
        
        return ans;
    }//end main
    
    void solve(string curWord, unordered_map<string, vector<string>>& parent, vector<string> out)
    {
        if(beginWord == curWord)
        { 
            ans.push_back(vector<string>(out.rbegin(), out.rend()));
            return;
        }
        for(string &w: parent[curWord])
        {
            out.push_back(w);
            solve(w, parent, out);
            out.pop_back();
        }
        
    }
};