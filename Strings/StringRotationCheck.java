/*https://leetcode.com/problems/rotate-string/*/

/*Prateekshya's Solution*/

class Solution {
    public boolean rotateString(String s, String goal) {
        if (s.length() == 0 && goal.length() == 0) return true;
        if (s.length() == 0 || goal.length() == 0) return false;
        if (goal.length() != s.length()) return false;
        
        //concatenate s with s
        String concat = s+s;
        for (int i = 0; i < s.length(); ++i)

        	//if goal is a substring of the concatenated string then return true
            if (goal.equalsIgnoreCase(concat.substring(i,i+goal.length())))
                return true;
        return false;
    }
}

/*Pratik's Solution*/

class Solution {
    public boolean rotateString(String s, String goal) 
    {
        if(s.length()!=goal.length())return false;
        if(s.length()==0 || s.equals(goal))return true;
        int i = 0 , n = s.length();
        while(i!=n)
        {
            if((s.substring(i,n)).equals(goal.substring(0,(n-i))))
            {
                if((goal.substring(n-i,n)).equals(s.substring(0,i)))return true;
            }
            i++;
        }
        return false;
    }
}