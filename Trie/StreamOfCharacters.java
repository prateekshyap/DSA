/*https://leetcode.com/problems/stream-of-characters/*/

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
    TrieNode root;
    Trie()
    {
        root = new TrieNode();
    }
    
    public void insert(String word)
    {
        TrieNode temp = root;
        for (int i = word.length()-1; i >= 0; --i)
        {
            if (temp.hash[word.charAt(i)-'a'] == null)
                temp.hash[word.charAt(i)-'a'] = new TrieNode();
            temp = temp.hash[word.charAt(i)-'a'];
        }
        temp.isEndOfWord = true;
    }
    
    public boolean search(StringBuffer word)
    {
        TrieNode temp = root;
        for (int i = word.length()-1; i >= 0; --i)
        {
            char ch = word.charAt(i);
            if (temp != null)
                temp = temp.hash[ch-'a'];
            if (temp != null && temp.isEndOfWord)
                return true;
        }
        return false;
    }
}

class StreamChecker {
    StringBuffer buffer;
    int maxLength = -1;
    Trie trie;
    public StreamChecker(String[] words)
    {
        buffer = new StringBuffer("");
        trie = new Trie();
        for (String word : words)
        {
            trie.insert(word);
            maxLength = Math.max(maxLength,word.length());
        }
    }
    
    public boolean query(char letter)
    {
        if(buffer.length() >= maxLength)
            buffer.deleteCharAt(0);
        buffer.append(letter);
        return trie.search(buffer);
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */