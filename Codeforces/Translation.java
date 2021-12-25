/*https://codeforces.com/problemset/problem/41/A*/

import java.io.*;
public class Translation
{
	public static void main(String[] args)throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String t = br.readLine();
		if (s.length() != t.length())
			System.out.println("NO");
		else{
		int i = 0, j = t.length()-1;
		boolean flag = true;
		while (j >= 0 && i < s.length())
		{
			if (s.charAt(i) != t.charAt(j))
			{
				flag = false;
				break;
			}
			++i; --j;
		}
		System.out.println(flag ? "YES" : "NO");
		}
	}
}