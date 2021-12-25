/*https://codeforces.com/problemset/problem/112/A*/

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class PetyaAndStrings
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input1 = br.readLine().toLowerCase();
		String input2 = br.readLine().toLowerCase();
		boolean isEqual = true;
		int diff = -1;
		for (int i = 0; i < input1.length(); ++i)
		{
			if (input1.charAt(i) != input2.charAt(i))
			{
				isEqual = false;
				diff = i;
				break;
			}
		}
		if (isEqual)
			System.out.println("0");
		else if (input1.charAt(diff) > input2.charAt(diff))
			System.out.println("1");
		else
			System.out.println("-1");
	}
}