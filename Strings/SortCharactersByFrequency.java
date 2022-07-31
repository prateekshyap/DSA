/*https://leetcode.com/problems/sort-characters-by-frequency/*/

class Pair implements Comparable<Pair>
{
    char ch;
    int freq;
    Pair(char ch, int freq)
    {
        this.ch = ch;
        this.freq = freq;
    }
    
    @Override
    public int compareTo(Pair p)
    {
        return p.freq-this.freq;
    }
}
class Solution {
    public String frequencySort(String s) {
        int[] hash = new int[128];
        for (char ch : s.toCharArray())
            ++hash[ch];
        PriorityQueue<Pair> heap = new PriorityQueue<Pair>();
        int i;
        for (i = 0; i < 128; ++i)
            if (hash[i] > 0)
                heap.add(new Pair((char)(i),hash[i]));
        StringBuilder result = new StringBuilder("");
        Pair p;
        while (!heap.isEmpty())
        {
            p = heap.poll();
            for (i = 0; i < p.freq; ++i)
                result.append(p.ch);
        }
        return result.toString();
    }
}