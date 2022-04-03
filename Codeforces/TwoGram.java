/*https://codeforces.com/problemset/problem/977/B*/

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;

public class TwoGram
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine()), maxCount = 0;
		String s = reader.readLine(), subS = "";
		HashMap<String,Integer> twoGrams = new HashMap<String,Integer>();
		for (int i = 0; i < s.length()-1; ++i)
		{
			subS = s.substring(i,i+2);
			twoGrams.put(subS,twoGrams.containsKey(subS) ? (Integer)twoGrams.get(subS)+1 : 1);
		}
		Iterator it = twoGrams.entrySet().iterator();
		while (it.hasNext())
		{
			Map.Entry elem = (Map.Entry)it.next();
			if ((Integer)elem.getValue() > maxCount)
			{
				maxCount = (Integer)elem.getValue();
				subS = (String)elem.getKey();
			}
		}
		System.out.println(subS);
	}
}