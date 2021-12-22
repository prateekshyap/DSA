/*https://leetcode.com/problems/design-add-and-search-words-data-structure/*/

class TrieNode
{
    HashMap<Character,TrieNode> map;
    boolean isEndOfWord;
    TrieNode()
    {
        isEndOfWord = false;
        map = new HashMap<Character,TrieNode>();
    }
}

class Trie
{
    TrieNode root;
    Trie()
    {
        root = new TrieNode();
    }
    public void addToDict(String word)
    {
        TrieNode temp = root;
        for (int i = 0; i < word.length(); ++i)
        {
            char ch = word.charAt(i);
            if (!temp.map.containsKey(ch))
                temp.map.put(ch,new TrieNode());
            temp = temp.map.get(ch);
        }
        temp.isEndOfWord = true;
    }
    public boolean searchInDict(String word)
    {
        TrieNode temp = root;
        return explore(temp,word,0);
    }
    public boolean explore(TrieNode temp, String word, int index)
    {
        if (index == word.length()) return temp.isEndOfWord;
        for (int i = index; i < word.length(); ++i)
        {
            char ch = word.charAt(i);
            if (ch == '.')
            {
                for (int j = 0; j < 26; ++j)
                    if(temp.map.containsKey((char)(j+'a')) && explore(temp.map.get((char)(j+'a')), word, i+1)) return true;
                return false;
            }
            else
            {
                if (!temp.map.containsKey(ch)) return false;
                temp = temp.map.get(ch);
            }
        }
        return temp.isEndOfWord;
    }
}

class WordDictionary {
    Trie trie;
    public WordDictionary() {
        trie = new Trie();
    }
    
    public void addWord(String word) {
        trie.addToDict(word);
    }
    
    public boolean search(String word) {
        return trie.searchInDict(word);
    }
}