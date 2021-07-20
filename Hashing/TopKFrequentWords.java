/*https://leetcode.com/problems/top-k-frequent-words/*/

class Word implements Comparable<Word>
{
    String s;
    int freq;
    Word(String s, int freq)
    {
        this.s = s;
        this.freq = freq;
    }
    public int compareTo(Word w)
    {
        if(this.freq > w.freq) return -1;
        if(this.freq < w.freq) return 1;
        return this.s.compareTo(w.s);
    }
}

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> freq = new HashMap<String,Integer>();
        PriorityQueue<Word> maxHeap = new PriorityQueue<Word>();
        List<String> result = new ArrayList<String>();

        //for every string
        for (int i = 0; i < words.length; ++i)
            //put the frequency in freq
            freq.put(words[i],(freq.containsKey(words[i]) ? (Integer)freq.get(words[i])+1 : 1));
        
        Iterator iterator = freq.entrySet().iterator();
        while (iterator.hasNext())
        {
            Map.Entry word = (Map.Entry)iterator.next();
            maxHeap.add(new Word((String)word.getKey(),(Integer)word.getValue()));
        }
        
        while (k-- > 0)
        {
            result.add(maxHeap.poll().s);
        }
        
        return result;
    }
}