/* https://practice.geeksforgeeks.org/problems/sort-an-array-of-0s-1s-and-2s4231/1#
 * Given an array of size N containing only 0s, 1s, and 2s; sort the array in ascending order.
 */

// { Driver Code Starts
#include<bits/stdc++.h>
using namespace std;



// } Driver Code Ends
class Solution
{
public:
    void sort012(int a[], int n)
    {

        //return sort(a,a+n);

        /****** DUTCH NATIONAL FLAG APPROACH https://users.monash.edu/~lloyd/tildeAlgDS/Sort/Flag/   ****/

        int low = 0;
        int high = n-1;
        int mid = 0;
        /*
            a[0..Lo-1] zeroes (red)
            a[Lo..Mid-1] ones (white)
            a[Mid..Hi] unknown
            a[Hi+1..N-1] twos (blue)
        */
        while(mid<=high){
            if(a[mid] == 0){
                swap(a[low], a[mid]);
                low++;
                mid++;
            }
            else if(a[mid] == 1){
                mid++;
            }
            else{
                swap(a[mid], a[high]);
                high--;
            }
        }

        /****** Using Count variable   ****/
        int i, cnt0 = 0, cnt1 = 0, cnt2 = 0;

        for (i = 0; i < n; i++) {
            switch (a[i]) {
                case 0:
                    cnt0++;
                    break;
                case 1:
                    cnt1++;
                    break;
                case 2:
                    cnt2++;
                    break;
            }
        }

        i = 0;
        // all the 0s
        while (cnt0 > 0) {
            a[i++] = 0;
            cnt0--;
        }
        // all the 1s
        while (cnt1 > 0) {
            a[i++] = 1;
            cnt1--;
        }
        // all the 2s
        while (cnt2 > 0) {
            a[i++] = 2;
            cnt2--;
        }

    }

};

// { Driver Code Starts.
int main() {

    int t;
    cin >> t;

    while(t--){
        int n;
        cin >>n;
        int a[n];
        for(int i=0;i<n;i++){
            cin >> a[i];
        }

        Solution ob;
        ob.sort012(a, n);

        for(int i=0;i<n;i++){
            cout << a[i]  << " ";
        }

        cout << endl;


    }
    return 0;
}

// } Driver Code Ends

