/*https://leetcode.com/problems/longest-happy-string/*/

class Solution {
    public String longestDiverseString(int a, int b, int c) {
        int totalSize = a+b+c;
        int aStreak = 0;
        int bStreak = 0;
        int cStreak = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < totalSize; ++i)
        {
            if ((a >= b && a >= c && aStreak < 2) || // if a is the LARGEST and CURRENTLY the number of CONSECUTIVE A's are less than 2 since can only have 2 consecutive
                (bStreak == 2 && a > 0 && aStreak < 2) || // B has come 2 times CONSECUTIVELY and 'a' CAN still be added and CONSECUTIVE As currently is less than 2
                (cStreak == 2 && a > 0 && aStreak < 2)) { // C has come 2 times CONSECUTIVELY and 'a' CAN still be added and CONSECUTIVE As currently is less than 2
                
                sb.append('a'); // append 'a' if any of the above condition satisfies, basically we can freely add 'a' without breaking any rule
                a--; // in next step, 1 LESS 'a' needs to be handled
                aStreak++; // since we have added 'a' just now, the consecutive count of 'a' needs to be upated 
                // since we just added 'a' in the string, so the consecutive B and C does not matter anymore so make them 0
                bStreak = 0; 
                cStreak = 0;
            }
            
            else if ((b >= a && b >= c && bStreak < 2) || 
                     (aStreak == 2 && b > 0 && bStreak < 2) || 
                     (cStreak == 2 && b > 0 && bStreak < 2)) {
                
                sb.append('b');
                b--;
                bStreak++;
                aStreak = 0;
                cStreak = 0;
            }
            else if ((c >= a && c >= b && cStreak < 2) || 
                     (aStreak == 2 && c > 0 && cStreak < 2) || 
                     (bStreak == 2 && c > 0 && cStreak < 2)) {
                
                sb.append('c');
                c--;
                cStreak++;
                aStreak = 0;
                bStreak = 0;
            }
        }
        return sb.toString();
    }
}