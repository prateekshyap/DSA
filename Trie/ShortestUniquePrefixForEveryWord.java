/*https://practice.geeksforgeeks.org/problems/shortest-unique-prefix-for-every-word/0/*/

//store frequencies of each node and find the first node with frequency 1
class TrieNode
{
    HashMap<Character,TrieNode> map;
    int freq;
    boolean isEndOfWord;
    TrieNode()
    {
        map = new HashMap<Character,TrieNode>();
        freq = 0;
        isEndOfWord = false;
    }
}

class Trie
{
    HashMap<String,StringBuilder> map;
    TrieNode root;
    Trie()
    {
        root = new TrieNode();
        map = new HashMap<String,StringBuilder>();
    }
    public void insert(String word)
    {
        TrieNode temp = root;
        for (int i = 0; i < word.length(); ++i)
        {
            if (!temp.map.containsKey(word.charAt(i)))
            {
                temp.map.put(word.charAt(i), new TrieNode());
            }
            temp = (TrieNode)temp.map.get(word.charAt(i));
            ++temp.freq;
        }
        temp.isEndOfWord = true;
    }
    public String getPrefix(String word)
    {
        TrieNode temp = root;
        StringBuilder result = new StringBuilder("");
        int i = 0;
        while (temp.freq != 1)
        {
            result.append(word.charAt(i));
            temp = (TrieNode)temp.map.get(word.charAt(i++));
        }
        return new String(result);
    }
}

class Solution {
    static String[] findPrefixes(String[] arr, int N) {
        Trie trie = new Trie();
        String[] result = new String[arr.length];
        for (String word : arr) trie.insert(word);
        for (int i = 0; i < arr.length; ++i)
            result[i] = trie.getPrefix(arr[i]);
        return result;
    }
}