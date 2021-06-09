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