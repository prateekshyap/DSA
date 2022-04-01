/*https://codeforces.com/problemset/problem/318/A*/

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class EvenOdds
{
	public static void main(String[] args)throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] tokens = reader.readLine().trim().split(" +");
		long limit = Long.parseLong(tokens[0]);
		long index = Long.parseLong(tokens[1]);
		if (limit%2 == 1)
			++limit;
		if (index > limit/2)
			System.out.println((index-(limit/2))*2);
		else
			System.out.println((index*2)-1);
	}
}