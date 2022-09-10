/*https://leetcode.com/problems/map-sum-pairs/*/

class TrieNode
{
    TrieNode[] hash;
    boolean isEnd;
    TrieNode()
    {
        hash = new TrieNode[26];
        isEnd = false;
    }
}
class Trie
{
    TrieNode trieRoot;
    Trie()
    {
        trieRoot = new TrieNode();
    }
    public void insert(String word)
    {
        TrieNode temp = trieRoot;
        for (char ch : word.toCharArray())
        {
            if (temp.hash[ch-'a'] == null)
                temp.hash[ch-'a'] = new TrieNode();
            temp = temp.hash[ch-'a'];
        }
        temp.isEnd = true;
    }
    public List<String> getListOfWords(String pre)
    {
        List<String> wordsList = new ArrayList<String>();
        TrieNode temp = trieRoot;
        for (char ch : pre.toCharArray())
        {
            if (temp == null) return wordsList;
            temp = temp.hash[ch-'a'];
        }
        dfs(wordsList,temp,new StringBuilder(pre));
        return wordsList;
    }
    private void dfs(List<String> list, TrieNode root, StringBuilder word)
    {
        if (root == null) return;
        
        if (root.isEnd) list.add(word.toString());
        
        for (int i = 0; i < 26; ++i)
        {
            if (root.hash[i] != null)
            {
                word.append(Character.toString((char)i+'a'));
                dfs(list,root.hash[i],word);
                word.delete(word.length()-1,word.length());
            }
        }
    }
}
class MapSum {
    Trie words;
    HashMap<String,Integer> map;
    public MapSum() {
        map = new HashMap<String,Integer>();
        words = new Trie();
    }
    
    public void insert(String key, int val) {
        map.put(key,val);
        words.insert(key);
    }
    
    public int sum(String prefix) {
        List<String> wordsWithPrefix = words.getListOfWords(prefix);
        int valueSum = 0;
        for (String word : wordsWithPrefix)
            valueSum += map.get(word);
        return valueSum;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */