/*https://leetcode.com/problems/cinema-seat-allocation/*/

// class Solution {
//     public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
//         int groups = 0;
        
//         Map<Integer,Set<Integer>> reservation = new HashMap<Integer,Set<Integer>>();
//         for (int i = 1; i <= 8; ++i)
//             reservation.put(i, new HashSet<Integer>());
//         for (int[] res : reservedSeats)
//             if (res[1] != 1 && res[1] != 10)
//                 reservation.get(res[1]-1).add(res[0]-1);
//         for (int i = 0; i < n; ++i)
//         {
//             if ((!reservation.get(1).contains(i) && !reservation.get(2).contains(i)) || (!reservation.get(7).contains(i) && !reservation.get(8).contains(i)))
//             {
//                 if (!reservation.get(1).contains(i) && !reservation.get(2).contains(i) && !reservation.get(3).contains(i) && !reservation.get(4).contains(i))
//                     ++groups;
//                 if (!reservation.get(5).contains(i) && !reservation.get(6).contains(i) && !reservation.get(7).contains(i) && !reservation.get(8).contains(i))
//                     ++groups;
//             }
//             else if (!reservation.get(3).contains(i) && !reservation.get(4).contains(i) && !reservation.get(5).contains(i) && !reservation.get(6).contains(i))
//                 ++groups;
//         }
        
//         return groups;
//     }
// }


class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        int groups = 0;
        
        Arrays.sort(reservedSeats,(a,b)->(a[0]==b[0] ? a[1]-b[1] : a[0]-b[0]));
        boolean isType1 = true, isType2 = true, isType3Left = true, isType3Right = true;
        int currRow = reservedSeats[0][0];
        int blankRowCount = reservedSeats[0][0]-1;
        groups += (2*blankRowCount);
        for (int[] r : reservedSeats)
        {
            if (r[0] != currRow)
            {
                blankRowCount = r[0]-currRow-1;
                groups += (2*blankRowCount);
                if (!isType1 && !isType2)
                {
                    if (isType3Left && isType3Right)
                        ++groups;
                }
                else
                {
                    if (isType1 && isType3Left) ++groups;
                    if (isType2 && isType3Right) ++groups;
                }
                currRow = r[0];
                isType1 = isType2 = isType3Left = isType3Right = true;
            }
            if (r[1] == 2 || r[1] == 3)
                isType1 = false;
            if (r[1] == 8 || r[1] == 9)
                isType2 = false;
            if (r[1] == 4 || r[1] == 5)
                isType3Left = false;
            if (r[1] == 6 || r[1] == 7)
                isType3Right = false;
        }
        blankRowCount = n-currRow;
        groups += (2*blankRowCount);
        if (!isType1 && !isType2)
        {
            if (isType3Left && isType3Right)
                ++groups;
        }
        else
        {
            if (isType1 && isType3Left) ++groups;
            if (isType2 && isType3Right) ++groups;
        }
        return groups;
    }
}

//cleaner version of the above solution
class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        //Sort revervations by row.
        Arrays.sort(reservedSeats, (a, b) -> a[0] - b[0]);
        
        //Assume all rows can hold 2 groups.
        int count = 2 * n;
        
        int ptr = 0;
        while (ptr < reservedSeats.length) {
            //Assume that all 3 groups in the row are possible.
            boolean[] blocks = new boolean[] {true, true, true};
            int row = reservedSeats[ptr][0];
            //Process all reservations in the current row.
            while (ptr < reservedSeats.length && row == reservedSeats[ptr][0]) {
                int col = reservedSeats[ptr][1];
                if (col > 1 && col < 6)
                     blocks[0] = false;
                if (col > 3 && col < 8)
                    blocks[1] = false;
                if (col > 5 && col < 10)
                    blocks[2] = false;
                ++ptr;
            }
            
            //If 2 groups are possible, then do nothing.
            if (blocks[0] && blocks[2])
                continue;
            //If only 1 group is possible, then subtract one from total.
            else if (blocks[0] || blocks[1] || blocks[2])
                count--;
            //No groups possible, subtract 2.
            else
                count -= 2;
        }
        
        return count;
    }
}

//efficient solution
class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Integer> map = new HashMap<>();
        
        //For each reserved ticket, updated the bitmap for that row.
        for (int[] seat: reservedSeats) {
            int row = seat[0], col = seat[1];
            map.put(row, map.getOrDefault(row, 0) | (1 << (col - 1)));
        }
        
        //Assume all rows can hold 2 groups.
        int count = 2 * n;
        
        for (int bitmap: map.values()) {
            boolean isBlock0Available = (bitmap & 30) == 0, isBlock1Available = (bitmap & 120) == 0, isBlock2Available = (bitmap & 480) == 0;
            //If 2 groups are possible, then they are already included in total count.
            if (isBlock0Available && isBlock2Available)
                continue;
            //If only 1 group is possible, then we need to subtract one.
            else if (isBlock0Available || isBlock1Available || isBlock2Available)
                count--;
            //No groups possible -- need to subtract 2.
            else
                count -= 2;
        }
        
        return count;
    }
}