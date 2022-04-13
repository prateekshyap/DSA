/*
https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/
1456. Maximum Number of Vowels in a Substring of Given Length
-
*/
class Solution {
public:
    int maxVowels(string s, int k) {
        
        int maxVow = 0;
        int currCount = 0;
        
        for(int i=0; i<k; i++)
        {
            if(s[i]=='a' || s[i]=='e' || s[i]=='i' || s[i]=='o' || s[i]=='u')
                currCount++;
        }
        
        maxVow = currCount;
        
        for(int i=k; i<s.size(); i++)
        {
            
            if(s[i-k]=='a' || s[i-k]=='e' || s[i-k]=='i' || s[i-k]=='o' || s[i-k]=='u')
                currCount--;
            
            if(s[i]=='a' || s[i]=='e' || s[i]=='i' || s[i]=='o' || s[i]=='u')
                currCount++;
            if(maxVow < currCount)
                maxVow = currCount;
        }
        
        return maxVow;
    }// end
};