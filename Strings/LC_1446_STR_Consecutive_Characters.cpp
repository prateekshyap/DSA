/* 
 	https://leetcode.com/problems/consecutive-characters/
	1446. Consecutive Characters Easy
	The power of the string is the maximum length of a non-empty substring that contains only one unique character.
	Given a string s, return the power of s
*/

class Solution {
public:
    int maxPower(string s) {
        int n = s.size();
        int max_so_far = INT_MIN;
        
        if (n == 0) return 0;
        else if (n == 1) return 1;
        
        //Using power array
//         int power[n];
//         power[0]=1;
//         for(int i=1; i<n; i++){
//             if(s[i] == s[i-1])
//                 power[i] = power[i-1]+1;
//             else
//                 power[i]=1;
            
//             if(power[i]>max_so_far) max_so_far = power[i];
//         }
        
        //Without using extra space
        int c=1;
        for(int i=1; i<n; i++){
            if(s[i] == s[i-1])
                c++;
            else
                c=1;
            
            if(c>max_so_far) max_so_far = c;
        }
        
        
        return max_so_far;
    }//maxPower
};