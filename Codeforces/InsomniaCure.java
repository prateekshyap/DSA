/*https://codeforces.com/problemset/problem/148/A*/

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

public class InsomniaCure
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] hash = new int[11];
		int[] arr = new int[4];
		for (int i = 0; i < 4; ++i)
			arr[i] = Integer.parseInt(br.readLine());
		Arrays.sort(arr);
		int d = Integer.parseInt(br.readLine());
		int result = d;
		if (arr[0] == 1)
		{
			System.out.println(d);
		}
		else
		{
			for (int i = 2; i <= d; ++i)
			{
				if (i%arr[0] == 0 || i%arr[1] == 0 || i%arr[2] == 0 || i%arr[3] == 0)
					--result;
			}
			System.out.println(d-result);
		}
	}
}