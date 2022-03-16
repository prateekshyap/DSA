/*
https://leetcode.com/problems/rotate-string/
796. Rotate String

*/

class Solution {
public:
    bool rotateString(string s, string goal) {
        
        int sl = s.length();
        int gl = goal.length();
        
        if( sl != gl ) return false;
        
        string c = s+s;
        
        return (c.find(goal) != string::npos);
    }
};