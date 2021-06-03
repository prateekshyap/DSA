/*https://leetcode.com/problems/count-and-say/*/

class Solution {
    public String countAndSay(int n) {
        if (n == 1) return "1";
        StringBuilder str = new StringBuilder("1");
        while (n > 1)
        {
            StringBuilder say = new StringBuilder("");
            int count = 0;
            char curr = '0';
            for (int i = 0; i < str.length(); ++i)
            {
                //if current character is not same as the previous
                if (curr != str.charAt(i))
                {
                    //update the say
                    if (curr != '0')
                    {
                        say.append(count);
                        say.append(curr);
                    }

                    //update the curr and count
                    curr = str.charAt(i);
                    count = 1;
                }

                //if same then increment count
                else
                {
                    ++count;
                }
            }

            //update the say
            if (curr != '0')
            {
                say.append(count);
                say.append(curr);
            }

            //store it as str for next iteration
            str = new StringBuilder(say);

            //decrease n
            --n;
        }
        return new String(str);
    }
}