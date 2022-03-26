/*https://codeforces.com/problemset/problem/32/B*/

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Borze
{
	public static void main(String[] args)throws IOException
	{
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		String input = bufferedReader.readLine();
		StringBuffer result = new StringBuffer("");
		int start = 0;
		while (start < input.length())
		{
			//System.out.println(start+" "+(start+1)+" "+input.length());
			if (input.charAt(start) == '.' && (start+1 >= input.length() || input.charAt(start+1) == '.'))
			{
				result.append("0");
				++start;
			}
			else if (input.charAt(start) == '.' && input.charAt(start+1) == '-')
			{
				result.append("0");
				++start;
			}
			else if (input.charAt(start) == '-' && input.charAt(start+1) == '.')
			{
				result.append("1");
				start += 2;
			}
			else if (input.charAt(start) == '-' && input.charAt(start+1) == '-')
			{
				result.append("2");
				start += 2;
			}
		}
		System.out.println(result.toString());
	}
}