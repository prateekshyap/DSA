/*https://leetcode.com/problems/unique-email-addresses/*/

class Solution {
    public int numUniqueEmails(String[] emails) {
        HashSet<String> localHash = new HashSet<String>();
        HashSet<String> domainHash = new HashSet<String>();
        int count = 0;
        for (int i = 0; i < emails.length; ++i)
        {
            String[] tokens = emails[i].split("[@]");
            StringBuffer local = new StringBuffer("");
            for (int j = 0; j < tokens[0].length(); ++j)
            {
                if (tokens[0].charAt(j) == '.') continue;
                if (tokens[0].charAt(j) == '+') break;
                local.append(tokens[0].charAt(j));
            }
            if (!localHash.contains(local.toString()))
                ++count;
            else
            {
                if (!domainHash.contains(tokens[1]))
                    ++count;
            }
            localHash.add(local.toString());
            domainHash.add(tokens[1]);
        }
        return count;
    }
}