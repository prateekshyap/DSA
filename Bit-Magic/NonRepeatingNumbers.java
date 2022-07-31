/*https://practice.geeksforgeeks.org/problems/finding-the-numbers0215/1#*/

class Solution
{
    public int[] singleNumber(int[] nums)
    {
        int aXorb=0, test = 1, count = 0;
        for (int key : nums) aXorb^=key;
        int temp = aXorb;
        
        //find the mass of rightmost setbit of the xor
        while ((aXorb&1) != 1)
        {
            aXorb >>= 1;
            ++count;
        }
        test <<= count;
        aXorb = temp;
        
        int a = 0, b = 0;
        //check whose that bit is on
        for(int key:nums)
            if((key&test)==0)//that bit was off in this element
                a^=key;
            else//that bit it was on in this element
                b^=key;
        int ans[]=new int[2];
        if(a<b){
            ans[0]=a;
            ans[1]=b;
        }else{
            ans[0]=b;
            ans[1]=a;
        }
        return ans;
    }
}