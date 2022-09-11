/*https://leetcode.com/problems/maximum-frequency-stack/*/

class FreqStack {
    Map<Integer,Integer> freqs;
    Map<Integer,Stack<Integer>> stacks;
    int maxFreq;
    public FreqStack() {
        freqs = new HashMap<Integer,Integer>();
        stacks = new HashMap<Integer,Stack<Integer>>();
        maxFreq = 0;
    }
    
    public void push(int val) {
        int freq = freqs.getOrDefault(val,0)+1;
        freqs.put(val,freq);
        if (freq > maxFreq) maxFreq = freq;
        if (!stacks.containsKey(freq)) stacks.put(freq,new Stack<Integer>());
        stacks.get(freq).push(val);
    }
    
    public int pop() {
        int val = stacks.get(maxFreq).pop();
        freqs.put(val,freqs.get(val)-1);
        if (stacks.get(maxFreq).size() == 0) --maxFreq;
        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */