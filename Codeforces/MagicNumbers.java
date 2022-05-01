/*https://codeforces.com/problemset/problem/320/A*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class MagicNumbers
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String str = reader.readLine();
		boolean result = true;
		int oneCounter = 0, fourCounter = 0;
		for (int i = 0; i < str.length(); ++i)
		{
			if (str.charAt(i) == '1')
			{
				fourCounter = 0;
				++oneCounter;
			}
			else if (str.charAt(i) == '4')
			{
				if (oneCounter > 0) oneCounter = 0;
				else if (oneCounter == 0 && fourCounter == 0)
				{
					result = false;
					break;
				}
				if (fourCounter == 2)
				{
					result = false;
					break;
				}
				++fourCounter;
			}
			else
			{
				result = false;
				break;
			}
		}
		System.out.println(result ? "YES" : "NO");
	}
}