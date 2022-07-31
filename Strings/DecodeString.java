/*https://leetcode.com/problems/decode-string/*/

class Solution {
    public String decodeString(String s) {
        char[] arr = s.toCharArray();
        StringBuilder result = new StringBuilder("");
        int i = 0;
        int[] range;
        while (i < s.length()) //till the string is exhausted
        {
            range = getNextRange(arr,i); //get the range for parsing
            result.append(buildString(arr,range[0])); //recursion call and append to final string
            i = range[1]+1; //increment the index
        }
        return result.toString();
    }
    public StringBuilder buildString(char[] arr, int index)
    {
        StringBuilder token = new StringBuilder(""), result = new StringBuilder("");
        
        if (isAlpha(arr[index])) //if the current index is an alphabet
        {
            result.append(arr[index]); //append
            return result; //return
        }
        
        int repeat = 0, i;
        while (isNumber(arr[index])) //find out the number first
        {
            repeat *= 10;
            repeat += arr[index]-'0';
            ++index;
        }
        ++index; //cross the opening bracket
        int bCount = 1; //set bracket count to 1
        int[] range;
        while (bCount != 0) //till the closing bracket is found
        {
            range = getNextRange(arr,index); //get the next range for parsing
            token.append(buildString(arr,range[0])); //recursion call and append to final string
            index = range[1]+1; //increment the index
            if (arr[index] == ']') --bCount; //decrease the count if closing bracket faced
        }
        for (i = 0; i < repeat; ++i) //append the current token required number of times
            result.append(token);
        
        return result;
    }
    private boolean isNumber(char ch)
    {
        if (ch >= '0' && ch <= '9') return true;
        return false;
    }
    private boolean isAlpha(char ch)
    {
        if (ch >= 'a' && ch <= 'z') return true;
        return false;
    }
    private int[] getNextRange(char[] arr, int index)
    {
        int[] range = new int[2];
        if (isAlpha(arr[index])) //if current index is alphabet
            range[0] = range[1] = index; //both start and end will be the index itself
        else //otherwise
        {
            boolean flag = true;
            int count = 0;
            range[0] = range[1] = index; //start from index
            while (flag || count != 0) //till brackets are balanced
            {
                if (arr[range[1]] == '[') { ++count; flag = false; }
                else if (arr[range[1]] == ']') --count;
                ++range[1]; //increment end
            }
            --range[1]; //decrease end by 1
        }
        return range;
    }
}

class Solution {
    private int index = 0;
    public String decodeString(String s) {
        StringBuilder result = new StringBuilder();
        while (index < s.length() && s.charAt(index) != ']')
        {
            if (!Character.isDigit(s.charAt(index)))
                result.append(s.charAt(index++));
            else
            {
                int k = 0;
                while (index < s.length() && Character.isDigit(s.charAt(index)))
                    k = k * 10 + s.charAt(index++) - '0';
                ++index;
                String decodedString = decodeString(s);
                ++index;
                
                while (k-- > 0)
                    result.append(decodedString);
            }
        }
        return result.toString();
    }
}