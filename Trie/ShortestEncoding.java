/*https://leetcode.com/problems/short-encoding-of-words/*/

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
    public void add(String s)
    {
        TrieNode temp = root;
        for (int i = 0; i < s.length(); ++i)
        {
            if (temp.hash[s.charAt(i)-'a'] == null)
                temp.hash[s.charAt(i)-'a'] = new TrieNode();
            temp = temp.hash[s.charAt(i)-'a'];
        }
        temp.isEndOfWord = true;
    }
    public boolean contains(String s)
    {
        TrieNode temp = root;
        for (int i = 0; i < s.length(); ++i)
        {
            if (temp.hash[s.charAt(i)-'a'] != null)
                temp = temp.hash[s.charAt(i)-'a'];
            else return false;
        }
        return temp.isEndOfWord;
    }
}

class Solution {
    public int minimumLengthEncoding(String[] words) {

    	//sort the array according to the length of words in descending order
        Arrays.sort(words,new Comparator<String>(){
            public int compare(String s1, String s2)
            {
                return s2.length()-s1.length();
            }
        });

        //create a trie
        Trie trie = new Trie();
        StringBuffer result = new StringBuffer("");
        
        //for each word
        for (int i = 0; i < words.length; ++i)
        {
        	//if trie already contains the word then continue
            if (trie.contains(words[i]))
                continue;
            StringBuffer sb = new StringBuffer("");

            //for each character in reverse order
            for (int j = words[i].length()-1; j >= 0; --j)
            {
            	//append it at the front of the stringbuffer
                StringBuffer temp = new StringBuffer("");
                temp.append(words[i].charAt(j));
                temp.append(sb);
                sb = temp;

                //add it to trie
                trie.add(sb.toString());
            }

            //append the word to result along with #
            result.append(words[i]);
            result.append("#");
        }

        //return its length
        return result.length();
    }
}