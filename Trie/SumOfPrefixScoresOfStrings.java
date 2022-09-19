/*https://leetcode.com/problems/sum-of-prefix-scores-of-strings/*/

class TrieNode
{
    TrieNode[] hash;
    boolean isEnd;
    int[] freq;
    TrieNode()
    {
        hash = new TrieNode[26];
        isEnd = false;
        freq = new int[26];
    }
}
class Trie
{
    TrieNode root;
    Trie()
    {
        root = new TrieNode();
    }
    public void push(String word)
    {
        TrieNode temp = root;
        for (char ch : word.toCharArray())
        {
            int index = ch-'a';
            if (temp.hash[index] == null)
            {
                temp.hash[index] = new TrieNode();
                temp.freq[index] = 1;
            }
            else
                ++temp.freq[index];
            temp = temp.hash[index];
        }
        temp.isEnd = true;
    }
    public int getScore(String word)
    {
        TrieNode temp = root;
        int score = 0;
        for (char ch : word.toCharArray())
        {
            int index = ch-'a';
            score += temp.freq[index];
            temp = temp.hash[index];
        }
        return score;
    }
}
class Solution {
    public int[] sumPrefixScores(String[] words) {
        Trie trie = new Trie();
        int W = words.length;
        for (String word : words)
            trie.push(word);
        int[] result = new int[W];
        for (int i = 0; i < W; ++i)
            result[i] = trie.getScore(words[i]);
        return result;
    }
}

class TrieNode
{
    TrieNode[] hash;
    int freq;
    TrieNode()
    {
        hash = new TrieNode[26];
        freq = 0;
    }
}
class Trie
{
    TrieNode root;
    Trie()
    {
        root = new TrieNode();
    }
    public void push(String word)
    {
        TrieNode temp = root;
        for (char ch : word.toCharArray())
        {
            int index = ch-'a';
            if (temp.hash[index] == null)
                temp.hash[index] = new TrieNode();
            temp = temp.hash[index];
            ++temp.freq;
        }
    }
    public int getScore(String word)
    {
        TrieNode temp = root;
        int score = 0;
        for (char ch : word.toCharArray())
        {
            int index = ch-'a';
            temp = temp.hash[index];
            score += temp.freq;
        }
        return score;
    }
}
class Solution {
    public int[] sumPrefixScores(String[] words) {
        Trie trie = new Trie();
        int W = words.length;
        for (String word : words)
            trie.push(word);
        int[] result = new int[W];
        for (int i = 0; i < W; ++i)
            result[i] = trie.getScore(words[i]);
        return result;
    }
}