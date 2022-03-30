/*https://codeforces.com/problemset/problem/978/B*/

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class FileName
{
	public static void main(String[] args)throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		String str = reader.readLine();
		int charCount = 0, xCount = 0;
		for (int i = 0; i < n; ++i)
		{
			if (str.charAt(i) == 'x') ++xCount;
			else
			{
				charCount += xCount >= 3 ? (xCount-2) : 0;
				xCount = 0;
			}
		}
		charCount += xCount >= 3 ? (xCount-2) : 0;
		System.out.println(charCount);
	}
}