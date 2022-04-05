/*https://codeforces.com/problemset/problem/1296/B*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class FoodBuying
{
	public static void main(String[] args)throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int s, temp;
		long result = 0;
		while (n-- > 0)
		{
			result = 0;
			s = Integer.parseInt(reader.readLine());
			if (s < 10) result = s;
			else if (s == 10) result = 11;
			else
			{
				while (s > 10)
				{
					result += (s/10)*10;
					temp = s-((s/10)*10);
					temp += s/10;
					s = temp;
				}
				if (s == 10) result += 11;
				else result += s;
			}
			System.out.println(result);
		}
	}
}