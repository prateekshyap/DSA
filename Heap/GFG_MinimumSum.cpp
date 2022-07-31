/*
https://practice.geeksforgeeks.org/problems/minimum-sum4058/1/#
Minimum sum 
*/

// { Driver Code Starts
//Initial template for C++

#include <bits/stdc++.h>
using namespace std;

 // } Driver Code Ends
//User function template for C++

class Solution{   
public:
    string solve(int arr[], int n) {
        sort(arr, arr+n);
        
        string n1, n2;
        
        for(int i=0; i<n; i++)
        {
            if(arr[i] == 0) // TC 3 failed, bec of prefix zero
                continue;
            if(i%2==0)
                n1.push_back(arr[i]+'0');
            else
                n2.push_back(arr[i] + '0');
        }
        
        // cout<<n1<<" "<<n2<<endl;
        
        int i = n1.size()-1;
        int j = n2.size()-1;
        string ans;
        int sum=0, carry=0;
        while(i>=0 || j>=0)
        {
            sum = carry;
            if(i>=0)
                sum+= n1[i--]-'0';
            if(j>=0)
                sum+= n2[j--]-'0';
            ans += (sum%10)+'0';
            carry = sum/10;
        }
        
        if(carry)
            ans+= carry+'0';
        
        return string(ans.rbegin(), ans.rend());
    }
    
    // long long int range out of bound
    string solve_2(int arr[], int n) 
    {
        sort(arr, arr+n);
        
        long long int n1=0, n2=0;
        
        for(int i=0; i<n; i++)
        {
            if(arr[i] == 0) // TC 3 failed, bec of prefix zero
                continue;
            if(i%2==0)
                n1 = n1*10 + arr[i];
            else
                n2 = n2*10 + arr[i];
        }
        
        
        // int i = n1.size()-1;
        // int j = n2.size()-1;
        // string ans;
        // int sum=0, carry=0;
        // while(i>=0 || j>=0)
        // {
        //     sum = carry;
        //     if(i>=0)
        //         sum+= n1[i--]-'0';
        //     if(j>=0)
        //         sum+= n2[j--]-'0';
        //     ans += (sum%10)+'0';
        //     carry = sum/10;
        // }
        
        // if(carry)
        //     ans+= carry+'0';
        
        long long int ans = n1+n2;
        
        // cout<<n1<<" "<<n2<<" "<<ans<<endl;
        
        return to_string(ans);
    }
    
    string solve_TLE(int arr[], int n) {
        // sort(arr, arr+n);
        priority_queue<int, vector<int>, greater<>> pq(arr, arr+n);
        
        string n1, n2;
        
        bool swap = true;
        while(!pq.empty())
        {
            int digit = pq.top(); pq.pop();
            if(digit == 0) // TC 3 failed, bec of prefix zero
                continue;
            if(swap)
                n1.push_back(digit+'0');
            else
                n2.push_back(digit + '0');
            swap = !swap;
        }
        
        // cout<<n1<<" "<<n2<<endl;
        
        int i = n1.size()-1;
        int j = n2.size()-1;
        string ans;
        int sum=0, carry=0;
        while(i>=0 || j>=0)
        {
            sum = carry;
            if(i>=0)
                sum+= n1[i--]-'0';
            if(j>=0)
                sum+= n2[j--]-'0';
            ans += (sum%10)+'0';
            carry = sum/10;
        }
        
        if(carry)
            ans+= carry+'0';
        
        return string(ans.rbegin(), ans.rend());
    }
};

// { Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        int n;
        cin >> n;
        int arr[n];
        for (int i = 0; i < n; i++) {
            cin >> arr[i];
        }
        Solution ob;
        auto ans = ob.solve(arr, n);
        cout << ans << "\n";
    }
    return 0;
}  // } Driver Code Ends