/*https://leetcode.com/problems/count-days-spent-together/*/

class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int aliceADay = 0, aliceAMonth = 0, bobADay = 0, bobAMonth = 0, aliceLDay = 0, aliceLMonth = 0, bobLDay = 0, bobLMonth = 0;
        aliceAMonth = (arriveAlice.charAt(0)-'0')*10+(arriveAlice.charAt(1)-'0');
        aliceADay = (arriveAlice.charAt(3)-'0')*10+(arriveAlice.charAt(4)-'0');
        aliceLMonth = (leaveAlice.charAt(0)-'0')*10+(leaveAlice.charAt(1)-'0');
        aliceLDay = (leaveAlice.charAt(3)-'0')*10+(leaveAlice.charAt(4)-'0');
        bobAMonth = (arriveBob.charAt(0)-'0')*10+(arriveBob.charAt(1)-'0');
        bobADay = (arriveBob.charAt(3)-'0')*10+(arriveBob.charAt(4)-'0');
        bobLMonth = (leaveBob.charAt(0)-'0')*10+(leaveBob.charAt(1)-'0');
        bobLDay = (leaveBob.charAt(3)-'0')*10+(leaveBob.charAt(4)-'0');
        int days = 0;
        int[] calendar = new int[]{0,31,28,31,30,31,30,31,31,30,31,30,31};
        
        TreeMap<Integer,int[]> aliceMap = new TreeMap<Integer,int[]>();
        TreeMap<Integer,int[]> bobMap = new TreeMap<Integer,int[]>();
        int month = 0;
        if (aliceAMonth == aliceLMonth) aliceMap.put(aliceAMonth,new int[]{aliceADay,aliceLDay});
        else
        {
            month = aliceAMonth+1;
            aliceMap.put(aliceAMonth,new int[]{aliceADay,calendar[aliceAMonth]});
            while (month < aliceLMonth)
            {
                aliceMap.put(month,new int[]{1,calendar[month]});
                ++month;
            }
            aliceMap.put(aliceLMonth,new int[]{1,aliceLDay});
        }
        if (bobAMonth == bobLMonth) bobMap.put(bobAMonth,new int[]{bobADay,bobLDay});
        else
        {
            month = bobAMonth+1;
            bobMap.put(bobAMonth,new int[]{bobADay,calendar[bobAMonth]});
            while (month < bobLMonth)
            {
                bobMap.put(month,new int[]{1,calendar[month]});
                ++month;
            }
            bobMap.put(bobLMonth,new int[]{1,bobLDay});
        }
        // System.out.println(aliceMap+"\n"+bobMap);
        month = 1;
        while (month <= 12)
        {
            if (aliceMap.containsKey(month) && bobMap.containsKey(month))
            {
                int[] aliceRange = aliceMap.get(month);
                int[] bobRange = bobMap.get(month);
                // System.out.println(aliceRange[0]+"->"+aliceRange[1]+","+bobRange[0]+"->"+bobRange[1]);
                if (aliceRange[0] < bobRange[0] && aliceRange[1] < bobRange[0]) break;
                if (bobRange[0] < aliceRange[0] && bobRange[1] < aliceRange[0]) break;
                days += Math.min(aliceRange[1],bobRange[1])-Math.max(aliceRange[0],bobRange[0])+1;
            }
            // System.out.println(month+" "+days);
            ++month;
        }
        return days;
    }
}

class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int aliceADay = 0, aliceAMonth = 0, bobADay = 0, bobAMonth = 0, aliceLDay = 0, aliceLMonth = 0, bobLDay = 0, bobLMonth = 0;
        aliceAMonth = (arriveAlice.charAt(0)-'0')*10+(arriveAlice.charAt(1)-'0');
        aliceADay = (arriveAlice.charAt(3)-'0')*10+(arriveAlice.charAt(4)-'0');
        aliceLMonth = (leaveAlice.charAt(0)-'0')*10+(leaveAlice.charAt(1)-'0');
        aliceLDay = (leaveAlice.charAt(3)-'0')*10+(leaveAlice.charAt(4)-'0');
        bobAMonth = (arriveBob.charAt(0)-'0')*10+(arriveBob.charAt(1)-'0');
        bobADay = (arriveBob.charAt(3)-'0')*10+(arriveBob.charAt(4)-'0');
        bobLMonth = (leaveBob.charAt(0)-'0')*10+(leaveBob.charAt(1)-'0');
        bobLDay = (leaveBob.charAt(3)-'0')*10+(leaveBob.charAt(4)-'0');
        int[] calendar = new int[]{0,31,28,31,30,31,30,31,31,30,31,30,31};
        int aliceA = 0, aliceL = 0, bobA = 0, bobL = 0;
        for (int month = 1; month < aliceAMonth; ++month)
            aliceA += calendar[month];
        aliceA += aliceADay;
        for (int month = 1; month < aliceLMonth; ++month)
            aliceL += calendar[month];
        aliceL += aliceLDay;
        for (int month = 1; month < bobAMonth; ++month)
            bobA += calendar[month];
        bobA += bobADay;
        for (int month = 1; month < bobLMonth; ++month)
            bobL += calendar[month];
        bobL += bobLDay;
        return Math.max(0,Math.min(bobL,aliceL)-Math.max(bobA,aliceA)+1);
    }
}