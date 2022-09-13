/*https://leetcode.com/problems/utf-8-validation/*/

class Solution {
    public boolean validUtf8(int[] data) {
        int rem = 0;
        for (int d : data)
        {
            if (rem == 0)
            {
                if ((d >> 7) == 0b0)
                    continue;
                else if ((d >> 5) == 0b110)
                    rem = 1;
                else if ((d >> 4) == 0b1110)
                    rem = 2;
                else if ((d >> 3) == 0b11110)
                    rem = 3;
                else return false;
            }
            else
            {
                if ((d >> 6) == 0b10)
                    --rem;
                else return false;
            }
        }
        return rem == 0;
    }
}

class Solution {
    public boolean validUtf8(int[] data) 
    {
        if (data == null || data.length == 0) return false;
        boolean isValid = true;
        for (int i = 0; i < data.length; ++i)
        {
            if (data[i] > 255) return false; // 1 after 8th digit, 100000000
            int numberOfBytes = 0;
            if ((data[i] & 128) == 0) // 0xxxxxxx, 1 byte, 128(10000000)
                numberOfBytes = 1;
            else if ((data[i] & 224) == 192) // 110xxxxx, 2 bytes, 224(11100000), 192(11000000)
                numberOfBytes = 2;
            else if ((data[i] & 240) == 224) // 1110xxxx, 3 bytes, 240(11110000), 224(11100000)
                numberOfBytes = 3;
            else if ((data[i] & 248) == 240) // 11110xxx, 4 bytes, 248(11111000), 240(11110000)
                numberOfBytes = 4;
            else
                return false;
        
            for (int j = 1; j < numberOfBytes; ++j)
            { // check that the next n bytes start with 10xxxxxx
                if (i+j >= data.length) return false;
                if ((data[i+j] & 192) != 128) return false; // 192(11000000), 128(10000000)
            }
            i = i+numberOfBytes-1;
        }
        return isValid;
    }
}