/*
https://practice.geeksforgeeks.org/problems/most-frequent-word-in-an-array-of-strings3528/1#
Most frequent word in an array of strings

*/

// { Driver Code Starts
// Initial template for C++

#include <bits/stdc++.h>
using namespace std;

 // } Driver Code Ends
// User function template for C++

class Solution
{
    public:
    //Function to find most frequent word in an array of strings.
    string mostFrequentWord(string arr[], int n) 
    {
        // code here
        unordered_map<string, int> freq;    // store frequency of each word
        unordered_map<string, int> order;  // store arrving order of each string
        
        int maxFreq=INT_MIN;
        string maxString = "";
        
        for(int i=0; i<n; i++)
        {
            int f = freq[arr[i]]++;
            if(order.count(arr[i]) == 0) //returns the number of elements matching specific key
                order[arr[i]] = i;
              
            // if frequency of current string is greater than maxFreq OR  
            // if they have same freq then maximize according to order of arrival acc to question
            if(f > maxFreq || maxFreq == f && i > order[maxString])
            {
                maxFreq = f;
                maxString = arr[i];
            }
            
        }
        return maxString;
    } //end
};

// { Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        int n;
        cin >> n;

        string arr[n];
        for (int i = 0; i < n; i++) cin >> arr[i];
        Solution obj;
        cout << obj.mostFrequentWord(arr, n) << endl;
    }
    return 0;
}
  // } Driver Code Ends