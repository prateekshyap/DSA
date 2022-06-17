/*
https://leetcode.com/problems/intersection-of-two-arrays-ii/
350. Intersection of Two Arrays II

*/
class Solution {
public:
    vector<int> intersect(vector<int>& nums1, vector<int>& nums2) {
         
        /*
         unordered_map<int, int> um;
        vector<int> ans;
        int min, max;
        vector <int>::iterator smaller, bigger;
        
        if(nums1.size() < nums2.size()){
            min= nums1.size();
            max= nums2.size();
            smaller = nums1.begin();
            bigger = nums2.begin();
        }else{
            min= max=nums2.size();
            max= nums1.size();
            smaller = nums2.begin();
            bigger = nums1.begin();
        }
        
        
        for(int i=0; i<min; i++)
            um[smaller[i]]++;
            // um.insert({smaller[i], true});
            
        for(int i=0; i<max; i++)
        {
            // if(um.find(bigger[i]) != um.end() && um[bigger[i]])
            if(um[bigger[i]])
            {
                ans.push_back(bigger[i]);
                 um[bigger[i]]--;
            }
            
        }
        */
        
         /*
        if(nums1.size()>nums2.size())
            intersect(nums2,nums1);
        
         unordered_map<int, int> um;
        vector<int> ans;
        
         for(int x: nums1)
            um[x]++;
        
         for(int y: nums2)
         {
            if(um[y])
            {
                ans.push_back(y);
                 um[y]--;
            }
         }
        
        
        return ans;
        */
        
        // /*
        
        sort(nums1.begin(), nums1.end());
        sort(nums2.begin(), nums2.end());
        
        int n1 = nums1.size(), n2 = nums2.size();
        
        int i1 = 0, i2 = 0;
        vector<int> ans;
        
        while(i1 < n1 && i2 < n2){
          
            if(nums1[i1] == nums2[i2]) {
                ans.push_back(nums1[i1]);
                i1++;
                i2++;
            }
            else if(nums1[i1] > nums2[i2]){
                i2++;
            }
            else{
                i1++;
            }
             
            // while(i1 > 0 && i1 < n1 && nums1[i1] == nums1[i1 - 1]) i1++;
            // while(i2 > 0 && i2 < n2 && nums2[i2] == nums2[i2 - 1]) i2++;
            
        }
        return ans;
        // */
    }
};

/*
https://leetcode.com/problems/intersection-of-two-arrays/
349. Intersection of Two Arrays
*/

class Solution {
public:
    vector<int> intersection(vector<int>& nums1, vector<int>& nums2) {
        /*
        unordered_map<int, bool> um;
        vector<int> ans;
        int min, max;
        vector <int>::iterator smaller, bigger;
        
        if(nums1.size() < nums2.size()){
            min= nums1.size();
            max= nums2.size();
            smaller = nums1.begin();
            bigger = nums2.begin();
        }else{
            min= max=nums2.size();
            max= nums1.size();
            smaller = nums2.begin();
            bigger = nums1.begin();
        }
        
        for(int i=0; i<min; i++)
            um.insert({smaller[i], true});
            
        for(int i=0; i<max; i++)
        {
            if(um.find(bigger[i]) != um.end() && um[bigger[i]])
            {
                ans.push_back(bigger[i]);
                um[bigger[i]] = false;
            }
        }
        
        
        return ans;
        */
        
        /*
        set<int> s1(nums1.begin(), nums1.end());
        set<int> s2(nums2.begin(), nums2.end());

        vector<int> v;

        for (auto x: s2) {
            if (s1.find(x) != s1.end())
                v.push_back(x);
        }

        return v;
        */
        
        sort(nums1.begin(), nums1.end());
        sort(nums2.begin(), nums2.end());
        
        int n1 = nums1.size(), n2 = nums2.size();
        
        int i1 = 0, i2 = 0;
        vector<int> ans;
        
        while(i1 < n1 && i2 < n2){
          
            if(nums1[i1] == nums2[i2]) {
                ans.push_back(nums1[i1]);
                i1++;
                i2++;
            }
            else if(nums1[i1] > nums2[i2]){
                i2++;
            }
            else{
                i1++;
            }
             
            while(i1 > 0 && i1 < n1 && nums1[i1] == nums1[i1 - 1]) i1++;
            while(i2 > 0 && i2 < n2 && nums2[i2] == nums2[i2 - 1]) i2++;
            
        }
        return ans;
    }
};


/*
https://practice.geeksforgeeks.org/problems/intersection-of-two-arrays2404/1#
Intersection of two arrays 
*/
// { Driver Code Starts
// Initial template for C++

#include <bits/stdc++.h>
using namespace std;

 // } Driver Code Ends
// User function template for C++

class Solution {
  public:
    // Function to return the count of the number of elements in
    // the intersection of two arrays.
    int NumberofElementsInIntersection1(int a[], int b[], int n, int m) {
        // Your code goes here
        unordered_map<int, bool> um;
        int count=0;
        
        if(n<m)
        {
            for(int i=0; i<n; i++)
                um.insert({a[i], true});
            
            for(int i=0; i<m; i++)
            {
                if(um.find(b[i]) != um.end() && um[b[i]])
                {
                    count++;
                    um[b[i]] = false;
                }
            }
               
        }
        else
        {
            for(int i=0; i<m; i++)
                um.insert({b[i], true});
            for(int i=0; i<n; i++)
            {
                if(um.find(a[i]) != um.end() && um[a[i]])
                {
                    count++;
                    um[a[i]] = false;
                }
            }
        }
        
        return count;
    }//
    
    int NumberofElementsInIntersection(int a[], int b[], int n, int m) {
        // Your code goes here
        unordered_map<int, bool> um;
        int count=0;
        int min, max, *smaller, *bigger;
        
        if(n<m){
            min= n;
            max= m;
            smaller = a;
            bigger = b;
        }else{
            min= m;
            max= n;
            smaller = b;
            bigger = a;
        }
        
        for(int i=0; i<min; i++)
            um.insert({smaller[i], true});
            
        for(int i=0; i<max; i++)
        {
            if(um.find(bigger[i]) != um.end() && um[bigger[i]])
            {
                count++;
                um[bigger[i]] = false;
            }
        }
        
        
        return count;
    }//
};

// { Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        int n, m;
        cin >> n >> m;
        int a[n], b[m];
        for (int i = 0; i < n; i++) cin >> a[i];

        for (int i = 0; i < m; i++) cin >> b[i];
        Solution ob;
        cout << ob.NumberofElementsInIntersection(a, b, n, m) << endl;
    }
    return 0;
}  // } Driver Code Ends