/*
https://practice.geeksforgeeks.org/problems/tower-of-hanoi-1587115621/1#
Tower Of Hanoi 
*/
// { Driver Code Starts
#include <bits/stdc++.h>

using namespace std;


 // } Driver Code Ends
class Solution{
    public:
    // You need to complete this function

    long long steps=0;
    // avoid space at the starting of the string in "move disk....."
    long long toh(int N, int from, int to, int aux) {
     steps++;
     if(N==1) 
     {
         cout<<"move disk "<<N<<" from rod "<<from<<" to rod "<<to<<endl;
         return 1;
     }
     
     
     toh(N-1, from, aux, to);
        cout<<"move disk "<<N<<" from rod "<<from<<" to rod "<<to<<endl;
     toh(N-1, aux, to, from);
     
        
     return steps;
    //  return pow(2,N)-1;
    }

};

// { Driver Code Starts.

int main() {

    int T;
    cin >> T;//testcases
    while (T--) {
        
        int N;
        cin >> N;//taking input N
        
        //calling toh() function
        Solution ob;
        
        cout << ob.toh(N, 1, 3, 2) << endl;
    }
    return 0;
}


//Position this line where user code will be pasted.  // } Driver Code Ends