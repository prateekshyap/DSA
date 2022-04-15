/*https://practice.geeksforgeeks.org/problems/cosmic-number/0*/

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
public static void main (String[] args) throws IOException
{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int cases = Integer.parseInt(br.readLine());
    int n, nCopy;
    StringBuffer result = new StringBuffer("");
    for (int ii = 0; ii < cases; ++ii)
    {
    	n = Integer.parseInt(br.readLine());
    	nCopy = n;
    	result = new StringBuffer("");


	    while (nCopy > 9)
	    {
    	    result.append("9");
    	    nCopy -= 9;
    	}
    	if (nCopy != 0) result.append(Integer.toString(nCopy));
    	result.reverse();

    	if (result.length() == 0)
    	    result.append("0");
    	else
    	{
    	    while (n-- > 0) result.append("0");
    	}
    	System.out.println(result);
    }
}
}