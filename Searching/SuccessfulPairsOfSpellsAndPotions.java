/*https://leetcode.com/problems/successful-pairs-of-spells-and-potions/*/

class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int s, low, high, mid, sLen = spells.length, pLen = potions.length, p = -1;
        int[] result = new int[sLen];
        for (s = 0; s < sLen; ++s)
        {
            if ((long)spells[s]*(long)potions[0] >= success) result[s] = pLen;
            else if ((long)spells[s]*(long)potions[pLen-1] < success) result[s] = 0;
            else
            {
                low = 0;
                high = pLen-1;
                while (low <= high)
                {
                    mid = low+(high-low)/2;
                    if ((long)spells[s]*(long)potions[mid] >= success)
                    {
                        p = mid;
                        high = mid-1;
                    }
                    else low = mid+1;
                }
                result[s] = pLen-p;
            }
        }
        return result;
    }
}

class Solution {
    public int[] successfulPairs(int[] spell, int[] potion, long success) {
        int i, s, low, high, mid, sLen = spell.length, pLen = potion.length, p = -1;
        long[] spells = new long[sLen], potions = new long[pLen];
        for (i = 0; i < sLen; ++i) spells[i] = (long)spell[i];
        for (i = 0; i < pLen; ++i) potions[i] = (long)potion[i];
        Arrays.sort(potions);
        int[] result = new int[sLen];
        for (s = 0; s < sLen; ++s)
        {
            if (spells[s]*potions[0] >= success) result[s] = pLen;
            else if (spells[s]*potions[pLen-1] < success) result[s] = 0;
            else
            {
                low = 0;
                high = pLen-1;
                while (low <= high)
                {
                    mid = low+(high-low)/2;
                    if (spells[s]*potions[mid] >= success)
                    {
                        p = mid;
                        high = mid-1;
                    }
                    else low = mid+1;
                }
                result[s] = pLen-p;
            }
        }
        return result;
    }
}