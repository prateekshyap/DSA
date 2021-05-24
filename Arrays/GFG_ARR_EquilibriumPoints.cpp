/* 
 	https://practice.geeksforgeeks.org/problems/equilibrium-point-1587115620/1
*/



 // } Driver Code Ends

class Solution{
    public:
    // Function to find equilibrium point in the array.
    // a: input array
    // n: size of array
    int equilibriumPoint(long long a[], int n) {
        
        if(n==1) return 1; // return index+1
        
        /*
        // using two extra array
        long long psumF[n]={0}; psumF[0]=a[0];
        long long psumB[n]={0}; psumB[n-1]=a[n-1];
        // Taking the prefixsum from front end array
            for (int i = 1; i < n; i++) {
                    psumF[i] = psumF[i - 1] + a[i];
            }
        // Taking the prefixsum from back end of array
            for (int i = n - 2; i >= 0; i--) {
                    psumB[i] = psumB[i + 1] + a[i];
            }
            
            for (int i = 0; i < n; i++) {
                if (psumF[i] == psumB[i]) {
                        return i+1;
                    }
                }
            for (int i = 0; i < n; i++) {
                if (psumF[i] == psumB[i]) {
                        return i+1;
                    }
                }
            return -1;
         */
         /*// using one extra array 0.62
         long long psumF[n]={0}; psumF[0]=a[0];
        // Taking the prefixsum from front end array
            for (int i = 1; i < n; i++) {
                    psumF[i] = psumF[i - 1] + a[i];
            }
            
            for (int i = 1; i < n; i++) {
                if (psumF[i-1] == psumF[n-1]-psumF[i]) {
                        return i+1;
                    }
                }
            return -1;
         */
         /*
         //0.34sec
         int tsum = 0, lsum=0; // total sum, left sum;
         //total sum of array
         for (int i = 0; i < n; ++i)
            tsum += a[i];
            
         for (int i = 0; i < n; ++i) {
                tsum -= a[i]; // tsum is now right sum for index i
         
                if (lsum == tsum)
                    return i+1;
         
                lsum += a[i];
         }
        return -1;
         */
         int tsum = 0, lsum=0; // total sum, left sum;
         //total sum of array
         for (int i = 0; i < n; ++i)
            tsum += a[i];
            
         for (int i = 0; i < n; ++i) {
               // tsum is now right sum for index i
                if ((2*lsum) == (tsum-a[i]) ) //x+LSum+RSum=Tsum
                    return i+1;
                if ( (2*lsum) > (tsum-a[i]) )
                    return -1;
                    
                lsum += a[i];
         }
        return -1;
         
    }

};

// { Driver Code Starts.


int main() {

    long long t;
    
    //taking testcases
    cin >> t;

    while (t--) {
        long long n;
        
        //taking input n
        cin >> n;
        long long a[n];

        //adding elements to the array
        for (long long i = 0; i < n; i++) {
            cin >> a[i];
        }
        
        Solution ob;

        //calling equilibriumPoint() function
        cout << ob.equilibriumPoint(a, n) << endl;
    }
    return 0;
}
  // } Driver Code Ends
