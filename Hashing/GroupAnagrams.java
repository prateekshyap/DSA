/*https://leetcode.com/problems/group-anagrams/*/

/*some really complicated solution :3*/
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

/*Another simpler solution*/
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        LinkedHashMap<String,StringBuilder> map = new LinkedHashMap<String,StringBuilder>();
        
        //for each string in the list
        for (int i = 0; i < strs.length; ++i)
        {
            //prepare the key
            String key = prepareKey(strs[i]);
            
            //if the key is already present in hashmap
            if (map.containsKey(key))
                //append the current string to its value preceeded by a separator
                map.put(key,map.get(key).append("#"+strs[i]));
            else //otherwise add a new entry
                map.put(key,new StringBuilder(strs[i]));
        }

        List<List<String>> result = new ArrayList<List<String>>();
        Iterator iterator = map.entrySet().iterator();

        //for each map entry
        while (iterator.hasNext())
        {
            //split the string using the separator, convert into a list and add to result
            Map.Entry element = (Map.Entry)iterator.next();
            String[] tokens = (((StringBuilder)element.getValue()).toString()).split("[#]");
            List<String> list = new ArrayList<String>();
            if (tokens.length == 0)
                for (int i = 0; i <= ((StringBuilder)element.getValue()).length(); ++i)
                    list.add("");
            else
                for (String token : tokens)
                    list.add(token);
            result.add(list);
        }

        return result;
    }
    public String prepareKey(String str)
    {
        //count the frequencies
        int[] hash = new int[26];
        for (int i = 0; i < str.length(); ++i)
            ++hash[str.charAt(i)-'a'];

        //append them into a string
        StringBuilder sb = new StringBuilder("");
        sb.append(hash[0]);
        for (int i = 1; i < 26; ++i)
        {
            sb.append("#");
            sb.append(hash[i]);
        }

        return new String(sb);
    }
}

/*Another beautiful solution using prime numbers and list*/
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int primes[] = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};
        Map<Long, List<String>> map = new HashMap<>();
        List<List<String>> result = new ArrayList<>();
        for (String str : strs) {
            long key = 1;
            for (char c : str.toCharArray())
                key *= primes[c - 'a'];
            if (!map.containsKey(key)) {
                List<String> temp = new ArrayList<>();
                map.put(key, temp);
                result.add(temp);
            }
            map.get(key).add(str);
        }
        return result;
    }
}

/*Modification to 2nd solution inspired by the 3rd*/
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        LinkedHashMap<String,List<String>> map = new LinkedHashMap<String,List<String>>();
        List<List<String>> result = new ArrayList<List<String>>();
        for (int i = 0; i < strs.length; ++i)
        {
            String key = prepareKey(strs[i]);
            if (!map.containsKey(key)) {
                List<String> temp = new ArrayList<>();
                map.put(key, temp);
                result.add(temp);
            }
            map.get(key).add(strs[i]);
        }
        return result;
    }
    public String prepareKey(String str)
    {
        int[] hash = new int[26];
        for (int i = 0; i < str.length(); ++i)
            ++hash[str.charAt(i)-'a'];
        StringBuilder sb = new StringBuilder("");
        sb.append(hash[0]);
        for (int i = 1; i < 26; ++i)
        {
            sb.append("#");
            sb.append(hash[i]);
        }
        return new String(sb);
    }
}

/*Pratik's Solution*/
class Solution {
    public List<List<String>> Anagrams(String[] string_list) {
        
        // Your Code here
        int n = string_list.length;
        List<List<String>> list = new ArrayList<List<String>>();
        for(int i=0;i<n;i++)
        {
            String s = string_list[i];
            int m = findPos(list,s);
            if(m==-1)
            {
                List<String> li = new ArrayList<String>();
                li.add(s);
                list.add(li);
            }
            else
            {
                List<String> li = list.get(m);
                li.add(s);
                list.remove(m);
                list.add(li);
            }
        }
        return list;
    }
    public int findPos(List<List<String>> list,String s)
    {
        char c[] = s.toCharArray();
        Arrays.sort(c);
        s = new String(c);
        for(int i=0;i<list.size();i++)
        {
            String temp = list.get(i).get(0);
            if(temp.length()!=s.length())continue;
            char t[] = temp.toCharArray();
            Arrays.sort(t);
            temp = new String(t);
            if(s.equals(temp))
            {
                return i;
            }
        }
        return -1;
    }
}
