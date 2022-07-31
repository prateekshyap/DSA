/*
https://practice.geeksforgeeks.org/problems/nth-catalan-number0817/1/#
Nth catalan number 
*/

// { Driver Code Starts
//Initial template for C++

#include <boost/multiprecision/cpp_int.hpp>
using boost::multiprecision::cpp_int;  // https://www.geeksforgeeks.org/factorial-large-number-using-boost-multiprecision-library/
using namespace std;


 // } Driver Code Ends
//User function template for C++


class Solution
{
    public:
    //Function to find the nth catalan number.
    cpp_int findCatalan(int n) 
    {
        /*
        vector<cpp_int> fac(2*n+1, 0);
        fac[0] = fac[1] = 1;
        for(int i=2; i<=2*n; i++)
            fac[i] = fac[i-1]*i;
        
        cpp_int ans = fac[2*n]/(fac[n+1] * fac[n]);
        return ans;
        */
        
        // if(n<=1)
        //     return 1;
        
        // cpp_int res=0;
        // for(int i=0; i<n; i++)
        // {
        //     res+= findCatalan(i)*findCatalan(n-1-i);
        // }
        
        // return res;
        cpp_int cat[n+1];
        /*
        for(int i=0; i<=n; i++)
            cat[i] = -1;
        // cat[0] = cat[1] = 1;
        return solve(n, cat);
        */
        
        cat[0] = cat[1] = 1;
        for(int i=2; i<=n ; i++)
        {
            cat[i] = 0;
            for(int j=0; j<i; j++)
                cat[i] += cat[j]*cat[i-j-1];
        }
        
        return cat[n];
    }
    
    cpp_int solve(int n, cpp_int *cat) 
    {
        if(n<=1)
            return cat[n]=1;
        
        if(cat[n] != -1)
            return cat[n];
            
        cpp_int res=0;
        for(int i=0; i<n; i++)
        {
            res+= solve(i, cat)*solve(n-1-i, cat);
        }
        
        return cat[n]=res;
    }
};

// { Driver Code Starts.

int main() 
{
    //taking count of testcases
	int t;
	cin>>t;
	while(t--) {
	    
	    //taking nth number
	    int n;
	    cin>>n;
	    Solution obj;
	    //calling function findCatalan function
	    cout<< obj.findCatalan(n) <<"\n";    
	}
	return 0;
}  // } Driver Code Ends