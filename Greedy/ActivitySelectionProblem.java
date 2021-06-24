/*https://practice.geeksforgeeks.org/problems/n-meetings-in-one-room-1587115620/1/*/

class Solution 
{
    public static int maxMeetings(int start[], int end[], int n)
    {
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < n; ++i)
        {
            ArrayList<Integer> temp = new ArrayList<Integer>();
            temp.add(start[i]);
            temp.add(end[i]);
            list.add(temp);
        }

        //sort according to the finish times
        Collections.sort(list,new Comparator<ArrayList<Integer>>()
        {
            public int compare(ArrayList<Integer> l1, ArrayList<Integer> l2)
            {
                return l1.get(1)-l2.get(1);
            }
        });

        //count
        int count = 0;
        int lastStart = -1, lastEnd = -1;
        for (ArrayList<Integer> duration : list)
        {
            //if the current meeting starts after the last meeting ends
            if (duration.get(0) > lastEnd)
            {
                //increment the count
                ++count;

                //update the last meeting
                lastStart = duration.get(0);
                lastEnd = duration.get(1);
            }
        }
        return count;
    }
}