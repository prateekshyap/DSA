
/*
https://practice.geeksforgeeks.org/problems/maximum-repeating-number4858/1
Most frequent element in an array

*/
#include <iostream>
#include <algorithm>
#include <unordered_set>
using namespace std;
class Solution 
{
public:
    int mostFrequent(int arr[], int n)
    {
        int res=-1, freq=1, old_freq=0, i ,j;
        for( i=0; i<n; i++)
        {
		  freq =0;
           for( j=1; j<n; j++)
           {
               if(arr[i]==arr[j])
                freq++;
           }
           if(freq > old_freq)
           {
               old_freq = freq;
               res = arr[i];
           }
        }
        
        return res;
    }
	
	int mostFrequentSorted(int arr[], int n)
    {
        sort(arr, arr+n);
        int res=-1, freq=1, old_freq=0, i ,j;
        for( i=1; i<n; i++)
        {
           if (arr[i] == arr[i-1])
            freq++;
           else 
           {
               if(freq > old_freq)
               {    old_freq = freq;
                   res = arr[i-1];
               }
               freq=1;
           }
        }
        //last element is frequent 
        if(freq > old_freq)
           {    old_freq = freq;
               res = arr[i-1];
           }
        return res;
    }
   
   int mostFrequentUnorderedMap(int arr[], int n)
    {
       unordered_map<int,int> um;
       int res =-1, freq=0;
       for(int i=0; i<n; i++)
       {
           um[arr[i]]++;
       }
       //find max freq;
       for(auto it: um)
       {
           if(freq < it.second)
           {
               res = it.first;
               freq = it.second;
           }
       }
       return res;
    }
};

// Driver program to test above function
int main()
{
   Solution ob;
    int arr[] = { 1, 5, 2, 1, 3, 2, 1 };
     int n = sizeof(arr) / sizeof(arr[0]);
    cout << ob.mostFrequentUnorderedMap(arr, n)<<"\n";
    int arr1[] = {1, 3, 2, 1, 4, 1, 5,5,5,5,5};
     n = sizeof(arr1) / sizeof(arr1[0]);
    cout << ob.mostFrequentUnorderedMap(arr1, n)<<"\n";;
    int arr2[] = {10, 20, 10, 20, 30, 20, 20};
     n = sizeof(arr2) / sizeof(arr2[0]);
    cout << ob.mostFrequentUnorderedMap(arr2, n)<<"\n";;
    return 0;
}
