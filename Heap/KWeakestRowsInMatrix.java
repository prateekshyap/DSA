/*https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/*/

class Info implements Comparable<Info>
{
    int noOfSoldiers;
    int rowNo;
    Info(int nos, int rno)
    {
        this.noOfSoldiers = nos;
        this.rowNo = rno;
    }
    public int compareTo(Info i)
    {
        if (this.noOfSoldiers < i.noOfSoldiers) return 1;
        if (this.noOfSoldiers > i.noOfSoldiers) return -1;
        if (this.rowNo < i.rowNo) return 1;
        return -1;
    }
}

class Solution {
    int r, c;
    int[][] mat;
    int low, high;
    public int[] kWeakestRows(int[][] mat, int k) {
        int i, j;
        r = mat.length;
        c = mat[0].length;

        this.mat = mat;
        int one = -1;

        PriorityQueue<Info> heap = new PriorityQueue<Info>();
        for (i = 0; i < k; ++i)
        {   
            low = 0;
            high = c-1;
            one = binarySearch(i);
            heap.add(new Info(one+1,i));
        }

        for (i = k; i < r; ++i)
        {
            low = 0;
            high = c-1;
            one = binarySearch(i);
            if (one+1 < heap.peek().noOfSoldiers || (one+1 == heap.peek().noOfSoldiers && i < heap.peek().rowNo))
            {
                heap.poll();
                heap.add(new Info(one+1,i));
            }
        }
        
        int[] result = new int[k];
        for (i = k-1; i >= 0; --i) result[i] = heap.poll().rowNo;
        return result;
    }
    public int binarySearch(int i)
    {
        int one = -1, mid;
        while (low <= high)
        {
            mid = low+((high-low)/2);
            if (mat[i][mid] == 1 && (mid == c-1 || mat[i][mid+1] == 0))
            {
                one = mid;
                break;
            }
            else if (mat[i][mid] == 1)
                low = mid+1;
            else
                high = mid-1;
        }
        return one;
    }
}