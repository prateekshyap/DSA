/*https://codeforces.com/problemset/problem/1462/C*/

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class UniqueNumber
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int tests = Integer.parseInt(reader.readLine()), n;
		StringBuffer buffer = new StringBuffer("");
		int digit = 9;
		while (tests-- > 0)
		{
			n = Integer.parseInt(reader.readLine());
			digit = 9;
			buffer = new StringBuffer("");
			if (n < 10) System.out.println(n);
			else if (n > 45) System.out.println("-1");
			else
			{
				while (n > digit)
				{
					buffer.append(digit);
					n -= (digit--);
				}
				buffer.append(n);
				buffer.reverse();
				System.out.println(buffer.toString());
			}
		}
	}
}