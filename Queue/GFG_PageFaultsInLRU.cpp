/*
https://practice.geeksforgeeks.org/problems/page-faults-in-lru5603/1#
Page Faults in LRU 
*/

// { Driver Code Starts
// Initial Template for C++



#include <bits/stdc++.h>
using namespace std;

 // } Driver Code Ends
// User function Template for C++

class LRUCache {
public:
    
    list<pair<int,int>> cache;
    unordered_map<int, list<pair<int,int>>::iterator> cacheMap;
    int capacity_;
    
    LRUCache(int capacity) : capacity_(capacity){
        // capacity_ = capacity;        
    }
    
    // int get(int key) 
    // {
    //     if(cacheMap.find(key) == cacheMap.end())
    //         return -1;
        
    //     cache.splice(cache.begin(), cache, cacheMap[key]); // transfer to front
    //     return cacheMap[key]->second; // return its value

    // }//
    
    int put(int key, int value)
    {
        
        if(cacheMap.find(key) != cacheMap.end())
        {
            cache.splice(cache.begin(), cache, cacheMap[key]);
            cacheMap[key]->second = value;
            return 0;
        }
        if(cache.size() ==  capacity_)
        {
            cacheMap.erase(cache.back().first);
            cache.pop_back();
        }
        cache.push_front({key, value});
        cacheMap[key] = cache.begin();
        return 1;
    }//
};

class Solution{
public:
    int pageFaults(int N, int C, int pages[]){
        LRUCache lru = LRUCache(C);
        int faults=0;
        
        for(int p=0; p<N; p++)
        {
            faults += lru.put(pages[p], pages[p]);
        }
        
        return faults;
    }
};

// { Driver Code Starts.

int main(){
    int t;
    cin>>t;
    while(t--){
        int N, C;
        cin>>N;
        int pages[N];
        for(int i = 0;i < N;i++)
            cin>>pages[i];
        cin>>C;
        
        Solution ob;
        cout<<ob.pageFaults(N, C, pages)<<"\n";
    }
    return 0;
}  // } Driver Code Ends