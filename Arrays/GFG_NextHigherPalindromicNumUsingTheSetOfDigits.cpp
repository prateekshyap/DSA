/*
https://practice.geeksforgeeks.org/problems/next-higher-palindromic-number-using-the-same-set-of-digits5859/1#
Next higher palindromic number using the same set of digits 
*/

// { Driver Code Starts
//Initial template for C++

#include <bits/stdc++.h>
using namespace std;


 // } Driver Code Ends
//User function template for C++

class Solution{
  public:
    string nextPalin_(string s) { 
        int n = s.length();
        if(n<=3)
            return "-1";
        
        string left = s.substr(0, n/2);
        if(next_permutation(left.begin(), left.end()) == false)
            return "-1";
        string right = left;
        reverse(right.begin(), right.end());
        if(n%2 == 1)
            left += s[n/2];
        return left+right;
    }
    
    string nextPalin(string s) { 
        int n = s.length();
        if(n<=3)
            return "-1";
        int mid = n/2; // mid index
        int rem = n&1; //n%2; //odd length

        // find next permutation of string 1 to mid
        int partind = -1, chngind = -1;
        for(partind=mid-2; partind>=0; partind--)
        {
            if(s[partind] < s[partind+1])
                break;
        }
        if(partind < 0)
            return "-1";
        
        for(chngind = mid-1; chngind>partind; chngind--)
        {
            if(s[chngind] > s[partind])
                break;
        }
        // cout<<partind<<" "<<chngind<<endl;
        swap(s[chngind] , s[partind]);
        
        reverse(s.begin()+partind+1, s.begin()+mid);
        // now s contains the next higher permutation
        
        for(int i = mid + bool(rem); i<n; i++)
            s[i] = s[n-1-i]; // mirror right half of the mid
            
        return s;
    }//
};

// { Driver Code Starts.

int main() {

    int t;
    cin >> t;
    while(t--){
        string s;
        cin >> s;
        Solution obj;
        cout << obj.nextPalin(s) << endl;
    }
    return 0;
}  // } Driver Code Ends