/*
https://leetcode.com/problems/move-pieces-to-obtain-a-string/
2337. Move Pieces to Obtain a String

*/

class Solution {
public:
    bool canChange(string start, string target) {
        int slen = start.size();
        int tlen = target.size();
        
        if(slen != tlen)
            return false;
        
        int i=0;
        int j=0;
        while(i<slen && j<tlen)
        {
            while(i<slen && start[i] == '_')
                i++;
            while(j<tlen && target[j] == '_')
                j++;
            
            if(start[i] != target[j])
                return false;
            
            if(i>j && start[i] == 'R') // ith ka R right jaa sakta hai par jth ka left mai hai
                return false;
            if(i<j && start[i] == 'L') // ith ka L left jaa sakta hai par jth ka right mai hai
                return false;
            
            i++;
            j++;
        }
        
        return true;
    }
};