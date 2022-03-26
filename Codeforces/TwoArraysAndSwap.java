/*https://codeforces.com/problemset/problem/1353/B*/

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

import java.util.Arrays;

public class TwoArraysAndSwap
{
	public static void main(String[] args)throws IOException
	{
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(bufferedReader.readLine());
		String[] tokens;
		int n, k, i, left, right, sumA = 0, sumB = 0, temp;
		int[] a, b;
		boolean printed = false;
		while (testCases-- > 0)
		{
			printed = false;
			tokens = bufferedReader.readLine().trim().split(" +");
			n = Integer.parseInt(tokens[0]);
			k = Integer.parseInt(tokens[1]);
			a = new int[n];
			b = new int[n];
			sumA = sumB = 0;
			tokens = bufferedReader.readLine().trim().split(" +");
			for (i = 0; i < n; ++i) a[i] = Integer.parseInt(tokens[i]);
			tokens = bufferedReader.readLine().trim().split(" +");
			for (i = 0; i < n; ++i) b[i] = Integer.parseInt(tokens[i]);

			Arrays.sort(a); Arrays.sort(b);

			left = 0;
			right = n-1;

			if (a[left] >= b[right])
			{
				sumA = 0;
				for (i = 0; i < n; ++i) sumA += a[i];
				System.out.println(sumA);
				printed = true;
			}
			if (printed) continue;
			for (i = 0; i < k; ++i)
			{
				temp = a[left];
				a[left] = b[right];
				b[right] = temp;
				++left; --right;
				if (left < n && right >= 0 && a[left] >= b[right])
				{
					sumA = 0;
					for (i = 0; i < n; ++i) sumA += a[i];
					System.out.println(sumA);
					printed = true;
					break;
				}
			}
			if (printed) continue;
			sumA = 0;
			for (i = 0; i < n; ++i) sumA += a[i];
				System.out.println(sumA);
		}
	}
}