/*

https://leetcode.com/problems/count-unique-characters-of-all-substrings-of-a-given-string/
828. Count Unique Characters of All Substrings of a Given String

    Ref : https://leetcode.com/problems/count-unique-characters-of-all-substrings-of-a-given-string/discuss/128952/JavaC%2B%2BPython-One-pass-O(N)

Steps :
We try to find the contribution of each char by finding the neighbouring index of same char 
        0 1 2 3 4 5 6 7 8
i.e ::  a b c d c x y c s
contribution of middle 'c' is nothing but L * R where L = (4-2) and R = (7-4)
contribution of first 'c' is nothing but L * R where L = (2-(-1)) and R = (4-2)
contribution of last 'c' is nothing but L * R where L = (7-4) and R = (9-7)
Use 2d Matrix to track down last 2 occurance of each char and use it to calculate the above value and also update the value at each iteartion
*/

class Solution {
public:
    int uniqueLetterString(string s) {
        int n=s.length();
        // records last two occurence index for every upper characters
        int index[26][2]; memset(index, -1, sizeof(index));
        int cnt=0;
        for(int i=0; i<n; i++)
        {
            int ch = s[i]-'A';    
            cnt+= (i-index[ch][1])*(index[ch][1]-index[ch][0]);
            index[ch][0] = index[ch][1];
            index[ch][1] = i;
        }
        
        for(int ch=0; ch<26; ch++)
            cnt+= (n-index[ch][1])*(index[ch][1]-index[ch][0]);
        return cnt;
    }
};