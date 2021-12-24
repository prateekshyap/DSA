/*https://leetcode.com/problems/implement-trie-prefix-tree/*/

class TrieNode
{
    TrieNode[] hash;
    boolean isEndOfWord;
    TrieNode()
    {
        hash = new TrieNode[26];
        isEndOfWord = false;
    }
}

class Trie
{
    boolean stopDFS = false;
    TrieNode root;
    Trie()
    {
        root = new TrieNode();
    }
    
    public void insert(String word)
    {
        TrieNode temp = root;
        for (int i = 0; i < word.length(); ++i)
        {
            if (temp.hash[word.charAt(i)-'a'] == null)
                temp.hash[word.charAt(i)-'a'] = new TrieNode();
            temp = temp.hash[word.charAt(i)-'a'];
        }
        temp.isEndOfWord = true;
    }
    
    public boolean search(String word)
    {
        TrieNode temp = root;
        for (int i = 0; i < word.length(); ++i)
        {
            if (temp.hash[word.charAt(i)-'a'] == null)
                return false;
            temp = temp.hash[word.charAt(i)-'a'];
        }
        return temp.isEndOfWord;
    }
    
    public boolean startsWith(String prefix)
    {
        TrieNode temp = root;
        for (int i = 0; i < prefix.length(); ++i)
        {
            if (temp.hash[prefix.charAt(i)-'a'] == null)
                return false;
            temp = temp.hash[prefix.charAt(i)-'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */