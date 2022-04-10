/*https://codeforces.com/problemset/problem/1374/B*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class MultiplyBy2DivideBy6
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int tests = Integer.parseInt(reader.readLine());
		double n;
		int steps;
		boolean isPossible;
		while (tests-- > 0)
		{
			n = Double.parseDouble(reader.readLine());
			steps = 0;
			isPossible = true;
			if (n == 1)
			{
				System.out.println("0");
				isPossible = false;
			}
			else if (n%3 != 0)
			{
				System.out.println("-1");
				isPossible = false;
			}
			else
			{
				while (n != 1)
				{
					while (n%6 == 0)
					{
						++steps;
						n /= 6;
					}
					if (n == 1)
					{
						break;
					}
					else if (n%3 != 0)
					{
						System.out.println("-1");
						isPossible = false;
						break;
					}
					n *= 2;
					++steps;
				}
			}
			if (isPossible)
				System.out.println(steps);
		}
	}
}