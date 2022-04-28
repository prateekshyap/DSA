/*https://www.hackerrank.com/challenges/sherlock-and-anagrams/*/

class Result {
    public static int sherlockAndAnagrams(String text) {
    // Write your code here
        ArrayList<String> list = new ArrayList<>();
        int len = text.length();
        int counter = 0;
        //add all substrings to arraylist
        for (int j = 0; j < len; ++j)
        {
            for (int sub = 1; sub <= len-j; ++sub)
            {
                String subPart = text.substring(j,j+sub);
                list.add(subPart);
            }
        }
        for (int j = 0; j < list.size(); ++j)
        {
            String element = list.get(j); //for each substring in the list
            for (int k = j+1; k < list.size(); ++k) //for all remaining substrings
            {
                if (isAnagram(list.get(k), element)) //if anagrams, increment counter
                    counter++;
            }
        }

        return counter;
    }
    public static boolean isAnagram(String a, String b){
        if (a.length() != b.length())
            return false;
        int[] lettermap = new int[26];
        for (int j = 0; j < a.length(); ++j)
        {
            char ch = a.charAt(j);
            ++lettermap[ch-'a'];
            ch = b.charAt(j);
            --lettermap[ch-'a'];
        }

        for (int j = 0; j < lettermap.length; ++j)
            if (lettermap[j] != 0)
                return false;
        return true;
    }
}