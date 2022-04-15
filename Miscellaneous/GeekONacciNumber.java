/*https://practice.geeksforgeeks.org/problems/geek-onacci-number/0*/

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
    int a, b, c, n, temp;
    for (int ii = 0; ii < cases; ++ii)
    {
    	tokens = br.readLine().trim().split(" +");
        a = Integer.parseInt(tokens[0]);
        b = Integer.parseInt(tokens[1]);
        c = Integer.parseInt(tokens[2]);
        n = Integer.parseInt(tokens[3]);
        n -= 3;
        while (n-- > 0)
        {
            temp = a+b+c;
            a = b;
            b = c;
            c = temp;
        }
        System.out.println(c);
    }
}
}