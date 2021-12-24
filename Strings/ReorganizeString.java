/*https://leetcode.com/problems/reorganize-string/*/

/*Prateekshya*/

class Solution {
	public String reorganizeString(String s) {
		int hash[] = new int[26];
		for (int i = 0; i < s.length(); ++i)
			++hash[s.charAt(i)-'a'];
		int max = 0, sum = 0;
		for (int i = 0; i < 26; ++i)
		{
			max = Math.max(max,hash[i]);
			sum += hash[i];
		}
		sum -= max;
		if (sum+1 < max)
			return "";
		StringBuilder result = new StringBuilder();
		PriorityQueue<Integer> pq = new PriorityQueue<>((e1,e2)->hash[e2]-hash[e1]);
		for (int i = 0; i < 26; i++)
			if (hash[i] != 0)
				pq.add(i);
		while (!pq.isEmpty())
		{
			int index = pq.poll();
			if (result.length() != 0 && index == result.charAt(result.length()-1)-'a')
			{   
				int t = pq.poll();
				pq.add(index);
				index = t;
			}
			result.append((char)('a'+index));
			if(--hash[index] != 0)
				pq.add(index);
		}
		return result.toString();
	}
}