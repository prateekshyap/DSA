/*https://leetcode.com/problems/letter-case-permutation/*/

/*Prateekshya*/

class Solution {
    List<String> result;
    public List<String> letterCasePermutation(String s) {
        result = new ArrayList<String>();
        recur(s.toCharArray(),0,new StringBuffer(""));
        return result;
    }
    public void recur(char[] chars, int index, StringBuffer curr)
    {
    	//if all the characters are added, add it to the result and return
        if (index == chars.length)
        {
            result.add(new String(curr));
            return;
        }

        //get the ascii of the current character
        int ascii = (int)chars[index];

        //if the ascii lies between alphabets' range
        if ((ascii >= 65 && ascii <=90) || (ascii >= 97 && ascii <= 122))
        {
        	//get both case characters
            char ch1 = chars[index];
            char ch2 = ascii >= 65 && ascii <=90 ? (char)(ascii+32) : (char)(ascii-32);

            //recur by adding first character
            curr.append(ch1);
            recur(chars, index+1, curr);
            curr.delete(curr.length()-1,curr.length());
            
            //recur by adding second character
            curr.append(ch2);
            recur(chars, index+1, curr);
            curr.delete(curr.length()-1,curr.length());
        }

        //if not alphabet
        else
        {
        	//add the charcter and recur, no permutations needed
            curr.append(chars[index]);
            recur(chars, index+1, curr);
            curr.delete(curr.length()-1,curr.length());
        }
    }
}