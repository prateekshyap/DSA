/*
https://practice.geeksforgeeks.org/problems/kth-element-in-matrix/1#
Kth element in Matrix 

https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/

*/
//LC
int binarySearch(vector<int> arr, int target){
        int low=0, high=arr.size()-1;
        while(low<=high){
            int mid=(low+high)>>1;
            if(arr[mid]<=target){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return low;
    }
    
    int kthSmallest(vector<vector<int>>& matrix, int k) {
          int n = matrix.size();
          int low = matrix[0][0];
          int high = matrix[n-1][n-1];
          int mid, count=0;
        
          while(low<=high)
          {
              mid = (low+high)>>1;
              count=0;
              for(int i=0; i<n; i++)
                  // count += (upper_bound(matrix[i].begin(), matrix[i].end(), mid) - matrix[i].begin());
                count += binarySearch(matrix[i], mid);
              
              if(count<k)
                  low = mid+1;
              else
                  high = mid-1;
          }

          return low;
    }

//GFG

// { Driver Code Starts
// kth largest element in a 2d array sorted row-wise and column-wise
#include<bits/stdc++.h>
using namespace std;
#define MAX 1000
int mat[MAX][MAX];
int kthSmallest(int mat[MAX][MAX], int n, int k);
// driver program to test above function
int main()
{
    int t;
    cin>>t;
    while(t--)
    {
        int n;
        cin>>n;
    
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                cin>>mat[i][j];
        int r;
        cin>>r;
        cout<<kthSmallest(mat,n,r)<<endl;
    }
     // cout << "7th smallest element is " << kthSmallest(mat, 4, 7);
      return 0;
}
// } Driver Code Ends



int kthSmallest1(int mat[MAX][MAX], int n, int k)
{
  //Your code here
  priority_queue<int> pq; // MAX HEAP
  
  for(int i=0; i<n; i++)
    for(int j=0; j<n; j++)
    {
        pq.emplace(mat[i][j]);
        if(pq.size()>k) pq.pop();
    }
    
    return pq.top();
}

int kthSmallest(int mat[MAX][MAX], int n, int k)
{
  int ans;
  priority_queue<vector<int>, vector<vector<int>>, greater<> > pq;
  vector<int> temp;
  
  for(int i=0; i<n; i++)
  {
    pq.push({mat[i][0], i, 0}); // first element of each row, row index, col index
  }
  
  for(int i=1; i<=k; i++)
  {
      temp = pq.top(); pq.pop();
      ans = temp[0];
      
      if(temp[2]+1<n)
        pq.push({mat[temp[1]][temp[2]+1], temp[1], temp[2]+1 });
  }
    
  return ans;int ans;
  priority_queue<vector<int>, vector<vector<int>>, greater<> > pq;
  vector<int> temp;
  
  for(int i=0; i<n; i++)
  {
    pq.push({mat[i][0], i, 0}); // first element of each row, row index, col index
  }
  
  for(int i=1; i<=k; i++)
  {
      temp = pq.top(); pq.pop();
      ans = temp[0];
      
      if(temp[2]+1<n)
        pq.push({mat[temp[1]][temp[2]+1], temp[1], temp[2]+1 });
  }
    
  return ans;
}