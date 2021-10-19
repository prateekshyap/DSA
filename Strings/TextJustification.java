/*https://leetcode.com/problems/text-justification/*/

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int index = 0;
        int start = index, end = index;
        List<String> result = new ArrayList<String>();
        StringBuffer currLine = new StringBuffer("");

        //until all the words are exhausted
        while (index < words.length)
        {
            start = end = index;

            //get the possible width of the current line, point start and end to the appropriate word indices
            int currWidth = (words[start].length()+1);
            while (end < words.length-1 && currWidth+(words[end+1].length()+1) <= maxWidth+1)
                currWidth += (words[++end].length()+1);
            currWidth -= 1;
            if (end == words.length-1)
                break;
            
            int spaces = end-start; //number of spaces required between words
            int rem = maxWidth-currWidth; //total blanks
            int spaceLength = spaces == 0 ? 0 : rem/spaces; //length of each space between words
            int extra = rem-(spaces*spaceLength); //extra blanks
            
            //append the words along with required number of spaces
            currLine = new StringBuffer("");
            for (int i = start; i < end; ++i)
            {
                currLine.append(words[i]);
                if (spaces == 0) break;
                for (int j = 0; j <= spaceLength; ++j)
                    currLine.append(" ");
                if (extra-- > 0)
                    currLine.append(" ");
            }
            currLine.append(words[end]);

            //for single word
            if (spaces == 0)
            {
                int len = maxWidth-currLine.length();
                for (int i = 0; i < len; ++i)
                    currLine.append(" ");
            }

            //add the current line to the result
            result.add(currLine.toString());

            //update the next starting point
            index = end+1;
        }

        //for the last line
        currLine = new StringBuffer("");
        for (int i = start; i < end; ++i)
        {
            currLine.append(words[i]);
            currLine.append(" ");
        }
        currLine.append(words[end]);
        index = maxWidth-currLine.length();
        for (int i = 0; i < index; ++i)
            currLine.append(" ");
        result.add(currLine.toString());
        
        return result;
    }
}