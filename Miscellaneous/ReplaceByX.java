/*https://practice.geeksforgeeks.org/problems/replace-by-x/0*/

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
public static void main (String[] args) throws IOException
{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int cases = Integer.parseInt(br.readLine());
    String s = "", t = "", regEx = "";
    for (int ii = 0; ii < cases; ++ii)
    {
    	s = br.readLine();
    	t = br.readLine();
    	regEx = "("+t+")+";
    	s = s.replaceAll(regEx,"X");
    	System.out.println(s);
    }
}
}