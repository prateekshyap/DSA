/* 
 	https://practice.geeksforgeeks.org/problems/max-sum-subarray-of-size-k5313/1
*/

 // } Driver Code Ends
class Solution{   
public:
    int maximumSumSubarray(int K, vector<int> &Arr , int N){
       // given K<=N already
       
       int k_sum = 0, cw_sum; // sum of first K size window
       for (int i=0; i<K; i++){
           k_sum += Arr[i];
       }
    //   compute sum by removing the first element of the last window 
    //   and adding the last element of the current window
        cw_sum = k_sum;
       for (int i=K; i<N; i++){
           cw_sum += Arr[i] - Arr[i-K];
          // k_sum = max(k_sum, cw_sum);    //0.03
           if(k_sum<cw_sum)             //0.02
                k_sum = cw_sum;
       }
       
        return k_sum;
    }
};

// { Driver Code Starts.
int main() 
{ 
    int t;
    cin>>t;
    while(t--)
    {
        int N,K;
        cin >> N >> K;;
        vector<int>Arr;
        for(int i=0;i<N;++i){
            int x;
            cin>>x;
            Arr.push_back(x);
        }
        Solution ob;
        cout << ob.maximumSumSubarray(K,Arr,N) << endl;
    }
    return 0; 
}   // } Driver Code Ends
