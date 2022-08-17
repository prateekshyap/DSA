/*
1220. Count Vowels Permutation
https://leetcode.com/problems/count-vowels-permutation/
*/

class Solution {
public:
    const int mod  = 1e9+7;
    int countVowelPermutation(int n) {
        int a=1, na;
        int e=1, ne;
        int i=1, ni;
        int o=1, no;
        int u=1, nu;
        
        for(int itr=2; itr<=n; itr++)
        {
            na = ((e+u)%mod+i)%mod;
            ne = (a+i)%mod;
            ni = (e+o)%mod;
            no = i%mod;
            nu = (i+o)%mod;
            
            a = na;
            e = ne;
            i = ni;
            o = no;
            u = nu;
        }
        
        return (((a+e)%mod+(i+o)%mod)%mod+u)%mod;
    }
};