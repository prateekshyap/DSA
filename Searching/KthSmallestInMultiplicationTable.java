/*https://leetcode.com/problems/kth-smallest-number-in-multiplication-table/*/

/*Inefficient PQ implementation*/
class Data implements Comparable<Data>
{
    int row, col;
    int product;
    Data(int r, int c)
    {
        row = r;
        col = c;
        product = row*col;
    }
    @Override
    public int compareTo(Data d)
    {
        return this.product-d.product;
    }
}

class Solution
{
    public int findKthNumber(int m, int n, int k)
    {
        PriorityQueue<Data> minHeap = new PriorityQueue<Data>();
        int result = -1;
        for (int i = 1; i <= m; ++i)
            minHeap.add(new Data(i,1));
        while (k-- > 0)
        {
            Data curr = minHeap.poll();
            if (curr.col < n)
                minHeap.add(new Data(curr.row,curr.col+1));
            result = curr.product;
        }
        return result;
    }
}

/*Efficient Binary Search Solution*/
class Solution {
    
    private int fun(int m, int n, int x, int k)
    {
        //count will be storing the total numbers that occur before x including x.
        int count = 0;
        
        //we will be checking each row.
        for (int i = 1; i <= m; ++i)
        {
            //Obviously if count becomes greater than k then we will have to break beacause we will have to look for smaller candidate.
            if(count > k) break;
            
            //Simple maths : If out x is grater than the last element in that row so obviously no. of elements less than or equal to x wil be n or otherwise it will be  x/i.
            int ct = Math.min(n, x/i);
            
            count += ct;
        }
        
        //at last we return the count.
        return count;
    }
    
    public int findKthNumber(int m, int n, int k) {
        
        int low, high;
        
        //Min and Max possible will be 1 and m*n respectively.
        low = 1;
        high = m*n;
        
        //kth position actually means that exactly k-1 elements occur before it.(obviously in sorted array) or we can say if we include the kth element also then exactly k elements occur before it.
        
        //Simple Binary Searching from the possible candidates for the kth position.
        while(low < high)
        {
            //mid can be a possible candidate.
            int mid = (low+high)/2;
            
            //fun function returns how many numbers are less than mid including mid.
            
            //if it is greater than or equal then we check for a smaller candidate. Or else we check for bigger candidate.
            if (fun(m, n, mid, k) >= k) high = mid;
            else low = mid+1;
        }
        
        
        return high;
    }
}