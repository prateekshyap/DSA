/*https://codeforces.com/problemset/problem/1559/B*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class MochaAndRedAndBlue
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int tests = Integer.parseInt(reader.readLine());
		int n, i;
		char[] rowChars;
		boolean isLetterFound = false;
		while (tests-- > 0)
		{
			n = Integer.parseInt(reader.readLine());
			rowChars = reader.readLine().toCharArray();
			isLetterFound = false;
			for (i = 0; i < n; ++i)
				if (rowChars[i] == 'B' || rowChars[i] == 'R')
				{
					isLetterFound = true;
					break;
				}
			if (!isLetterFound) rowChars[0] = 'B';
			for (i = 1; i < n; ++i)
			{
				if (rowChars[i] == '?')
				{
					if (rowChars[i-1] == 'R') rowChars[i] = 'B';
					else if (rowChars[i-1] == 'B') rowChars[i] = 'R';
				}
			}
			for (i = n-2; i >= 0; --i)
			{
				if (rowChars[i] == '?')
				{
					if (rowChars[i+1] == 'R') rowChars[i] = 'B';
					else if (rowChars[i+1] == 'B') rowChars[i] = 'R';
				}
			}
			for (i = 0; i < n; ++i)
				System.out.print(rowChars[i]);
			System.out.println();
		}
	}
}