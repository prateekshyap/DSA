/*https://leetcode.com/problems/most-common-word/*/

class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        HashMap<String,Integer> freq = new HashMap<String,Integer>();
        HashMap<String,Boolean> bannedWords = new HashMap<String,Boolean>();
        
        int maxFreq = 0;
        String word = "";
        
        for (int i = 0; i < banned.length; ++i) bannedWords.put(banned[i],true);

        //convert the paragraph to lower case
        paragraph = paragraph.toLowerCase();

    	//split using all extra characters
        String[] tokens = paragraph.split("[, .!?';]");
        /*for (int i = 0; i < tokens.length; ++i)
            System.out.println("'"+tokens[i]+"'");*/

        //for every string
        for (int i = 0; i < tokens.length; ++i)
        {
        	//if there is a empty word we have to ignore it
            if (tokens[i].length() == 0) continue;

            //put the frequency in freq
            freq.put(tokens[i],(freq.containsKey(tokens[i]) ? (Integer)freq.get(tokens[i])+1 : 1));

            //if we get a new maximum frequency and the word is not present in banned words set
            if ((Integer)freq.get(tokens[i]) > maxFreq && !bannedWords.containsKey(tokens[i]))
            {
            	//update both maxfreq and word
                maxFreq = (Integer)freq.get(tokens[i]);
                word = tokens[i];
            }
        }
        
        return word;
    }
}