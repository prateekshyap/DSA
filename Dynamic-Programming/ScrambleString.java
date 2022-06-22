/*https://leetcode.com/problems/scramble-string/*/

//easy peasy
class Solution {
    HashMap<String,Boolean> map = new HashMap<String,Boolean>();
    public boolean isScramble(String s1, String s2) {
        if (s1.length() < 1) return false;
        if (s1.compareTo(s2) == 0) return true;
        
        StringBuffer tempBuffer = new StringBuffer("");
        tempBuffer.append(s1);
        tempBuffer.append(" ");
        tempBuffer.append(s2);
        String temp = tempBuffer.toString();
        if(map.containsKey(temp))
            return map.get(temp);
            
        boolean flag = false;
        int n = s1.length();
        
        for (int i = 1; i <= n-1; ++i)
        {
            if (isScramble(s1.substring(0,i),s2.substring(0,i)) && isScramble(s1.substring(i),s2.substring(i)))
            {
                flag = true;
                break;
            }
        
            if (isScramble(s1.substring(0,i),s2.substring(n-i)) && isScramble(s1.substring(i),s2.substring(0,n-i)))
            {
                flag = true;
                break;
            }
        }
        map.put(temp,flag);
        return flag;
    }
}

//optimized solution using sliding window
class Solution {
    HashMap<String,Boolean> map;
    public boolean isScramble(String s1, String s2)
    {
        map = new HashMap<String,Boolean>();
        return recur(s1, s2);
    }
    public boolean recur(String s1, String s2)
    {
        //create the key for dp
        StringBuffer keyBuffer = new StringBuffer(s1);
        keyBuffer.append(" ");
        keyBuffer.append(s2);
        String key = keyBuffer.toString();
        
        //if already calculated, return
        if (map.containsKey(key)) return map.get(key);
        
        //base cases
        if (s1.equals(s2)) return true;
        if (s1.length() == 1 && s2.length() == 1) return false;
        
        int[] lh = new int[26], rh = new int[26];
        boolean res1 = false, res2 = false, res = false;
        
        //left to right
        int n = s1.length(), i;
        ++lh[s1.charAt(0)-'a'];
        --lh[s2.charAt(0)-'a'];
        for (i = 1; i < n; ++i)
        {
            ++rh[s1.charAt(i)-'a'];
            --rh[s2.charAt(i)-'a'];
        }
        if (isBalanced(lh) && isBalanced(rh))
        {
            res1 = recur(s1.substring(0,1),s2.substring(0,1));
            res2 = recur(s1.substring(1),s2.substring(1));
            if (res1 && res2) res = true;
        }
        for (i = 1; i < n-1; ++i)
        {
            --rh[s1.charAt(i)-'a'];
            ++rh[s2.charAt(i)-'a'];
            ++lh[s1.charAt(i)-'a'];
            --lh[s2.charAt(i)-'a'];
            if (isBalanced(lh) && isBalanced(rh))
            {
                res1 = recur(s1.substring(0,i+1),s2.substring(0,i+1));
                res2 = recur(s1.substring(i+1),s2.substring(i+1));
                if (res1 && res2) res = true;
            }
        }
        
        //right to left
        lh = new int[26];
        rh = new int[26];
        ++lh[s1.charAt(0)-'a'];
        --lh[s2.charAt(n-1)-'a'];
        int j;
        for (i = 1, j = n-2; i < n && j >= 0; ++i, --j)
        {
            ++rh[s1.charAt(i)-'a'];
            --rh[s2.charAt(j)-'a'];
        }
        if (isBalanced(lh) && isBalanced(rh))
        {
            res1 = recur(s1.substring(0,1),s2.substring(n-1));
            res2 = recur(s1.substring(1),s2.substring(0,n-1));
            if (res1 && res2) res = true;
        }
        for (i = 1, j = n-2; i < n-1 && j > 0; ++i, --j)
        {
            --rh[s1.charAt(i)-'a'];
            ++rh[s2.charAt(j)-'a'];
            ++lh[s1.charAt(i)-'a'];
            --lh[s2.charAt(j)-'a'];
            if (isBalanced(lh) && isBalanced(rh))
            {
                res1 = recur(s1.substring(0,i+1),s2.substring(j));
                res2 = recur(s1.substring(i+1),s2.substring(0,j));
                if (res1 && res2) res = true;
            }
        }
        map.put(key,res);
        return res;
    }
    public boolean isBalanced(int[] h)
    {
        for (int i : h) if (i != 0) return false;
        return true;
    }
}

class Solution {
    HashMap<String,Boolean> map;
    public boolean isScramble(String s1, String s2)
    {
        map = new HashMap<String,Boolean>();
        return recur(s1, s2);
    }
    public boolean recur(String str1, String str2)
    {
        //create the key for dp
        StringBuffer keyBuffer = new StringBuffer(str1);
        keyBuffer.append(" ");
        keyBuffer.append(str2);
        String key = keyBuffer.toString();
        
        //if already calculated, return
        if (map.containsKey(key)) return map.get(key);
        
        //base cases
        if (str1.equals(str2)) return true;
        if (str1.length() == 1 && str2.length() == 1) return false;
        
        int lh = 0, rh = 0;
        boolean res = false;
        
        int n = str1.length(), i;
        int[] s1 = new int[n], s2 = new int[n];
        for (i = 0; i < n; ++i)
        {
            s1[i] = str1.charAt(i)-'a';
            s2[i] = str2.charAt(i)-'a';
        }
        
        //left to right
        lh = lh + (1<<s1[0]) - (1<<s2[0]);
        for (i = 1; i < n; ++i)
            rh = rh + (1<<s1[i]) - (1<<s2[i]);
        if (lh == rh && recur(str1.substring(0,1),str2.substring(0,1)) && recur(str1.substring(1),str2.substring(1)))
            res = true;
        for (i = 1; i < n-1; ++i)
        {
            rh = rh - (1<<s1[i]) + (1<<s2[i]);
            lh = lh + (1<<s1[i]) - (1<<s2[i]);
            if (lh == rh && recur(str1.substring(0,i+1),str2.substring(0,i+1)) && recur(str1.substring(i+1),str2.substring(i+1)))
                res = true;
        }
        
        //right to left
        lh = rh = 0;
        lh = lh + (1<<s1[0]) - (1<<s2[n-1]);
        int j;
        for (i = 1, j = n-2; i < n && j >= 0; ++i, --j)
            rh = rh + (1<<s1[i]) - (1<<s2[j]);
        if (lh == rh && recur(str1.substring(0,1),str2.substring(n-1)) && recur(str1.substring(1),str2.substring(0,n-1)))
            res = true;
        for (i = 1, j = n-2; i < n-1 && j > 0; ++i, --j)
        {
            rh = rh - (1<<s1[i]) + (1<<s2[j]);
            lh = lh + (1<<s1[i]) - (1<<s2[j]);
            if (lh == rh && recur(str1.substring(0,i+1),str2.substring(j)) && recur(str1.substring(i+1),str2.substring(0,j)))
                res = true;
        }
        map.put(key,res);
        return res;
    }
}