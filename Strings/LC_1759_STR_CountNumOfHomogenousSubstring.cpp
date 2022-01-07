/* 
 	https://leetcode.com/problems/count-number-of-homogenous-substrings/submissions/
	1759. Count Number of Homogenous Substrings Medium
	Given a string s, return the number of homogenous substrings of s. Since the answer may be too large, return it modulo 109 + 7.
	A string is homogenous if all the characters of the string are the same.
	A substring is a contiguous sequence of characters within a string.
*/

class Solution {
public:
    #define mod 1000000007
    #define ll long long
    //Total number of substrings of all lengths from 1 to n = n * (n + 1)/2
    
    int countHomogenous(string s) {
        int n = s.size();
        if(n==1)return 1;
        
        ll c=1;
        ll ans=0;
        
        // if-else basic approach.
//         for(int i=0; i<n; i++){
            
//             if(s[i] != s[i+1]){
//                 c=1;
//                 ans = ans + c;
//             }
//             else
//             {
//                 c=1;
//                 int j=i+1;
//                 while(s[i]==s[j]){
//                     c++;
//                     j++;
//                 }
//                 cout<<"s[i] "<<i<<", "<<s[i]<<" ";
//                 i=j-1;                      // adjust i value to new unique char, -1 as we are doing i++ again in for loop
//                 ans = ans + ((c*(c+1))/2);  // number of substring for the homogenous substring
//                 cout<<"c "<<c <<" ,a "<<ans<<" ,i "<<i<<" , j"<<j<<endl;
//             }
            
//         }//for i
        
        //common loop
        for(int i =0; i<n; i++){
            c=1;
            int j = i+1;
            while(s[i]==s[j]) ++j;      //count number of common characters
            
            c=j-i;      // number of common characters;
            i= j-1 ; // adjust i value to new unique char, -1 as we are doing i++ again in for loop
            ans = ans + ((c*(c+1))/2);
        }
        
        return ans%mod; 
    }//countHomogenous
};