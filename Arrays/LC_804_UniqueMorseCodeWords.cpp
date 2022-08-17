/*
https://leetcode.com/problems/unique-morse-code-words/
*/
class Solution {
public:
    int uniqueMorseRepresentations(vector<string>& words) {
        int n = words.size();
        // int ans=0;
        unordered_set<string> uniqueMorse;
        vector<string> morseCode = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        
        for(string &s: words)
        {
            string transform="";
            for(char& ch: s)
            {
                transform += morseCode[ch-'a'];
            }
            uniqueMorse.insert(transform);
        } 
        return uniqueMorse.size();
    }
};