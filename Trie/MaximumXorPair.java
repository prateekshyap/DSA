/*https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/*/

class TrieNode {
    TrieNode[] edges;
    boolean endOfWord;
    int value;
    TrieNode()
    {
        this.endOfWord = false;
        this.edges = new TrieNode[2];
        this.value = -1;
    }
}

class Trie {
    public TrieNode root;
    Trie () {
        root = new TrieNode();
    }
    public int insert (String str, int value) {
        int depth = 0; //keeps track of the common depth
        TrieNode curr = root;
        int i = 0;
        while (i < str.length()) { //for all characters
            
            //decide the edge
            int val = 0;
            if (str.charAt(i) == '1')
                val = 1;
                
            //move along the edge and update the depth accordingly
            if (curr.edges[val] == null) {
                curr.edges[val] = new TrieNode();
                curr = curr.edges[val];
            }
            else {
                curr = curr.edges[val];
                ++depth;
            }
            ++i;
        }
        curr.endOfWord = true; //mark end of word
        curr.value = value; //store the value
        return depth;
    }
    public int getSecond(String str, int depth) {
        TrieNode curr = root;
        int i = 0;
        
        //till the common depth is there, traverse along the path
        while (depth > 0) {
            int index = 0;
            if (str.charAt(i) == '1')
                index = 1;
            curr = curr.edges[index];
            --depth;
            ++i;
        }
        
        //this case arises when the initial array contains duplicate numbers
        if (i >= str.length())
            return curr.value;
            
        //at the point of separation, move towards the opposite path
        if (str.charAt(i) == '1')
            curr = curr.edges[0];
        else
            curr = curr.edges[1];
        ++i;
        
        //try to keep the bits as unequal as possible and move till end
        while (i < str.length() && !curr.endOfWord) {
            if (str.charAt(i) == '1') {
                if (curr.edges[0] == null)
                    curr = curr.edges[1];
                else
                    curr = curr.edges[0];
            }
            else {
                if (curr.edges[1] == null)
                    curr = curr.edges[0];
                else
                    curr = curr.edges[1];
            }
            ++i;
        }
        return curr.value;
    }
}
class Solution {
    public int findMaximumXOR(int[] nums) {
        //corner case
        if (nums.length <= 1) return 0;
        
        String[] binary = new String[nums.length]; //stores binary strings
        
        //find the maximum value
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; ++i)
            if (nums[i] > max)
                max = nums[i];
        if (max == 0) return 0; //if max is 0 then return 0
        
        //find the number of bits required to represent max
        double len = Math.floor(Math.log(max)/Math.log(2))+1;
        
        //convert every element to binary, pad extra zeros and store
        for (int i = 0; i < nums.length; ++i)
        {
            StringBuffer sb = new StringBuffer(Integer.toBinaryString(nums[i]));
            double padding = len - sb.length();
            StringBuffer res = new StringBuffer();
            for (int j = 0; j < padding; ++j)
                res.append("0");
            res.append(sb);
            binary[i] = new String(res);
        }
        
        int minDepth = (int)len+1;
        ArrayList<Integer> list = new ArrayList<Integer>();
        Trie trie = new Trie();
        
        //insert the binary strings into trie and keep track of the maximum common depth
        trie.insert(binary[0],nums[0]);
        for (int i = 1; i < binary.length; ++i)
        {
            int depth = trie.insert(binary[i], nums[i]);
            if (depth < minDepth)
            {
                minDepth = depth;
                list = new ArrayList<Integer>();
                list.add(i);
            }
            else if (minDepth != len && binary[i].charAt(minDepth) == binary[(Integer)list.get(0)].charAt(minDepth))
            {
                list.add(i);
            }
        }
        
        //find out the maximum xor value possible
        max = Integer.MIN_VALUE;
        for (Integer firstInd : list)
        {
            int second = trie.getSecond(binary[firstInd], minDepth);
            int first = nums[firstInd];
            int res = first^second;
            if (res > max) max = res;
        }
        return max;
    }
}