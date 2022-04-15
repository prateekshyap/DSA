/*https://practice.geeksforgeeks.org/problems/geek-and-bridges/0*/

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
public static void main (String[] args) throws IOException
{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int cases = Integer.parseInt(br.readLine()), i, j;
    String str1, str2;
    String[] tokens;
    int[][] dp;
    for (int ii = 0; ii < cases; ++ii)
    {
    	tokens = br.readLine().trim().split(" +");
    	str1 = tokens[0];
    	str2 = tokens[1];
    	dp = new int[str1.length()+1][str2.length()+1];
    	for (i = 1; i <= str1.length(); ++i)
    	{
    	    for (j = 1; j <= str2.length(); ++j)
    	    {
    	        if (str1.charAt(i-1) == str2.charAt(j-1))
    	            dp[i][j] = dp[i-1][j-1]+1;
    	        else
    	            dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
    	    }
    	}
    	System.out.println(dp[str1.length()][str2.length()]);
    }
}
}