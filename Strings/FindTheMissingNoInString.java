class GfG
{
	public int missingNumber(String s)
    {
        //add code here
        int covered = 0, i = 0;
        int digLen = 1, currDigLen = 1;
        int currNum = -1;
        int missingNumber = -1;
        int diff = 0;
        boolean result = true;
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        while (digLen <= 6)
        {
            i = 0;
            currNum = -1;
            missingNumber = -1;
            diff = 0;
            result = true;
            list = new ArrayList<Integer>();
            while (i < s.length())
            {
                currNum = Integer.parseInt(s.substring(i,Math.min(i+currDigLen,s.length())));
                i += currDigLen;
                if (currNum == 9 || currNum == 99 || currNum == 999 || currNum == 9999 || currNum == 99999 || currNum == 999999) ++currDigLen;
                list.add(currNum);
            }
            System.out.println(list);
            for (i = 0; i < list.size()-1; ++i)
            {
                if ((Integer)list.get(i+1)-(Integer)list.get(i) < 0)
                {
                    result = false;
                    break;
                }
                diff += (Integer)list.get(i+1)-(Integer)list.get(i)+1;
                System.out.println(diff);
                if (diff == 1)
                {
                    missingNumber = (Integer)list.get(i)+1;
                }
                else if (diff > 1)
                {
                    result = false;
                    break;
                }
            }
            if (result) return missingNumber;
            ++digLen;
            currDigLen = digLen;
        }
        
        return -1;
    }
}
