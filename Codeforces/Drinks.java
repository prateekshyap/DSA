/*https://codeforces.com/problemset/problem/200/B*/

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Drinks
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Double n = Double.parseDouble(br.readLine());
		String[] tokens = br.readLine().trim().split(" +");
		double sum = 0;
		for (int i = 0; i < n; ++i)
			sum += Double.parseDouble(tokens[i]);
		System.out.println(sum/n);
	}
}