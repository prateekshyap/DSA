/*https://leetcode.com/problems/group-anagrams/*/

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> l = new ArrayList<List<String>>();
        String currStr = "";
        int[] h = new int[26];
        for (int i = 0; i < strs.length; ++i)
        {
            //pick a string
            if (strs[i] != null)
                currStr = strs[i];
            else
                continue;
            
            //store it in hash
            strs[i] = null;
            h = new int[26];
            for (int j = 0; j < currStr.length(); ++j)
                ++h[(int)currStr.charAt(j)-97];
            
            //keep a reference of the hash
            int[] refH = new int[26];
            for (int p = 0; p < 26; ++p)
                refH[p] = h[p];
            
            //temporary list
            List<String> temp = new ArrayList<String>();
            temp.add(currStr);
            
            //for every other string
            for (int j = i+1; j < strs.length; ++j)
            {
                //if the string length is equal to the picked string
                if (strs[j] != null && strs[j].length() == currStr.length())
                {
                    boolean flag = true;
                    for (int k = 0; k < strs[j].length(); ++k)
                    {
                        if (h[(int)strs[j].charAt(k)-97] == 0) //if it tries to deduct a character which is absent in the currStr string then reject the string
                        {
                            flag = false;
                            break;
                        }
                        else
                        {
                            --h[(int)strs[j].charAt(k)-97]; //change the hash value
                            if (h[(int)strs[j].charAt(k)-97] < 0) //if the hash value goes below 0 at any point then also reject the string
                            {
                                flag = false;
                                break;
                            }
                        }
                    }
                    if (flag) //if string is not rejected
                    {
                        temp.add(strs[j]); //add to the temporary list
                        strs[j] = null; //make it null
                    }
                    
                    //copy the reference hash for ext string checking
                    for (int p = 0; p < 26; ++p)
                        h[p] = refH[p];
                }
            }
            
            //add the temporary list to the answer
            l.add(temp);
        }
        return l;
    }
}