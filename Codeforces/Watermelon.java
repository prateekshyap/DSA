/*https://codeforces.com/problemset/problem/4/A*/

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Watermelon
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int watermelon = Integer.parseInt(br.readLine().trim());
		if (watermelon > 2 && watermelon%2 == 0)
			System.out.println("YES");
		else
			System.out.println("NO");
	}
}