/*https://codeforces.com/problemset/problem/496/A*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.HashMap;
import java.util.ArrayList;

class Item implements Comparable<Item>
{
	int index1, index2;
	Item(int i1, int i2)
	{
		index1 = i1;
		index2 = i2;
	}
	@Override
	public int compareTo(Item i)
	{
		return 0;
	}
}

public class MinimumDifficulty
{
	public static void main (String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		String[] tokens = reader.readLine().trim().split(" +");
		int[] arr = new int[n];
		int min = Integer.MAX_VALUE, result = Integer.MAX_VALUE, diff = 0, finalResult = Integer.MAX_VALUE;
		for (int i = 0; i < n; ++i)
			arr[i] = Integer.parseInt(tokens[i]);
		HashMap<Integer,ArrayList<Item>> map = new HashMap<Integer,ArrayList<Item>>();
		for (int i = 1; i < n-1; ++i)
		{
			diff = arr[i+1]-arr[i-1];
			if (!map.containsKey(diff)) map.put(diff,new ArrayList<Item>());
			map.get(diff).add(new Item(i-1,i+1));
		}
		for (int i = 0; i < n-1; ++i)
		{
			if (arr[i+1]-arr[i] < min) { result = Math.min(min,result); min = arr[i+1]-arr[i]; }
			else if (arr[i+1]-arr[i] < result) result = arr[i+1]-arr[i];
		}
		for (int i = 1; i < n-1; ++i)
		{
			diff = arr[i+1]-arr[i-1];
			if (diff == min && map.get(diff).size() == 1) finalResult = result;
			else finalResult = min;
		}
		System.out.println(finalResult);
	}
}