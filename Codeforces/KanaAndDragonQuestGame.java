/*https://codeforces.com/problemset/problem/1337/B*/

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class KanaAndDragonQuestGame
{
	public static void main(String[] args)throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int tests = Integer.parseInt(reader.readLine());
		String[] tokens;
		int x, n, m, xCopy, mCopy, nCopy;
		boolean result = false;
		while (tests-- > 0)
		{
			result = false;
			tokens = reader.readLine().trim().split(" +");
			x = Integer.parseInt(tokens[0]);
			n = Integer.parseInt(tokens[1]);
			m = Integer.parseInt(tokens[2]);
			xCopy = x; mCopy = m; nCopy = n;
			while (n > 0)
			{
				x = x/2+10;
				--n;
				if (x <= 0)
				{
					result = true;
					break;
				}
			}
			while (m > 0)
			{
				x = x-10;
				--m;
				if (x <= 0)
				{
					result = true;
					break;
				}
			}
			x = xCopy; m = mCopy; n = nCopy;
			while (m > 0)
			{
				x = x-10;
				--m;
				if (x <= 0)
				{
					result = true;
					break;
				}
			}
			while (n > 0)
			{
				x = x/2+10;
				--n;
				if (x <= 0)
				{
					result = true;
					break;
				}
			}
			if (result) System.out.println("YES");
			else System.out.println("NO");
		}
	}
}