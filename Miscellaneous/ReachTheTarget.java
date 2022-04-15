/*https://practice.geeksforgeeks.org/problems/reach-the-target/0*/

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
    int a, b, c, d;
    for (int ii = 0; ii < cases; ++ii)
    {
        tokens = br.readLine().trim().split(" +");
        a = Integer.parseInt(tokens[0]);
        b = Integer.parseInt(tokens[1]);
        c = Integer.parseInt(tokens[2]);
        d = Integer.parseInt(tokens[3]);
        if ((c-a)%b == 0)
        {
            d -= ((c-a)/b);
            if (d >= 0 && d%2 == 0)
                System.out.println("yes");
            else
                System.out.println("no");
        }
        else
            System.out.println("no");
    }
}
}