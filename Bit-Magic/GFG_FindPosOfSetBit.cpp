/*
https://practice.geeksforgeeks.org/problems/find-position-of-set-bit3706/1
Find position of set bit 
*/
// { Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

 // } Driver Code Ends
class Solution {
  public:
    int findPosition1(int N) {
       if(N==0) return -1;
       
       int pos=0;
       bool flag=false; //for second time 1.
       
       while(N>0)
       {
         pos++; // increase position count
         
         if(N&1 == 1 )
         {
             if(flag) return -1; //second one
             flag = true;
         }
           
           N>>=1; //left shift by 1 bit
       }
       
       return pos;
    }
    
    int findPosition(int N) {
        
       if( (N==0) || ((N&(N-1))!=0) ) 
            return -1; // not power of two
       
       return log2(N)+1; // power of two
       
    //   int pos=0;
       
    //   while(N>0)
    //   {
    //       pos++; // increase position count
    //       N>>=1; //left shift by 1 bit
    //   }
       
    //   return pos;
    }
};
// { Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        int N;

        cin>>N;

        Solution ob;
        cout << ob.findPosition(N) << endl;
    }
    return 0;
}  // } Driver Code Ends