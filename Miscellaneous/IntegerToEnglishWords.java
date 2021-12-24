/*https://leetcode.com/problems/integer-to-english-words/*/

class Solution {
    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        StringBuffer numStr = new StringBuffer(Integer.toString(num));
        String[] parts = new String[numStr.length()%3 == 0 ? numStr.length()/3 : (numStr.length()/3)+1];
        int index = parts.length-1;
        for (int i = numStr.length(); i > 0; i -= 3)
            parts[index--] = i-3 < 0 ? numStr.substring(0,i) : numStr.substring(i-3,i);
        
        StringBuffer compiledResult = new StringBuffer("");
        
        String[] names = {" Thousand"," Million"," Billion"};
        int namesIndex = -1;
        
        for (int i = parts.length-1; i >= 0; --i)
        {
            if (parts[i].equals("000") && i != 0) //continue if it is completely zero till the last index
            {
                ++namesIndex;
                continue;
            }
            
            int len = parts[i].length();
            StringBuffer currPart = new StringBuffer("");
            
            if (len == 1 || len == 3)
            {
                int trigger = Integer.parseInt(Character.toString(parts[i].charAt(0)));
                if (trigger != 0)
                {
                    switch (trigger)
                    {
                        case 1:
                            currPart.append(" One");
                            break;
                        case 2:
                            currPart.append(" Two");
                            break;
                        case 3:
                            currPart.append(" Three");
                            break;
                        case 4:
                            currPart.append(" Four");
                            break;
                        case 5:
                            currPart.append(" Five");
                            break;
                        case 6:
                            currPart.append(" Six");
                            break;
                        case 7:
                            currPart.append(" Seven");
                            break;
                        case 8:
                            currPart.append(" Eight");
                            break;
                        case 9:
                            currPart.append(" Nine");
                            break;
                    }
                    if (len == 3) currPart.append(" Hundred");
                }
            }

            if (len == 2 || len == 3)
            {
                int trigger = Integer.parseInt(Character.toString(parts[i].charAt(parts[i].length()-2)));
                int number = Integer.parseInt(parts[i].substring(parts[i].length()-2,parts[i].length()));
                switch (trigger)
                {
                    case 1:
                        switch (number)
                        {
                            case 10:
                                currPart.append(" Ten");
                                break;
                            case 11:
                                currPart.append(" Eleven");
                                break;
                            case 12:
                                currPart.append(" Twelve");
                                break;
                            case 13:
                                currPart.append(" Thirteen");
                                break;
                            case 14:
                                currPart.append(" Fourteen");
                                break;
                            case 15:
                                currPart.append(" Fifteen");
                                break;
                            case 16:
                                currPart.append(" Sixteen");
                                break;
                            case 17:
                                currPart.append(" Seventeen");
                                break;
                            case 18:
                                currPart.append(" Eighteen");
                                break;
                            case 19:
                                currPart.append(" Nineteen");
                                break;
                        }
                        break;
                    case 2:
                        currPart.append(" Twenty");
                        break;
                    case 3:
                        currPart.append(" Thirty");
                        break;
                    case 4:
                        currPart.append(" Forty");
                        break;
                    case 5:
                        currPart.append(" Fifty");
                        break;
                    case 6:
                        currPart.append(" Sixty");
                        break;
                    case 7:
                        currPart.append(" Seventy");
                        break;
                    case 8:
                        currPart.append(" Eighty");
                        break;
                    case 9:
                        currPart.append(" Ninety");
                        break;
                }

                if (trigger != 1)
                {
                    trigger = Integer.parseInt(Character.toString(parts[i].charAt(parts[i].length()-1)));
                    switch (trigger)
                    {
                        case 1:
                            currPart.append(" One");
                            break;
                        case 2:
                            currPart.append(" Two");
                            break;
                        case 3:
                            currPart.append(" Three");
                            break;
                        case 4:
                            currPart.append(" Four");
                            break;
                        case 5:
                            currPart.append(" Five");
                            break;
                        case 6:
                            currPart.append(" Six");
                            break;
                        case 7:
                            currPart.append(" Seven");
                            break;
                        case 8:
                            currPart.append(" Eight");
                            break;
                        case 9:
                            currPart.append(" Nine");
                            break;
                    }
                }
            }

            if (namesIndex >= 0)
                currPart.append(names[namesIndex]);
            ++namesIndex;
            currPart.append(compiledResult);
            compiledResult = currPart;
        }

        return compiledResult.toString().trim();
    }
}