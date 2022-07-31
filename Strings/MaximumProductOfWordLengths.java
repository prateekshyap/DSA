/*https://leetcode.com/problems/maximum-product-of-word-lengths/*/

class Solution {
    public int maxProduct(String[] words) {
        int max = 0, n = words.length, i = 0, j = 0;
        int[] hash = new int[n];
        for (i = 0; i < n; ++i)
        {
            for (char ch : words[i].toCharArray())
            {
                hash[i] |= 1<<ch-'a';
            }
        }
        for (i = 0; i < n; ++i)
        {
            for (j = 0; j < i; ++j)
            {
                if ((hash[i]&hash[j]) == 0)
                {
                    max = Math.max(max,words[i].length()*words[j].length());
                }
            }
        }
        return max;
    }
}

class Solution {
    public String removeKdigits(String num, int k) {
        int n=num.length();
        int end=n-k;
        char[] arr=new char[n];
        int idx=0;
        for(char c: num.toCharArray()){
            while(idx>0&&arr[idx-1]>c&&k>0){
                k--;
                idx--;
            }
            arr[idx++]=c;
        }
      
        idx=0;
        while(idx<end&&arr[idx]=='0')idx++;
        
        return idx==end ? "0": new String(arr,idx,end-idx);
        
    }
}