
/*
https://practice.geeksforgeeks.org/problems/distinct-absolute-array-elements4529/1
Count distinct elements in an array

*/
#include <iostream>
#include <algorithm>
#include <unordered_set>
using namespace std;
class Solution 
{
public:
    
    int countDistinct(int arr[], int n)
    {
        int res=1, i ,j;
        for( i=1; i<n; i++)
        {
           for( j=0; j<i; j++)
           {
               if(arr[i]==arr[j])
               break;
           }
           if(j==i)
           res++;
        }
        
        return res;
    }
	
	 int countDistinctSorted(int arr[], int n)
    {
        sort(arr, arr+n);
        int res=0, i ,j;
        for( i=0; i<n; i++)
        {
           
           while(i<n-1 && arr[i]==arr[i+1])
            i++;
            
           res++;
        }
        
        return res;
    }
	
	int countDistinctUnorderedSet(int arr[], int n)
    {
        unordered_set<int> s;
        int res=0, i ,j;
        
        for( i=0; i<n; i++)
        {
           
          if(s.find(arr[i]) == s.end())
          {
              s.insert(arr[i]);
              res++;
          }
        }
        
        return res;
    }
};

// Driver program to test above function
int main()
{
    Solution ob;
    int arr[] = { 12, 10, 9, 45, 2, 10, 10, 45 };
    int n = sizeof(arr) / sizeof(arr[0]);
    cout << ob.countDistinct(arr, n);
    return 0;
}
