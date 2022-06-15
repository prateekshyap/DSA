/*
https://leetcode.com/problems/permutation-sequence/
60. Permutation Sequence

*/
class Solution {
public:
    string getPermutation(int n, int k) {
        /*
        string dig;
        for(int i=1; i<=n; i++)
            dig += i + '0';
        
        string ans;
        
        do
        {
            ans = dig;
        }while(--k && next_permutation(dig.begin(), dig.end()));
        
        return ans;
        */
        
        k--; // zero indexing for k=3 --> 2 (0,1,2);
        vector<int> digits(n,0); // to store digits [1,2,3,4];
        int fact = 1; // size of group
        int d_index = 0; //index for digits vector, group index
        
        string ans="";
        
        for(int i=1; i<n; i++)
        {
            fact *= i; // fact of n-1 = (n-1)! why? --> digits are repeated n!/n times that is (n-1)! times
            digits[i-1] = i; // push n-1 digits into array
        }
        digits[n-1] = n; // push nth digit
        
        while(digits.size())
        {
            d_index = k/fact; // index of number in digits array
            ans += digits[d_index]+'0';
            
            digits.erase(digits.begin() + d_index); //erase this number, now digits.size()==>n-1
            
            // if(digits.size()==0) break;
            
            k = k%fact; // update k with remainder 
            fact = (digits.size()==0) ? (fact): (fact/digits.size()); 
            // digits.size()=2, fact = (n-1)! --> (n-1)!/(n-1) = (n-2)!
            // for(int i: digits)
            //     cout<<i<<" ";
            // cout<<"d_in "<<d_index;
            // cout<<" k "<<k;
            // cout<<" fact "<<fact<<endl;
        }
        
        return ans;
    }//end
};