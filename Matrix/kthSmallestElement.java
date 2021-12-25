/*https://practice.geeksforgeeks.org/problems/kth-element-in-matrix/1*/

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