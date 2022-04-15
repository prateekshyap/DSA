/*
		https://practice.geeksforgeeks.org/problems/find-median-in-a-stream-1587115620/1#.
		https://leetcode.com/problems/find-median-from-data-stream/
		295. Find Median from Data Stream

*/
//LC
class MedianFinder {
public:
    priority_queue<int> mxh;
    priority_queue<int, vector<int>, greater<int>> mih;
    
    MedianFinder() {
        
    }
    
    void addNum(int x) {
        
        if(mxh.empty() || x < mxh.top())
            mxh.push(x);
        else
            mih.push(x);
        
        // balance
        if(mxh.size() == mih.size()+2)
        {
            mih.push(mxh.top());
            mxh.pop();
        }
        else if(mxh.size()+2 == mih.size())
        {
            mxh.push(mih.top());
            mih.pop();
        }
        
    }// add num
    
    
    double findMedian() {
        if(mxh.size() == mih.size())
         return (mxh.top()+mih.top())/2.0;
        else if(mxh.size() > mih.size())
         return mxh.top();
        else
         return mih.top();
    }
};

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder* obj = new MedianFinder();
 * obj->addNum(num);
 * double param_2 = obj->findMedian();
 */

// GFG
// { Driver Code Starts
#include <bits/stdc++.h>
using namespace std;



 // } Driver Code Ends
class Solution
{
    public:
    
    priority_queue<int> mxh;
    priority_queue<int, vector<int>, greater<int>> mih;
   
    //Function to insert heap.
    void insertHeap(int &x)
    {
        // USing insertion sort
        // arr.push_back(x);
        // return insertionSort(x);
        
        if(mxh.empty() || x < mxh.top())
            mxh.push(x);
        else
            mih.push(x);
        
        balanceHeaps();
        
    }// insert Heap
    
    //Function to balance heaps.
    void balanceHeaps()
    {
        if(mxh.size() == mih.size()+2)
        {
            mih.push(mxh.top());
            mxh.pop();
        }
        else if(mxh.size()+2 == mih.size())
        {
            mxh.push(mih.top());
            mih.pop();
        }
    }
    
    //Function to return Median.
    double getMedian()
    {
        if(mxh.size() == mih.size())
         return (mxh.top()+mih.top())/2;
        else if(mxh.size() > mih.size())
         return mxh.top();
        else
         return mih.top();
         
    }
    
    // USING INSERTION SORT ==> TLE
     vector<int> arr; //
    void insertionSort(int &x)
    {
        int n=arr.size()-1;
        int new_ele = arr[n];
        int j = n-1;
        
        while(j>=0 && new_ele < arr[j])
        {
            arr[j+1] = arr[j];
            j--;
        }
        arr[j+1] = new_ele;
    }// insertionSort
    
    double getMedianInsertionSort()
    {
         // USING INSERTION SORT
         int n = arr.size();
        if(n==1) return arr[0];
        else
        {
            if(n % 2)
            {
                return arr[n/2];
            }
            else
            {
                return (arr[n/2-1]+arr[n/2])/2;
            }
        }
    }
};


// { Driver Code Starts.

int main()
{
    int n, x;
    int t;
    cin>>t;
    while(t--)
    {
    	Solution ob;
    	cin >> n;
    	for(int i = 1;i<= n; ++i)
    	{
    		cin >> x;
    		ob.insertHeap(x);
    	    cout << floor(ob.getMedian()) << endl;
    	}
    }
	return 0;
}  // } Driver Code Ends