/*https://leetcode.com/problems/search-suggestions-system/*/

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
    public List<List<String>> getWords(String key)
    {
        List<List<String>> result = new ArrayList<List<String>>();

        //for each substring of the key
        for (int i = 1; i <= key.length(); ++i)
        {
        	//store the substring in curr
            String curr = key.substring(0,i);

            //mark flag true
            boolean flag = true;

            //declare two lists of strings
            List<String> prevList = null, currList = new ArrayList<String>();

            //if it is not the first substring
            if (i > 1)
            {
            	//get the previous list
                prevList = result.get(result.size()-1);

                //for each word in the previous list
                for (String prevWord : prevList)
                {
                	//if curr is not a substring of the word, mark flag as false
                    try{
                    if (prevWord.charAt(curr.length()-1) != curr.charAt(curr.length()-1))
                        flag = false;
                    }
                    catch(Exception e)
                    {
                        flag = false;
                    }
                }
            }

            //if flag is still true and previous list is non-null
            if (flag && prevList != null)
            {
            	//copy all the elements of previous list to current list and add it to result
                for (String word : prevList)
                    currList.add(word);
                result.add(currList);
            }

            //otherwise
            else
            {
            	//move till the last letter of curr
                TrieNode temp = root;
                for (int j = 0; j < curr.length(); ++j)
                    temp = temp.hash[curr.charAt(j)-'a'];

                //mark stopDFS as false
                stopDFS = false;

                //call DFS
                runDFS(new StringBuffer(curr), temp, currList);

                //add the current list to result
                result.add(currList);
            }
        }

        return result;
    }
    public void runDFS(StringBuffer curr, TrieNode temp, List<String> currList)
    {
    	//if temp is not null and end of word is true
        if (temp != null && temp.isEndOfWord)
        {
        	//add curr to list, if the list size is 3, mark stopDFS as true and return
            currList.add(curr.toString());
            if (currList.size() == 3)
            {
                stopDFS = true;
                return;
            }
        }

        //if temp is null, return
        else if (temp == null)
        {
            return;
        }

        //for each index
        for (int i = 0; i < 26; ++i)
        {
        	//if hash index is not null
            if (temp.hash[i] != null)
            {
            	//append the character to curr
                curr.append((char)(i+'a'));

                /*recursion call of DFS*/
                runDFS(curr,temp.hash[i],currList);

                //remove the last added character from curr
                curr.delete(curr.length()-1, curr.length());
            }

            //if stopDFS is true, break
            if (stopDFS) break;
        }
    }
}

class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> result;

        //add all words to trie
        Trie trie = new Trie();
        for (String product : products)
            trie.add(product);

        //call get words function
        result = trie.getWords(searchWord);

        return result;
    }
}