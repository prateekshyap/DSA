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