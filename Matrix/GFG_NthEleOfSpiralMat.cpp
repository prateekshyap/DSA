/*
https://practice.geeksforgeeks.org/problems/find-nth-element-of-spiral-matrix/1#
Find nth element of spiral matrix 
*/

// { Driver Code Starts
#include<bits/stdc++.h>
using namespace std;
#define MAX 1000
int findK(int [MAX][MAX],int ,int ,int );
int main()
{
    int T;
    cin>>T;
  
    while(T--)
    {
        int n,m;
        int k=0;
        //cin>>k;
        cin>>n>>m>>k;
        int a[MAX][MAX];
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                cin>>a[i][j];
            }
        }
        cout<<findK(a,n,m,k)<<endl;
        
       
    }
}// } Driver Code Ends


/*You are required to complete this method*/
int findK_1(int A[MAX][MAX], int n, int m, int k)
{
        int ans;
        int left = 0, right = m-1;
        int top = 0, bottom = n-1;
        int r=0, c=0, itr=1;
        int direction = 0;
        
        while(left <= right && top <= bottom)
        {
            if(direction == 0)
            {
                for(c=left; c<=right; c++, itr++ )
                    if(itr == k) return A[top][c];
                top++;
            }
            else if(direction == 1)
            {
                for(r=top; r<=bottom; r++, itr++)
                    if(itr == k)  return A[r][right] ;
                right--;
            }
            else if(direction == 2)
            {
                for(c=right; c>=left; c--, itr++ )
                    if(itr == k) return A[bottom][c] ;
                bottom--;
            }
            else if(direction == 3)
            {
                for(r=bottom; r>=top; r--, itr++)
                    if(itr == k) return A[r][left] ;
                left++;
            }
            
            direction = (direction+1)%4;
        }
        
        
        return ans;
}

int findK(int A[MAX][MAX], int n, int m, int k)
{
        int mat[n*m];
        int ans;
        int left = 0, right = m-1;
        int top = 0, bottom = n-1;
        int r=0, c=0, ind=0;
        int direction = 0;
        
        while(left <= right && top <= bottom)
        {
            if(direction == 0)
            {
                for(c=left; c<=right; c++ )
                    mat[ind++] = A[top][c];
                top++;
            }
            else if(direction == 1)
            {
                for(r=top; r<=bottom; r++)
                    mat[ind++] = A[r][right] ;
                right--;
            }
            else if(direction == 2)
            {
                for(c=right; c>=left; c-- )
                    mat[ind++] = A[bottom][c] ;
                bottom--;
            }
            else if(direction == 3)
            {
                for(r=bottom; r>=top; r--)
                    mat[ind++] = A[r][left] ;
                left++;
            }
            
            direction = (direction+1)%4;
        }
        
        
        return mat[k-1];
}

