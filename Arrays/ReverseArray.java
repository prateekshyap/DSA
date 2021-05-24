/*https://practice.geeksforgeeks.org/problems/reverse-an-array/0*/

import java.lang.*;
import java.io.*;
class GFG
{
public static void main (String[] args) throws IOException
{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int cases = Integer.parseInt(br.readLine());
    for (int t = 0; t < cases; ++t)
    {
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] tokens = br.readLine().trim().split(" +");
        for (int i = 0; i < n; ++i)
        	arr[i] = Integer.parseInt(tokens[i]);
        	
        //reverse
        for (int i = 0, j = n-1; i < j; ++i, --j)
        {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        
        //print
        for (int i = 0; i < n; ++i)
        	System.out.print(arr[i]+" ");
        System.out.println();
    }
}
}