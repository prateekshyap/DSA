/*
https://practice.geeksforgeeks.org/problems/smallest-number5829/1#
Smallest number 
*/

// { Driver Code Starts
#include<bits/stdc++.h> 
using namespace std; 

 // } Driver Code Ends
class Solution{   
public:
    string smallestNumber_1(int S, int D){
        if(9*D < S)
            return "-1";
            
        string ans(D,'0'); // string of D with all 1s
        int j = D-1;
        
        while(j>=0)
        {
            if(S > 9)
            {
                ans[j] = '9';
                S -= 9; 
            }
            else if(D>1) // D>1 but S<9
            {
                // if digits are more but sum is less than 9 
                //then concat s-1 at end, 0 in the middle and 1 in beginning
                ans[j] = S-1 +'0'; 
                S=1 ; // S-(S-1);
            }
            else
            {
                ans[j] = S + '0';
            }
            
            D--;
            j--;
        }
        
        return ans;
    }
    
    string smallestNumber(int S, int D){
        if(9*D < S)
            return "-1";
            
        int ans = (int) pow(10, D-1);
        int d = 1;
        int mn=0;
        S = S-1; // 1 added at begining of ans
        // cout<<ans<<endl;
        while(S>0)
        {
            mn = min(S, 9);
            ans += d*mn;
            S -= mn;
            d*=10;
            // cout<<mn<<" "<<S<<" "<<ans<<" "<<d<<" "<<endl;
        }
        
        return to_string(ans);
    }
    
};

// { Driver Code Starts.
int main() 
{ 
    int t;
    cin>>t;
    while(t--)
    {
        int S,D;
        cin >> S >> D;
        Solution ob;
        cout << ob.smallestNumber(S,D) << endl;
    }
    return 0; 
}   // } Driver Code Ends