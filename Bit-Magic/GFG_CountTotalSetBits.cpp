/*
https://practice.geeksforgeeks.org/problems/count-total-set-bits-1587115620/1#
Count total set bits 
*/
// { Driver Code Starts
//Initial Template for C++

#include<bits/stdc++.h>
using namespace std;


 // } Driver Code Ends
//User function Template for C++

class Solution{
    public:
    // n: input to count the number of set bits
    //Function to return sum of count of set bits in the integers from 1 to n.
    int countSetBits1(int n)
    {
        int c=0;
        
        // Using DP, TLE O(n)
        /*
        int x=1;
        int dp[n]={0};
        dp[0]=0;
        for(int i=1; i<=n; i++)
        {
            // if(i==x*2)
            //     x=i;
            // dp[i]= 1+dp[i%x]; // divided into sections 0-1, 2-3, 4-7, 8-15. previous sections + 1
            dp[i] = dp[i & (i - 1)] + 1;
             c+=dp[i];
        }
        */
        // Using BuiltIn PopCount
        c=1;
        for(int i=2; i<=n; i++)
            c += __builtin_popcount(i);

        return c;
    }
//A simple vertical counting technique

/*
* If we travel vertically downwards, the pattern is as follows
* 0 0 0 0 - 0
* 0 0 0 1 - 1
* 0 0 1 0 - 2
* 0 0 1 1 - 3
* 0 1 0 0 - 4
* 0 1 0 1 - 5
* 0 1 1 0 - 6
* 0 1 1 1 - 7
* 1 0 0 0 - 8
* 1 0 0 1 - 9
* 1 0 1 0 - 10
* 1 0 1 1 - 11
* 1 1 0 0 - 12
* ...
* For LSB -  0 1 0 1 ..... (repetition pattern is 0 1)
* For next MSB - 0 0 1 1 0 0 1 1 0 ..... (repetition pattern is 0 0 1 1)
* For next MSB - 0 0 0 0 1 1 1 1 0 0 0 .... (repetition pattern is 0 0 0 0 1 1 1 1)
* and so on.
*/
    int countSetBits(int n)
    {
        int cnt=0;
        
        int numOfBits = log2(n)+1; // number of bits in n
        
        // int copy = n;
        // numOfBits=0;
        // while(copy>0)
        // {
        //     copy = copy>>1;
        //     numOfBits++;
        // }
        
        int blockSize=0, numOfBlocks=0, rem=0;
        
        int it=1; // starting from LSB
        while(it <= numOfBits)
        {
            blockSize = pow(2, it);
            int halfBlockSize = blockSize/2;
             
            numOfBlocks = n/blockSize; // num of such blocks
            rem = n%blockSize; // if incomplete block in the end
            
           
            cnt += numOfBlocks*(halfBlockSize); // num of blocks and each block number of bits
            
            if(rem >= halfBlockSize) //ones will be in other half
            {
                cnt += rem - halfBlockSize + 1; // because we are counting from zero that is why +1
            }
            
            it++;
        }//while numOfBits
        
        return cnt;
    }
    
    // int countSetBits(int n)
    // {
    //     if(n<=1) return n;
    //     int p;
    //     while((1 << p)<=n){
    //         p+=1;
            
    //     cout<<" "<<p;
    //     }
    //     p-=1;
    //     cout<<" "<<p<<" ";
    // }
};


// { Driver Code Starts.

// Driver code
int main()
{
	 int t;
	 cin>>t;// input testcases
	 while(t--) //while testcases exist
	 {
	       int n;
	       cin>>n; //input n
	       Solution ob;
	       cout << ob.countSetBits(n) << endl;// print the answer
	  }
	  return 0;
}
  // } Driver Code Ends