/*https://codeforces.com/problemset/problem/1624/B*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class MakeAP
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int tests = Integer.parseInt(reader.readLine());
		String[] tokens;
		double a, b, c;
		while (tests-- > 0)
		{
			tokens = reader.readLine().trim().split(" +");
			a = Double.parseDouble(tokens[0]);
			b = Double.parseDouble(tokens[1]);
			c = Double.parseDouble(tokens[2]);
			if (a == c && b <= a && a%b == 0) System.out.println("YES");
			else if (a == c && b > a && (b+(b-a))%c == 0) System.out.println("YES");
			else if (a == c) System.out.println("NO");
			else if ((a >= c || c >= a) && b <= (a+c)/2 && ((a+c)/2)%b == 0) System.out.println("YES");
			else if ((c >= b) && a <= b-(c-b) && (b-(c-b))%a == 0) System.out.println("YES");
			else if ((b >= c) && a <= b+(b-c) && (b+(b-c))%a == 0) System.out.println("YES");
			else if ((a <= b) && c <= b+(b-a) && (b+(b-a))%c == 0) System.out.println("YES");
			else if ((b <= a) && c <= b-(a-b) && (b-(a-b))%c == 0) System.out.println("YES");
			else System.out.println("NO");
		}
	}
}