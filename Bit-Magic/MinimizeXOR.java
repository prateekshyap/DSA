/*https://leetcode.com/problems/minimize-xor/*/

class Solution {
    public int minimizeXor(int num1, int num2) {
        List<Integer> bitsNum1 = new ArrayList<Integer>();
        int copy1 = num1, setCountNum1 = 0;

        //add bits of num1 to a list
        while (copy1 > 0)
        {
            bitsNum1.add(copy1%2);
            if ((copy1&1) == 1)
                ++setCountNum1;
            copy1 >>= 1;
        }
        int copy2 = num2, setCountNum2 = 0;

        //count set bits in num2
        while (copy2 > 0)
        {
            if ((copy2&1) == 1)
                ++setCountNum2;
            copy2 >>= 1;
        }
        Collections.reverse(bitsNum1);
        // System.out.println(bitsNum1);
        // System.out.println(setCountNum1+" "+setCountNum2+" "+bitsNum1.size());
        int result = 0;

        //if the count of set bits in num2 is greater than the total number of bits in num1
        if (setCountNum2 > bitsNum1.size())
        {
        	//attach all extra set bits to the MSB
            int extra = setCountNum2-bitsNum1.size();
            for (int i = 0; i < extra; ++i)
            {
                result <<= 1;
                ++result;
            }
        }
        int len = bitsNum1.size();

        //for all the bits, if the corresponding bit of num1 is 1, append 1, else append 0
        for (int i = 0; i < len; ++i)
        {
            int bit = bitsNum1.get(i);
            if (setCountNum2 == 0) bit = 0;
            bitsNum1.set(i,bit);
            if (bit == 1)
                --setCountNum2;
        }

        //if still more set bits are remaining
        if (setCountNum2 > 0)
        {
        	//attach them in place of zeros in reverse direction
            for (int i = len-1; i >= 0; --i)
            {
                if (bitsNum1.get(i) == 0)
                {
                    bitsNum1.set(i,1);
                    --setCountNum2;
                }
                if (setCountNum2 == 0) break;
            }
        }

        //append the bits from MSB to LSB
        for (int i = 0; i < len; ++i)
        {
            result <<= 1;
            result += bitsNum1.get(i);
        }
        return result;
    }
}


//same approach but shorter and efficient code
class Solution {
    public int minimizeXor(int num1, int num2) {
        int bits = Integer.bitCount(num2);
        
        int result = 0;
        
        for (int i = 30; i >= 0 && bits > 0; --i){
            if (bits > 0 && ( (1 << i) & num1) != 0 ){
                --bits;
                result = result ^ (1 << i);
            }
        }
        
        for (int i = 0; i <= 30 && bits > 0; ++i){
            if (bits > 0 && ( (1 << i) & num1) == 0 ){
                --bits;
                result = result ^ (1 << i);
            }
        }
        
        return result;
    }
}