/*https://practice.geeksforgeeks.org/problems/row-with-max-1s0023/1*/

class Solution {
    int rowWithMax1s(int arr[][], int n, int m) {
        int minIndex = m;
        int row = -1;
        for (int i = 0; i < n; ++i)
        {
            //till the column value is 1 in ith row
            while (minIndex > 0 && arr[i][minIndex-1] != 0)
            {
                //keep updating row and leftmost index
                row = i;
                --minIndex;
            }
            if (minIndex == 0) return row;
        }
        return row;
    }
}

class Sol
{
    public static int maxOnes (int arr[][], int N, int M)
    {
        // your code here
        int minIndex = M;
        int row = -1, low = -1, high = -1, mid = -1;
        for (int i = 0; i < N; ++i)
        {
            if (minIndex == M || arr[i][minIndex] == 1)
            {
                low = 0;
                high = M-1;
                while (low <= high)
                {
                    mid = low+((high-low))/2;
                    if (arr[i][mid] == 1 && (mid == 0 || arr[i][mid-1] == 0)) break;
                    else if (arr[i][mid] == 1) high = mid-1;
                    else low = mid+1;
                }
                if (mid < minIndex)
                {
                    row = i;
                    minIndex = mid;
                }
            }
            if (minIndex == 0) return row;
        }
        return row;
    }
}