/*https://leetcode.com/problems/word-ladder/*/

class Solution {
    int result;
    HashSet<String> hash;
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //add everything to hash
        hash = new HashSet<String>();
        for (String s : wordList)
            hash.add(s);

        //if the end word is not present then there is no sequence
        if (!hash.contains(endWord)) return 0;

        int result = 0;

        //add the first word to the queue
        Queue<String> queue = new LinkedList<String>();
        queue.add(beginWord);

        //till the queue has more elements
        while (!queue.isEmpty())
        {
            //increment result
            ++result;
            int len = queue.size();

            //for all elements of current level
            for (int i = 0; i < len; ++i)
            {
                String currWord = queue.remove();

                //if the current word is end word, return result
                if (currWord.equals(endWord)) return result;

                //otherwise
                StringBuilder left = new StringBuilder("");
                for (int j = 0; j < beginWord.length(); ++j)
                {
                    for (int k = 0; k < 26; ++k)
                    {
                        //keep replacing a to z at each place
                        left = new StringBuilder("");
                        left.append(currWord.substring(0,j));
                        left.append((char)(k+'a'));
                        left.append(currWord.substring(j+1));

                        //if the word is in hash and is not equal to current word
                        if (hash.contains(new String(left)) && !new String(left).equals(currWord))
                        {
                            //remove from hash and add to queue
                            queue.add(new String(left));
                            hash.remove(new String(left));
                        }
                    }
                }
            }
        }

        //if nothing found, return 0
        return 0;
    }
}