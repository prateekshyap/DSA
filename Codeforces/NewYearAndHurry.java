/*https://codeforces.com/problemset/problem/750/A*/

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class NewYearAndHurry
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		String[] tokens = bufferedReader.readLine().trim().split(" +");
		int n = Integer.parseInt(tokens[0]), k = Integer.parseInt(tokens[1]);
		int remainingTime = 240-k;
		remainingTime /= 5;
		int high = n, low = 0, mid = -1, result = 0, currResult = 0;
		while (low <= high)
		{
			mid = low+(high-low)/2;
			currResult = mid*(mid+1)/2;
			if (currResult == remainingTime || (currResult < remainingTime && (mid+1 > n || (mid+1)*(mid+2)/2 > remainingTime)))
			{
				result = mid;
				break;
			}
			else if (currResult < remainingTime)
				low = mid+1;
			else
				high = mid-1;
		}
		System.out.println(result);
	}
}