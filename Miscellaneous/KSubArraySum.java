/*https://practice.geeksforgeeks.org/problems/k-subarray-sum/0*/

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
public static void main (String[] args) throws IOException
{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int cases = Integer.parseInt(br.readLine());
    int n, k, m, mCopy, i, j, sum;
    int[] arr, result;
    PriorityQueue<Integer> minHeap;
    for (int ii = 0; ii < cases; ++ii)
    {
    	String[] tokens = br.readLine().trim().split(" +");
        n = Integer.parseInt(tokens[0]);
        k = Integer.parseInt(tokens[1]);
        m = Integer.parseInt(tokens[2]);
        arr = new int[n];
        tokens = br.readLine().trim().split(" +");
        for (i = 0; i < n; ++i)
        	arr[i] = Integer.parseInt(tokens[i]);
        
        sum = 0;
        mCopy = m;
        minHeap = new PriorityQueue<Integer>();
        for (i = 0; i < k; ++i)
            sum += arr[i];
        minHeap.add(sum); --m;
        for (i = k; i < n; ++i)
        {
            sum -= arr[i-k];
            sum += arr[i];
            if (m > 0)
            {
                minHeap.add(sum);
                --m;
            }
            else
            {
                if ((Integer)minHeap.peek() < sum)
                {
                    minHeap.poll();
                    minHeap.add(sum);
                }
            }
        }
        result = new int[mCopy];
        for (i = mCopy-1; i >= 0; --i)
            result[i] = (Integer)minHeap.poll();
        for (i = 0; i < mCopy; ++i)
            System.out.print(result[i]+" ");
        System.out.println();
    }
}
}