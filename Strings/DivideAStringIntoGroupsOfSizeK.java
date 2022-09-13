/*https://leetcode.com/problems/divide-a-string-into-groups-of-size-k/*/

class Solution {
    public String[] divideString(String s, int k, char fill) {
        int stringLength = s.length(), resultLength;
        if (stringLength%k == 0) resultLength = stringLength/k;
        else resultLength = (stringLength/k)+1;
        String[] result = new String[resultLength];
        int i = 0, j = 0;
        while (j < resultLength)
        {
            StringBuilder build = new StringBuilder("");
            int count = 1;
            for (; count <= k; ++count, ++i)
                build.append(i < stringLength ? s.charAt(i) : fill);
            result[j++] = build.toString();
        }
        return result;
    }
}