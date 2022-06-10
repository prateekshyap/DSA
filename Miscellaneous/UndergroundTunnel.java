/*https://binarysearch.com/problems/Underground-Tunnel*/

import java.util.*;

class UndergroundTunnel
{
    private Map<String, Map<Integer, Integer>> checkinMap;
    private Map<String, Map<Integer, Integer>> checkoutMap;
    public UndergroundTunnel()
    {
        checkinMap = new HashMap();
        checkoutMap = new HashMap();
    }

    public void checkIn(int userId, String station, int timestamp)
    {
        if (!checkinMap.containsKey(station))
            checkinMap.put(station, new HashMap());
        checkinMap.get(station).put(userId, timestamp);
    }

    public void checkOut(int userId, String station, int timestamp)
    {
        if (!checkoutMap.containsKey(station))
            checkoutMap.put(station, new HashMap());
        checkoutMap.get(station).put(userId, timestamp);
    }

    public double averageTime(String start, String end)
    {
        double totalSum = 0;
        double totalUsers = 0;
        for (Integer userId : checkoutMap.get(end).keySet())
        {
            if (checkinMap.get(start).containsKey(userId))
            {
                totalUsers++;
                totalSum += (checkoutMap.get(end).get(userId)-checkinMap.get(start).get(userId));
            }
        }
        return totalSum / totalUsers;
    }
}