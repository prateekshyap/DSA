/*https://leetcode.com/problems/remove-comments/*/

class Solution {
    public List<String> removeComments(String[] source) {
        List<String> result = new ArrayList<String>();
        StringBuilder build = new StringBuilder("");
        boolean commentBlock = false, commentLine = false;
        for (String line : source)
        {
            commentLine = false;
            for (int i = 0; i < line.length(); ++i)
            {
                if (i < line.length()-1)
                {
                    if (line.charAt(i) == '/')
                    {
                        if (line.charAt(i+1) == '*' && !commentBlock && !commentLine)
                        {
                            commentBlock = true;
                            ++i;
                            continue;
                        }
                        else if (line.charAt(i+1) == '/' && !commentBlock)
                        {
                            commentLine = true;
                            ++i;
                            continue;
                        }
                    }
                    if (i < line.length()-1 && line.charAt(i) == '*' && line.charAt(i+1) == '/' && commentBlock)
                    {
                        commentBlock = false;
                        ++i;
                        continue; 
                    }
                }
                if (!commentLine && !commentBlock && i < line.length()) build.append(line.charAt(i));
            }
            if (build.length() > 0 && !commentBlock)
            {
                result.add(build.toString());
                build = new StringBuilder("");
            }
        }
        return result;
    }
}