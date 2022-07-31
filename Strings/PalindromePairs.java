/*https://leetcode.com/problems/palindrome-pairs/*/

class Solution {
    class PalindromePair {
        String palindrome;
        int x;
        int y;
        PalindromePair(String palindrome, int x, int y) {
            this.palindrome = palindrome;
            this.x = x;
            this.y = y;
        }
    } 
    public List<List<Integer>> palindromePairs(String[] words) {
        HashMap<String, Integer> wordMap = new HashMap<>();
        Set<Integer> set = new TreeSet<>();
        int N = words.length;
        for(int i = 0; i < N; i++) {
            wordMap.put(words[i], i);
            set.add(words[i].length());
        }

        List<List<Integer>> result = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            int length = words[i].length(); //get the length of the current word
            if(length == 1) { //if length is 1
                if(wordMap.containsKey("")) { //if empty string is present in the list
                    result.add(Arrays.asList(i, wordMap.get(""))); //add to result
                    result.add(Arrays.asList(wordMap.get(""), i)); //add to result
                }
                continue;
            }
            String reverse = reverse(words[i]); //reverse the current string
            if(wordMap.containsKey(reverse) && wordMap.get(reverse) != i) { //if reverse is present in the list && index is not same
                result.add(Arrays.asList(i, wordMap.get(reverse))); //add to result
            }
            for(Integer k: set) { //for all lengths of words
                if(k == length) break; //if length is same as current word length then break
                
                if(isPalindrome(reverse, 0, length - 1 - k)) { //if the initial part of the reverse of current word is a palindrome
                    String s1 = reverse.substring(length-k); //and the remaining part is present in the list
                    if(wordMap.containsKey(s1)) result.add(Arrays.asList(i, wordMap.get(s1))); //add to result
                }
                
                if(isPalindrome(reverse, k, length - 1)) { //if the ending part of the reverse of current word is a palindrome
                    String s2 = reverse.substring(0, k); //and the initial part is present in the list
                    if(wordMap.containsKey(s2)) result.add(Arrays.asList(wordMap.get(s2), i)); //add to result
                }
            }
        }
       
        
        return result;
    }
    
    private boolean isPalindrome(String s, int left, int right) {
        while(left < right) {
            if(s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        
        return true;
    }
    
    private String reverse(String s) {
        return new StringBuilder(s).reverse().toString(); 
    }
    
}