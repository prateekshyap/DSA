/*https://leetcode.com/problems/string-compression/*/

class Solution {
    public int compress(char[] chars) {
        StringBuilder build = new StringBuilder();
        char ch = chars[0];
        int count = 0;
        for (char curr : chars)
        {
            if (curr == ch)
                ++count;
            else
            {
                build.append(ch);
                if (count > 1) build.append(count);
                ch = curr;
                count = 1;
            }
        }
        build.append(ch);
        if (count > 1) build.append(count);
        for (int i = 0; i < build.length(); ++i)
            chars[i] = build.charAt(i);
        return build.length();
    }
}

class Solution {
    public int compress(char[] chars) {
        // StringBuilder build = new StringBuilder();
        int index = 0;
        char ch = chars[0];
        int count = 0;
        for (char curr : chars)
        {
            if (curr == ch)
                ++count;
            else
            {
                chars[index++] = ch;
                if (count > 1)
                {
                    int rev = 0, trailingZeros = 0;
                    while (count > 0)
                    {
                        rev = rev*10+(count%10);
                        if (count%10 == 0 && rev == 0) ++trailingZeros;
                        count /= 10;
                    }
                    while (rev > 0)
                    {
                        chars[index++] = (char)(rev%10+'0');
                        rev /= 10;
                    }
                    while (trailingZeros > 0)
                    {
                        chars[index++] = (char)(0+'0');
                        --trailingZeros;
                    }
                }
                ch = curr;
                count = 1;
            }
        }
        chars[index++] = ch;
        if (count > 1)
        {
            int rev = 0, trailingZeros = 0;
            while (count > 0)
            {
                rev = rev*10+(count%10);
                if (count%10 == 0 && rev == 0) ++trailingZeros;
                count /= 10;
            }
            while (rev > 0)
            {
                chars[index++] = (char)(rev%10+'0');
                rev /= 10;
            }
            while (trailingZeros > 0)
            {
                chars[index++] = (char)(0+'0');
                --trailingZeros;
            }
        }
        // for (int i = 0; i < build.length(); ++i)
        //     chars[i] = build.charAt(i);
        return index;
    }
}

