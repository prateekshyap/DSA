/*https://codeforces.com/problemset/problem/432/A*/

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

public class ChoosingTeams
{
	public static void main(String[] args)throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tokens = br.readLine().trim().split(" +");
		int n = Integer.parseInt(tokens[0]);
		int k = Integer.parseInt(tokens[1]);
		tokens = br.readLine().trim().split(" +");
		int[] data = new int[n];
		for (int i = 0; i < n; ++i)
			data[i] = Integer.parseInt(tokens[i]);
		Arrays.sort(data);
		int lastIndex = binarySearch(data,0,n-1,5-k);
		if (lastIndex == -1) System.out.println("0");
		else System.out.println((lastIndex+1)/3);
	}
	public static int binarySearch(int[] arr, int l, int h, int target)
	{
		if (l <= h)
		{
			int m = (l+h)/2;
			if (arr[m] <= target && (m == arr.length-1 || arr[m+1] > target)) return m;
			else if (arr[m] <= target) return binarySearch(arr,m+1,h,target);
			return binarySearch(arr,l,m-1,target);
		}
		return -1;
	}
}