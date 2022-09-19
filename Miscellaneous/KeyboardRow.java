/*https://leetcode.com/problems/keyboard-row/*/

class Solution {
    public String[] findWords(String[] words) {
        int[] rows = new int[]{2,3,3,2,1,2,2,2,1,2,2,2,3,3,1,1,1,1,2,1,1,3,1,3,1,3};
        List<String> result = new ArrayList<String>();
        for (String word : words)
        {
            boolean flag = true;
            String copy = word;
            word = word.toLowerCase();
            int row = rows[word.charAt(0)-'a'];
            for (char ch : word.toCharArray())
            {
                if (row != rows[ch-'a'])
                {
                    flag = false;
                    break;
                }
            }
            if (flag) result.add(copy);
        }
        String[] finalArr = new String[result.size()];
        for (int i = 0; i < result.size(); ++i)
            finalArr[i] = result.get(i);
        return finalArr;
    }
}