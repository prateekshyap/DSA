/*https://codeforces.com/problemset/problem/339/A*/

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class HelpfulMaths
{
	public static void main(String[] args)throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tokens = br.readLine().trim().split("[+]");
		StringBuilder result = new StringBuilder("");
		int one = 0, two = 0, three = 0;
		for (int i = 0; i < tokens.length; ++i)
		{
			if (tokens[i].equals("1")) ++one;
			else if (tokens[i].equals("2")) ++two;
			else ++three;
		}
		for (int i = 1; i <= one; ++i)
			result.append("1+");
		for (int i = 1; i <= two; ++i)
			result.append("2+");
		for (int i = 1; i <= three; ++i)
			result.append("3+");
		System.out.println(result.substring(0,result.length()-1));
	}
}