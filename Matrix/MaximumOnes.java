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