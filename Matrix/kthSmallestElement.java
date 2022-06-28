/*https://practice.geeksforgeeks.org/problems/kth-element-in-matrix/1*/
/*https://binarysearch.com/problems/Matrix-Search*/

class Data implements Comparable<Data>
{
    int row;
    int col;
    int elem;
    Data(int row, int col, int elem)
    {
        this.row = row;
        this.col = col;
        this.elem = elem;
    }
    
    //smaller element is returned
    @Override
    public int compareTo(Data d)
    {
        return this.elem-d.elem;
    }
}

class Solution
{
	public static int kthSmallest(int[][]mat,int n,int k)
	{
        PriorityQueue<Data> minHeap = new PriorityQueue<Data>();
        
        //add the first element of each row to the min heap
        for (int i = 0; i < n; ++i)
            minHeap.add(new Data(i,0,mat[i][0]));

        //remove k-1 elements or till heap exhausts whichever is earlier
        while (k > 1 && !minHeap.isEmpty())
        {
            Data polled = minHeap.poll();

            //if the element is not the last element in that row, add the next element to min heap
            if (polled.col != n-1)
                minHeap.add(new Data(polled.row,polled.col+1,mat[polled.row][polled.col+1]));
            --k;
        }

        //if heap is empty return -1 else return the next removed element
        return minHeap.isEmpty() ? -1 : minHeap.poll().elem;
    }
}

import java.util.*;

class Data implements Comparable<Data>
{
    int r, c, val;
    Data(int r, int c, int val)
    {
        this.r = r;
        this.c = c;
        //this.row = row;
        this.val = val;
    }

    @Override
    public int compareTo(Data d)
    {
        return this.val-d.val;
    }
}

class Solution {
    public int solve(int[][] matrix, int k) {
        PriorityQueue<Data> heap = new PriorityQueue<Data>();
        int m = matrix.length, n = matrix[0].length, i;
        for (i = 0; i < m; ++i)
        {
            heap.add(new Data(i,0,matrix[i][0]));
        }
        Data d = new Data(0,0,0);
        while (k-- >= 0)
        {
            d = heap.poll();
            if (d.c+1 < n) heap.add(new Data(d.r,d.c+1,matrix[d.r][d.c+1]));
        }
        return d.val;
    }
}

import java.util.*;

class Solution {
    public int solve(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length, low = matrix[0][0], high = matrix[m-1][n-1], i, j, count, mid;
        while (low < high)
        {
            mid = low+((high-low)>>1);
            count = 0;
            for (i = 0; i < m; ++i)
            {
                j = n-1;
                while (j >= 0 && matrix[i][j] > mid) --j;
                count += j+1;
            }
            if (count < k+1) low = mid+1;
            else high = mid;
        }
        return low;
    }
}