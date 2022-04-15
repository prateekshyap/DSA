/*https://practice.geeksforgeeks.org/problems/longest-subarray-with-atmost-k-even-elements/0*/

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
    int n, k, i, j, currEvenCount, maxLen;
    int[] arr;
    for (int ii = 0; ii < cases; ++ii)
    {
    	tokens = br.readLine().trim().split(" +");
        n = Integer.parseInt(tokens[0]);
        k = Integer.parseInt(tokens[1]);
        arr = new int[n];
        tokens = br.readLine().trim().split(" +");
        for (i = 0; i < n; ++i)
            arr[i] = Integer.parseInt(tokens[i]);
            
        i = 0;
        j = -1;
        currEvenCount = 0;
        maxLen = 0;
        while (j < n) //till we have more elements
        {
            ++j; //increment j
            if (j >= n) break; //if crossed bounds, break
            if (arr[j]%2 == 0 && currEvenCount < k) //if jth element is even and we can still add more even numbers
            {
                ++currEvenCount; //increment the even count
            }
            else if (arr[j]%2 == 0) //if jth element is even but we cannot add more even numbers, that means we cannot increase the window size anymore
            {
                while (arr[i]%2 != 0) ++i; //find out the earliest even number
                ++i; //remove it from the current window
            }
            /*This if else block makes sure that the number of even elements is bounded by k*/
            if (currEvenCount <= k && j-i+1 > maxLen) maxLen = j-i+1; //if even count is bounded by k, update the maximum window length
        }
        System.out.println(maxLen);
    }
}
}