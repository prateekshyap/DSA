/*https://practice.geeksforgeeks.org/problems/nearly-sorted-algorithm/0*/

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
public static void main (String[] args) throws IOException
{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int cases = Integer.parseInt(br.readLine());
    String[] tokens;
    int n, x;
    int[] arr;
    int i, j, pick, loop;
    for (int ii = 0; ii < cases; ++ii)
    {
    	tokens = br.readLine().trim().split(" +");
        n = Integer.parseInt(tokens[0]);
        x = Integer.parseInt(tokens[1]);
        arr = new int[n];
        tokens = br.readLine().trim().split(" +");
        for (i = 0; i < n; ++i)
        	arr[i] = Integer.parseInt(tokens[i]);
        
        for (i = 1; i < n; ++i)
        {
            pick = arr[i];
            j = i-1;
            loop = x;
            while (j >= 0 && arr[j] > pick && loop-- > 0)
            {
                arr[j+1] = arr[j];
                --j;
            }
            arr[j+1] = pick;
        }
        
        for (i = 0; i < n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
}
}