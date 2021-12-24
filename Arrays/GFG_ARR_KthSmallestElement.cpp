/* https://practice.geeksforgeeks.org/problems/kth-smallest-element5635/1#
 * Kth smallest element
 * Given an array arr[] and an integer K where K is smaller than size of array,
 * the task is to find the Kth smallest element in the given array.
 * It is given that all array elements are distinct.
 */

// { Driver Code Starts
//Initial function template for C++

#include<bits/stdc++.h>
using namespace std;

// } Driver Code Ends
//User function template for C++

class Solution{
public:
    // arr : given array
    // l : starting index of the array i.e 0
    // r : ending index of the array i.e size-1
    // k : find kth smallest element and return using this function
    int kthSmallest(int arr[], int l, int r, int k) {
        // k is already within range no need to check 1 <= K <= N
    /*************** USING SORTING *****************/
        //sort(arr, arr+r+1); //
        // return arr[k-1];
        /*
         * void sort (RandomAccessIterator first, RandomAccessIterator last, Compare comp);
         * The elements are compared using operator< for the first version, and comp for the second.
         * Equivalent elements are not guaranteed to keep their original relative order
         */


        /*************** USING PRIORITY QUEUE *****************/
        // Minimum Priority Queue

        priority_queue <int, vector<int>, greater<int>> min_heap(arr+l, arr + r+1) ;

        for(int i = 1; i<k; i++)
            min_heap.pop();

        return min_heap.top();

        // Maximum Priority Queue
        priority_queue <int> max_heap;
        for(int i =l ; i<=r ; i++){
            max_heap.push(arr[i]);
            if(max_heap.size()>k)
                max_heap.pop();
        }
        return max_heap.top();
    }
};

// { Driver Code Starts.

int main()
{
    int test_case;
    cin>>test_case;
    while(test_case--)
    {
        int number_of_elements;
        cin>>number_of_elements;
        int a[number_of_elements];

        for(int i=0;i<number_of_elements;i++)
            cin>>a[i];

        int k;
        cin>>k;
        Solution ob;
        cout<<ob.kthSmallest(a, 0, number_of_elements-1, k)<<endl;
    }
    return 0;
}  // } Driver Code Ends