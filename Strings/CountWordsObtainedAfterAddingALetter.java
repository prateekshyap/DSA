/*https://leetcode.com/problems/count-words-obtained-after-adding-a-letter/*/

//hash solution
class Solution {
    public int wordCount(String[] startWords, String[] targetWords) {
        HashSet<String> set = new HashSet<>();
        
        //add all start words in sorted order to check whether targetWords can be formed
        for(String s: startWords){
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            set.add(new String(chars));
        }
        
        int count=0;
        
        for(String t: targetWords){
            char[] chars = t.toCharArray();
            Arrays.sort(chars);
            
            String newWord = new String(chars);
            
            int wordLen = newWord.length();
            
            for(int i=0;i<wordLen;i++){
                
                //removing one char and checking if they exist in my hashSet 
                String str = newWord.substring(0,i) + newWord.substring(i+1);
                
                if(set.contains(str))
                {
                    count++;
                    break;
                }
            }
        }
        
        return count;
    }
}

// TLE
// class Solution {
//     public int wordCount(String[] startWords, String[] targetWords) {
//         int s = startWords.length, t = targetWords.length, i, j, diff, count = 0;
//         int[][] hash = new int[t][26];
//         int[] sHash = new int[26];
//         Set<String> set = new HashSet<String>();
//         for (i = 0; i < t; ++i)
//             for (j = 0; j < targetWords[i].length(); ++j)
//                 ++hash[i][targetWords[i].charAt(j)-'a'];
//         for (i = 0; i < t; ++i)
//         {
//             for (String word : startWords)
//             {
//                 diff = 0;
//                 if (targetWords[i].length() == word.length()+1)
//                 {
//                     sHash = new int[26];
//                     for (j = 0; j < word.length(); ++j)
//                         ++sHash[word.charAt(j)-'a'];
//                     for (j = 0; j < 26; ++j)
//                     {
//                         if (sHash[j] != hash[i][j] && sHash[j] == 0)
//                         {
//                             ++diff;
//                             //if (sHash[j] > 0 && hash[i][j] > 0) ++diff;
//                         }
//                         if (diff > 1) break;
//                     }
//                     if (diff == 1)
//                     {
//                         //System.out.println(word+" -> "+targetWords[i]);
//                         //if (!set.contains(targetWords[i]))
//                         //{
//                             ++count; break;
//                             //set.add(targetWords[i]);
//                         //}
//                     }
//                 }
//             }
//         }
//         return count;
//     }
// }

//bit solution
class Solution {
     public int wordCount(String[] startWords, String[] targetWords) {
        int ans = 0, m = 0;
        Set<Integer> hs = new HashSet<>();
        
        for(String w: startWords){
            m = 0;
            for(char c: w.toCharArray()) {
                m |= (1<< (c-'a'));     
            }
            hs.add(m);
        }
        for(String w: targetWords){
            m = 0;
            for(char c: w.toCharArray()) m |= (1<< (c-'a'));
            for(char c: w.toCharArray()){
                if(hs.contains(m - (1<< (c-'a')))){
                    ans++;
                    break;
                }
            }
        }
        return ans;
    }
}