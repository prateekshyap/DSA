/*https://practice.geeksforgeeks.org/problems/phone-directory4628/1*/

//store the words in each node
class TrieNode
{
    HashMap<Character,TrieNode> map;
    boolean isEndOfWord;
    HashSet<String> wordsBelow;
    TrieNode()
    {
        map = new HashMap<Character,TrieNode>();
        isEndOfWord = false;
        wordsBelow = new HashSet<String>(); 
    }
}

class Trie
{
    public TrieNode root;
    Trie()
    {
        root = new TrieNode();
    }
    public void insert(String word)
    {
        TrieNode temp = root;
        for (int i = 0; i < word.length(); ++i)
        {
            if (!temp.map.containsKey(word.charAt(i)))
                temp.map.put(word.charAt(i),new TrieNode());
            temp.wordsBelow.add(word);
            temp = (TrieNode)temp.map.get(word.charAt(i));
        }
        temp.wordsBelow.add(word);
        temp.isEndOfWord = true;
    }
    public ArrayList<String> getListOfWords(String query)
    {
        TrieNode temp = root;
        
        //move till the end of the query string
        for (int i = 0; i < query.length(); ++i)
        {
            temp = (TrieNode)temp.map.get(query.charAt(i));
            if (temp == null) break; //break if temp becomes null midway
        }

        //if temp is null return 0
        if (temp == null)
        {
            ArrayList<String> emptyList = new ArrayList<String>();
            emptyList.add("0");
            return emptyList;
        }

        //otherwise sort the list on that node and return
        ArrayList<String> returnList = new ArrayList<>(temp.wordsBelow);
        Collections.sort(returnList);
        return returnList;
    }
}

class Solution
{
    static ArrayList<ArrayList<String>> displayContacts(int n, String contact[], String s)
    {
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        
        //add the contacts to trie
        Trie trie = new Trie();
        for (String str : contact) trie.insert(str);

        //add the lists and return
        for (int i = 1; i <= s.length(); ++i)
            result.add(trie.getListOfWords(s.substring(0,i)));
        return result;
    }
}