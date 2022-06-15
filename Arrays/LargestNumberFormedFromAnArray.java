/*https://practice.geeksforgeeks.org/problems/largest-number-formed-from-an-array1117/1/*/

class Solution {
    String printLargest(String[] arr) {
        // code here
        Arrays.sort(arr, new Comparator<String>()
        {
            public int compare(String s1, String s2)
            {
                int i = 0, j = 0;
                char ch1, ch2;
                while (i < s1.length() && j < s2.length())
                {
                    ch1 = s1.charAt(i);
                    ch2 = s2.charAt(j);
                    if (ch1 == ch2)
                    {
                        ++i;
                        ++j;
                    }
                    else
                    {
                        if (ch1 > ch2) return -1;
                        return 1;
                    }
                }
                if (i == s1.length() && j == s2.length()) return 0;
                int res1 = Integer.parseInt(s1+s2);
                int res2 = Integer.parseInt(s2+s1);
                return res2-res1;
            }
        });
        
        StringBuffer buffer = new StringBuffer("");
        int i, n = arr.length;
        
        for (i = 0; i < n; ++i) buffer.append(arr[i]);
        return buffer.toString();
    }
}

//another solution with almost same time
class Solution {
    String printLargest(String[] arr) {
        // code here
        Arrays.sort(arr, new Comparator<String>()
        {
            public int compare(String X, String Y)
            {
                // first append Y at the end of X
                String XY = X + Y;

                // then append X at the end of Y
                String YX = Y + X;

                // Now see which of the two
                // formed numbers
                // is greater
                return XY.compareTo(YX) > 0 ? -1 : 1;
            }
        });
        
        StringBuffer buffer = new StringBuffer("");
        int i, n = arr.length;
        
        for (i = 0; i < n; ++i) buffer.append(arr[i]);
        return buffer.toString();
    }
}