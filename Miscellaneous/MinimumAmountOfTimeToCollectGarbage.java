/*https://leetcode.com/problems/minimum-amount-of-time-to-collect-garbage/*/

class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int T = travel.length, G = garbage.length, lastM = -1, lastP = -1, lastG = -1, result = 0, i, j;
        int[] preTravel = new int[T], preM = new int[G], preP = new int[G], preG = new int[G], mCount = new int[G], pCount = new int[G], gCount = new int[G];
        preTravel[0] = travel[0];
        for (i = 1; i < T; ++i)
            preTravel[i] = preTravel[i-1]+travel[i];
        for (i = 0; i < G; ++i)
        {
            for (char ch : garbage[i].toCharArray())
            {
                if (ch == 'M')
                {
                    ++mCount[i];
                    lastM = i;
                }
                else if (ch == 'P')
                {
                    ++pCount[i];
                    lastP = i;
                }
                else
                {
                    ++gCount[i];
                    lastG = i;
                }
            }
        }
        preM[0] = mCount[0];
        for (i = 1; i < G; ++i)
            preM[i] = preM[i-1]+mCount[i];
        preP[0] = pCount[0];
        for (i = 1; i < G; ++i)
            preP[i] = preP[i-1]+pCount[i];
        preG[0] = gCount[0];
        for (i = 1; i < G; ++i)
            preG[i] = preG[i-1]+gCount[i];
        if (lastM != -1)
            result += (lastM == 0 ? 0 : preTravel[lastM-1])+preM[lastM];
        if (lastP != -1)
            result += (lastP == 0 ? 0 : preTravel[lastP-1])+preP[lastP];
        if (lastG != -1)
            result += (lastG == 0 ? 0 : preTravel[lastG-1])+preG[lastG];

        return result;
    }
}

class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int [] travelPrefix = new int [garbage.length];
        int gTravel = 0;
        int mTravel = 0;
        int pTravel = 0;
        
        int gCount = 0;
        int mCount = 0;
        int pCount = 0;
        
        for (int i = 1; i < garbage.length; ++i){
            travelPrefix[i] = travelPrefix[i - 1] + travel[i - 1]; 
        }
        
        String curGarbage;
        
        for (int i = 0; i < garbage.length; ++i){
            curGarbage = garbage[i];
            
            for (char c : curGarbage.toCharArray()){
                if (c == 'G'){
                    gTravel = travelPrefix[i];
                    ++gCount;
                }else if (c == 'M'){
                    mTravel = travelPrefix[i];
                    ++mCount;
                }else{
                    pTravel = travelPrefix[i];
                    ++pCount;
                }
            }
        }
        
        int result = gTravel + mTravel + pTravel;
        result += gCount + pCount + mCount;
        
        return result;
    }
}