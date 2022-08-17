/*
https://leetcode.com/problems/word-ladder/
127. Word Ladder
https://practice.geeksforgeeks.org/problems/word-ladder/1
*/

class Solution {
public:
    
    int ladderLength_1(string beginWord, string endWord, vector<string>& wordList) {
        
        unordered_set<string> dict(wordList.begin(), wordList.end()); // copy(wordList.begin(), wordList.end(), inserter(us, us.end()));
        if(dict.count(endWord) == 0) return 0;
        
        queue<string> q; q.push(beginWord);
        // unordered_set<string> visited;
    
        int numMutation=0;
        while(!q.empty())
        {
            int sz=q.size();
            numMutation++;
            // cout<<endl<<"**** Layer number: "<<numMutation<<" ****"<<endl;
            // cout<<"\tWords are: ";
            while(sz--)
            {
                string w = q.front(); q.pop();
                // cout<<w<<", ";
                if(w == endWord) return numMutation;
                for(int i=0; i<w.size(); i++)
                {
                    char prev = w[i];
                    for(char ch='a'; ch<='z'; ch++)
                    {
                        w[i]=ch;
                        // if(dict.find(w) != dict.end() and visited.find(w)==visited.end())
                        if(dict.count(w))
                        {
                            // visited.insert(w);
                            q.push(w);
                            dict.erase(w);
                        }
                    }
                    w[i] = prev;
                }
            }//while(sz--)
        }//while(!q.empty())
        
        return 0;
    }//ladderLength
    
    int ladderLength_2(string beginWord, string endWord, vector<string>& wordList) {
        unordered_set<string> dict(wordList.begin(), wordList.end()); 
        if(dict.count(endWord) == 0) return 0;
        
        int L = beginWord.size(); // Since all words are of same length.
        unordered_map<string, vector<string>> allCombDict;
        for(string w: wordList) {
            string origw = w;
            for(int i=0; i<L; i++) {
                char prev = w[i];
                w[i]='*';
                allCombDict[w].push_back(origw);
                w[i] = prev;
            }
        }
        // for(auto x: allCombDict) {  cout<<x.first<<" "; for(auto y: x.second) cout<<y<<" ";  cout<<endl; }
        
        int numMutation=0;
        queue<string> q; q.push(beginWord);
        while(!q.empty())
        {
            numMutation++;
            int size= q.size();
            // cout<<endl<<"**** Layer number: "<<numMutation<<" ****"<<endl;
            // cout<<"\tWords are: ";
            while(size--){
                string w = q.front(); q.pop();
                // cout<<w<<", ";
                for(int i=0; i<L; i++)
                {
                    char prev = w[i];
                    w[i]='*';
                    for(string relatedw: allCombDict[w])
                    {
                        if(relatedw == endWord) return numMutation+1;
                        if(dict.count(relatedw))
                        {
                            q.push(relatedw);
                            dict.erase(relatedw);
                        }
                    }

                    w[i] = prev;
                }
            }
        }
        return 0;
    }
    
    int ladderLength(string beginWord, string endWord, vector<string>& wordList) {
        unordered_set<string> dict(wordList.begin(), wordList.end()); 
        if(dict.count(endWord) == 0) return 0;
        int numMutation=1;
        unordered_set<string> begSet, endSet, *set1, *set2;
        begSet.insert(beginWord);
        endSet.insert(endWord);
        int L = beginWord.size();
        while(!begSet.empty() and !endSet.empty())
        {
            if(begSet.size() <= endSet.size())
            {
                set1 = &begSet; set2=&endSet;
            }else{
                set2 = &begSet; set1=&endSet;
            }
            unordered_set<string> intermediate;
            numMutation++;
            for(auto it=set1->begin(); it!=set1->end(); it++)
            {
                string w = *it;
                for(int i=0; i<L; i++)
                {
                    char prev = w[i];
                    for(char ch='a'; ch<='z'; ch++)
                    {
                        w[i]=ch;
                        if(set2->find(w) != set2->end()) return numMutation;
                        if(dict.count(w))
                        {
                            intermediate.insert(w);
                            dict.erase(w);
                        }
                    }
                    w[i] = prev;
                }
                
            }//for
            swap(*set1, intermediate);
        }//while
        return 0;
    }
};