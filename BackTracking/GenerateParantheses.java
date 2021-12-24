/*https://leetcode.com/problems/generate-parentheses/*/

/*prateekshya's solution*/

class Solution {
    Set<String> h;
    Solution()
    {
        h = new HashSet<String>();
    }
    public List<String> generateParenthesis(int n) {
        Solution s = new Solution();
        s.generateParentheses(n-1,new StringBuilder("()"));
        return new ArrayList<String>(s.h);
    }
    public void generateParentheses(int rem, StringBuilder curr)
    {
        if (rem == 0)
        {
            h.add(new String(curr));
            return;
        }
        for (int i = 0; i <= curr.length()/2; ++i)
        {
            StringBuilder newStr = new StringBuilder(curr.substring(0,i));
            newStr.append("()");
            newStr.append(curr.substring(i));
            generateParentheses(rem-1,newStr);
        }
    }
}

//better solution
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        generate(n,0,0,list,"");
        return list;
    }
    public void generate(int n, int l, int r, List<String> list, String s)
    {
        if (s.length() == 2*n)
        {
            list.add(s);
            return;
        }

        if (l<n) generate(n,l+1,r,list,s+"(");
        if (r<l) generate(n,l,r+1,list,s+")");
    }
}

/*pratik's solution*/

import java.io.*;
import java.util.*;

class Solution {
    List<String> list = new ArrayList<String>();
    public List<String> generateParenthesis(int n) 
    {
        generateParenthesisUtil(new StringBuilder(),n,n);
        return list;
    }
    public void generateParenthesisUtil(StringBuilder cur,int open,int close)
    {
        if(close==0 && open==0)
        {
            list.add(cur.toString());
            return;
        }
        
        if(open>0)
        {
            generateParenthesisUtil(cur.append('('),open-1,close);
            cur.setLength(cur.length()-1);
        }
        if(open<close)
        {
            generateParenthesisUtil(cur.append(')'),open,close-1);
            cur.setLength(cur.length()-1);
        }
    }
}
class GenerateParantheses
{
    public static void main(String pp[])throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the length of the string you want to generate with balanced parantheses : ");
        int n = Integer.parseInt(br.readLine());
        while(n%2!=0)
        {
            System.out.println("Enter an even number : ");
            n = Integer.parseInt(br.readLine());
        }
        Solution s = new Solution();
        List<String> list = s.generateParenthesis(n/2);
        System.out.println(list);
    }
}