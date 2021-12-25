/*https://leetcode.com/problems/restore-ip-addresses/*/
/*https://practice.geeksforgeeks.org/problems/generate-ip-addresses/1*/

class Combinations
{
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    
    void recur(List<Integer> currList, int curr, int k, int n)
    {
        if (k == 0)
        {
            result.add(currList);
            return;
        }
        
        for(int i = curr+1; i <= n; ++i)
        {
            List<Integer> newList = new ArrayList<>(currList);
            newList.add(i);
            recur(newList, i, k-1, n);
        }
    }
    
    public List<List<Integer>> combine(int n, int k)
    {
        List<Integer> currList = new ArrayList<Integer>();
        recur(currList, 0, k, n);
        return result;
    }
}

class Solution {
    Set<String> resultSet;
    List<List<Integer>> combs;
    public List<String> restoreIpAddresses(String s) {
        Combinations combination = new Combinations();
        combs = combination.combine(s.length(),3); //get the combinations nC3
        StringBuffer ref = new StringBuffer(s);
        StringBuffer buffer = new StringBuffer();
        resultSet = new HashSet<String>();
        boolean result = false;
        
        for (List<Integer> comb : combs) //for each combination
        {
            buffer = new StringBuffer(ref);
            //attach three dots
            buffer.insert(comb.get(0),".");
            buffer.insert(comb.get(1)+1,".");
            buffer.insert(comb.get(2)+2,".");
            result = isValid(buffer.toString()); //check if valid
            if (result) resultSet.add(buffer.toString()); //add to result set if valid
        }
        
        List<String> resultList = new ArrayList<String>();
        for (String word : resultSet)
            resultList.add(word);
        return resultList;
    }
    
    public boolean isValid(String s)
    {
        String[] tokens = s.split("[.]");
        if (s.charAt(0) == '.' || s.charAt(s.length()-1) == '.') return false; //false for dot at start or end
        if (tokens.length != 4) return false; //false for more than 4 parts
        for (int i = 0; i < tokens.length; ++i)
        {
            if (tokens[i].length() >= 4) return false; //false for all strings of length greater than 3
            try
            {
                int num = Integer.parseInt(tokens[i]);
                if (!(num >= 0 && num <= 255)) return false; //false for out of range
                if (num < 10 && tokens[i].length() > 1) return false; //false for extra zero
                if (num < 100 && tokens[i].length() > 2) return false; //false for extra zero
            }
            catch(NumberFormatException ne)
            {
                return false; //false for presence of characters other than digits
            }
        }
        return true;
    }
}