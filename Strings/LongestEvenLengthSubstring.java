/*https://practice.geeksforgeeks.org/problems/longest-even-length-substring/0*/

import java.lang.*;
import java.io.*;
class GFG
{
    public static void main (String[] args) throws IOException
    {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(br.readLine());
        String str;
        int i, len, currLen = 0, maxLen = 0, leftSum, rightSum;
        int[] arr;
        for (int ii = 0; ii < cases; ++ii)
        {
            maxLen = 0;
            currLen = 0;
            str = br.readLine();
            arr = new int[str.length()];
            for (i = 0; i < str.length(); ++i)
                arr[i] = Integer.parseInt(Character.toString(str.charAt(i)));
            for (i = 0; i < str.length(); ++i) //for each index
            {
                len = leftSum = rightSum = currLen = 0; //reset length and sums
                while (i-len >= 0 && i+len+1 < str.length()) //check if the substring can be extended in both the sides
                {
                    ++len; //extend it
                    leftSum += arr[i-len+1]; //increase left sum
                    rightSum += arr[i+len]; //increase right sum
                    if (leftSum == rightSum) maxLen = Math.max(maxLen,len*2); //update length
                }
            }
            System.out.println(maxLen);
        }
    }
}