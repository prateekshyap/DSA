/*https://practice.geeksforgeeks.org/problems/implement-atoi/1*/

class Solution
{
    int atoi(String str)
    {
    	//store the sign 
        boolean sign = false;
        if (str.charAt(0) == '-')
        {
            sign = true;
            str = str.substring(1);
        }

        //find out the integer
	    int result = 0;
	    for (int i = 0; i < str.length(); ++i)
	    {
	        if (str.charAt(i) < '0' || str.charAt(i) > '9') return -1;
	        result *= 10;
	        result += str.charAt(i)-'0';
	    }
	    
	    //add the sign
	    if (sign) result *= -1;
	    return result;
    }
}