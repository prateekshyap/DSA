/* https://leetcode.com/problems/uncommon-words-from-two-sentences/
 * A sentence is a string of single-space separated words where each word consists only of lowercase letters.
 * A word is uncommon if it appears exactly once in one of the sentences, and does not appear in the other sentence.
 * Given two sentences s1 and s2, return a list of all the uncommon words. You may return the answer in any order.
 */

class Solution {
public:
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

};