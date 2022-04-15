/*https://practice.geeksforgeeks.org/problems/geek-and-function-v/0*/

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
public static void main (String[] args) throws IOException
{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int cases = Integer.parseInt(br.readLine());
    int n, k, i;
    String[] tokens;
    for (int ii = 0; ii < cases; ++ii)
    {
    	tokens = br.readLine().trim().split(" +");
        n = Integer.parseInt(tokens[0]);
        k = Integer.parseInt(tokens[1]);
        while (k-- > 0 && n%10 > 0)
            n = n^(n%10);
        System.out.println(n);
    }
}
}