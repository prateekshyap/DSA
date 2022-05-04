/*https://practice.geeksforgeeks.org/problems/run-length-encoding/1*/

class GfG
 {
	String encode(String str)
	{
        //Your code here
        int n = str.length();
        StringBuffer result = new StringBuffer("");
        int count = -1;
        for (int i = 0; i < n; ++i)
        {
            if (result.length() >= 1 && result.charAt(result.length()-1) == str.charAt(i)) ++count;
            else if (count != -1)
            {
                result.append(Integer.toString(count+1)); count = 0;
                result.append(str.charAt(i));
            }
            else
            {
                result.append(str.charAt(i));
            }
            if (i == 0) count = 0;
        }
        result.append(Integer.toString(count+1));
        
        return result.toString();  
	}
}