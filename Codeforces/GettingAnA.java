/*https://codeforces.com/problemset/problem/991/B*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.Arrays;

public class GettingAnA
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		String[] tokens = reader.readLine().trim().split(" +");
		int[] arr = new int[n];
		double sum = 0;
		int[] counts = new int[4];
		for (int i = 0; i < n; ++i)
		{
			arr[i] = Integer.parseInt(tokens[i]);
			sum += arr[i];
			if (arr[i] == 2) ++counts[0];
			else if (arr[i] == 3) ++counts[1];
			else if (arr[i] == 4) ++counts[2];
			else if (arr[i] == 5) ++counts[3];
		}
		if (sum/n >= 4.5) System.out.println("0");
		else
		{
			int result = 0;
			double rem = (4.5*n)-sum; //System.out.println(rem+" "+result);
			if (rem <= counts[0]*3)
			{
				result += Math.ceil(rem/3);
				rem = 0;
			}
			else
			{
				rem -= counts[0]*3;
				result += counts[0];
			}//System.out.println(rem+" "+result);
			if (rem <= counts[1]*2)
			{
				result += Math.ceil(rem/2);
				rem = 0;
			}
			else
			{
				rem -= counts[1]*2;
				result += counts[1];
			}//System.out.println(rem+" "+result);
			if (rem <= counts[2])
			{
				result += Math.ceil(rem);
				rem = 0;
			}
			else
			{
				rem -= counts[2];
				result += counts[2];
			}//System.out.println(rem+" "+result);
			System.out.println(result);
		}
	}
}