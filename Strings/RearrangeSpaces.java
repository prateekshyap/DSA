/*https://leetcode.com/problems/rearrange-spaces-between-words/*/

class Solution {
    public String reorderSpaces(String text) {
        int actualLength = text.length();
        int alphaLength = 0;
        String[] tokens = text.trim().split(" +");
        for (String token : tokens)
            alphaLength += token.length();
        int totalSpaceLength = actualLength-alphaLength;
        int spaces = tokens.length-1;
        int rem = 0;
        StringBuffer result = new StringBuffer("");
        if (spaces != 0)
        {
            int spaceLength = totalSpaceLength/spaces;
            rem = totalSpaceLength-(spaces*spaceLength);
            for (int i = 0; i < tokens.length-1; ++i)
            {
                result.append(tokens[i]);
                for (int j = 0; j < spaceLength; ++j)
                    result.append(" ");
            }
        }
        else
            rem = totalSpaceLength;
        result.append(tokens[tokens.length-1]);
        for (int j = 0; j < rem; ++j)
            result.append(" ");
        return result.toString();
    }
}

class Solution {
    public String reorderSpaces(String text) {
        int actualLength = text.length();
        int totalSpaceLength = 0, words = 0;
        for (int i = 0; i < actualLength; ++i)
        {
            if (text.charAt(i) == ' ')
                ++totalSpaceLength;
            if (text.charAt(i) != ' ' && (i == actualLength-1 || text.charAt(i+1) == ' '))
                ++words;
        }
        if (words == 1)
        {
            StringBuffer newText = new StringBuffer(text.trim());
            while (totalSpaceLength-- > 0)
                newText.append(' ');
            return newText.toString();
        }
        int spaces = words-1;
        int rem = 0;
        StringBuffer result = new StringBuffer("");
        int i = 0;
        while (text.charAt(i) == ' ') ++i;
        if (spaces != 0)
        {
            int spaceLength = totalSpaceLength/spaces;
            rem = totalSpaceLength-(spaces*spaceLength);
            for (; i < actualLength; ++i)
            {
                while (i < actualLength && text.charAt(i) != ' ')
                    result.append(text.charAt(i++));
                while (i < actualLength && text.charAt(i) == ' ') ++i;
                --i;
                for (int j = 0; j < spaceLength; ++j)
                    result.append(" ");
            }
        }
        else
            rem = totalSpaceLength;
        result = new StringBuffer(result.toString().trim());
        for (int j = 0; j < rem; ++j)
            result.append(" ");
        return result.toString();
    }
}
