/*https://practice.geeksforgeeks.org/problems/find-the-missing-no-in-string/1*/

class GfG
{
    public int missingNumber(String s)
    {
        //add code here
        int i = 0;
        int digLen = 1, currDigLen = 1;
        int currNum = -1;
        int missingNumber = -1;
        int diff = 0;
        boolean result = true;
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        while (digLen <= 6) //for each possible length
        {
            i = 0; //reset i
            currNum = -1; //reset current number
            missingNumber = -1; //reset missing number
            diff = 0; //reset difference
            result = true; //set result to true
            list = new ArrayList<Integer>(); //create a new arraylist
            while (i < s.length()) //traverse the whole string
            {
                currNum = Integer.parseInt(s.substring(i,Math.min(i+currDigLen,s.length()))); //get the next number
                i += currDigLen; //increment i
                if (currNum == 9 || currNum == 99 || currNum == 999 || currNum == 9999 || currNum == 99999 || currNum == 999999) ++currDigLen; //increment the current digit length if current number is 9999...
                else if ((currNum == 8 || currNum == 98 || currNum == 998 || currNum == 9998 || currNum == 99998 || currNum == 999998) && i < s.length() && s.charAt(i) == '1') ++currDigLen; //increment the current digit length if the current number is the previous number of 9999... and  9999... is missing
                list.add(currNum); //add current number to the list
            }
            for (i = 0; i < list.size()-1; ++i) //for each number in the list
            {
                if ((Integer)list.get(i+1)-(Integer)list.get(i) < 0) //if the next number is smaller
                {
                    result = false; //no sequence can be formed
                    break;
                }
                diff += (Integer)list.get(i+1)-(Integer)list.get(i)-1; //add the difference of the numbers
                if (diff == 1 && missingNumber == -1) //if difference is 1 and we have not found the missing number yet
                {
                    missingNumber = (Integer)list.get(i)+1; //update the missing number
                }
                else if (diff > 1) //if difference is greater than 1
                {
                    result = false; //no sequence can be formed
                    break;
                }
            }
            if (result) return missingNumber; //if result is still true, return the missing number
            ++digLen; //increment digit length
            currDigLen = digLen; //update current digit length to digit length
        }
        
        return -1; //return -1 at the end
    }
}