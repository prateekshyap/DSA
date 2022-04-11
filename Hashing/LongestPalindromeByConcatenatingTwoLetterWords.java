/*https://leetcode.com/problems/longest-palindrome-by-concatenating-two-letter-words/*/

class Solution {
    public int longestPalindrome(String[] words) {
        int result = 0;
        HashMap<String, Integer> wordMap = new HashMap<String, Integer>();
        for (int i = 0; i < words.length; ++i) //put the counts to map
            wordMap.put(words[i], (wordMap.containsKey(words[i]) ? (Integer)wordMap.get(words[i])+1 : 1));
        Iterator iterator = wordMap.entrySet().iterator();
        boolean isSymmetryChosen = false; //indicates whether a single word is chosen or not
        while (iterator.hasNext()) //for each entry in map
        {
            Map.Entry elem = (Map.Entry)iterator.next(); //get the element
            if ((Integer)elem.getValue() == 0) //if the count is 0
                continue; //continue
            String word = (String)elem.getKey(); //get the word
            StringBuffer rev = new StringBuffer((String)elem.getKey()); //store a copy in a stringbuffer to reverse it
            if (word.charAt(0) == word.charAt(1) && (Integer)wordMap.get(word) == 1 && !isSymmetryChosen) //if word is symmetric, count is 1 and symmetry is not yet chosen
            {
                isSymmetryChosen = true; //indicate chosen
                result += 2; //add 2 to the length
                wordMap.put(word,0); //store 0 in count
            }
            else if (word.charAt(0) == word.charAt(1)) //if word is symmetric
            {
                result += (Integer)wordMap.get(word)/2*4; //add the even length
                if ((Integer)wordMap.get(word)%2 != 0 && !isSymmetryChosen) //if odd length is possible and symmetry is not yet chosen
                {
                    isSymmetryChosen = true; //indicate chosen
                    result += 2; //add 2 to the length
                }
                wordMap.put(word,0); //store 0 in count
            }
            else if (word.charAt(0) != word.charAt(1) && wordMap.containsKey(rev.reverse().toString())) //for other cases, if word and reverse both are present
            {
                int min = Math.min((Integer)wordMap.get(word),(Integer)wordMap.get(rev.toString())); //get the minimum count of the word and its reverse
                result += min*4; //add the length
                wordMap.put(word,0); //store 0 in count of word
                wordMap.put(rev.toString(),0); //store 0 in count of reverse
            }
            else //if none of the above is satisfying
                wordMap.put(word,0); //store 0 rightaway since this word cannot be added to palindrome
        }
        return result;
    }
}