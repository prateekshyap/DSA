/*https://leetcode.com/problems/design-underground-system/*/

//a class to store the details of every travel
class Travel implements Comparable<Travel>
{
    private int id;
    private String checkInStation, checkOutStation;
    private int checkInTime, checkOutTime;
    Travel(int id)
    {
        this.id = id;
    }
    public void setCheckInStation(String s) { this.checkInStation = s; }
    public void setCheckOutStation(String s) { this.checkOutStation = s; }
    public void setCheckInTime(int t) { this.checkInTime = t; }
    public void setCheckOutTime(int t) { this.checkOutTime = t; }
    public String getCheckInStation() { return this.checkInStation; }
    public String getCheckOutStation() { return this.checkOutStation; }
    public int getCheckInTime() { return this.checkInTime; }
    public int getCheckOutTime() { return this.checkOutTime; }
    public int compareTo(Travel t) { return this.id - t.id; }
    public int getId() { return this.id; }
}

class UndergroundSystem {

	//key is customer id and value is index of customers array where the details of the corresponding id is stored
    private HashMap<Integer,Integer> status;

    //key is start station and end station and value stores all the customers travelling between them
    private HashMap<String,ArrayList<Travel>> travel;

    //stores the details of the customer travels
    private Travel[] customers;

    //index to keep track of customers array
    private int index;
    
    public UndergroundSystem() {
        status = new HashMap<Integer,Integer>();
        travel = new HashMap<String,ArrayList<Travel>>();
        customers = new Travel[20000];
        index = 0;
    }
    
    public void checkIn(int id, String stationName, int t) {
    	//if the customer is new or it's not currently travelling
        if (!status.containsKey(id) || status.get(id) == -1)
        {
        	//put the id and index in status
            status.put(id,index);

            // create a new object with the id
            Travel details = new Travel(id);

            //set the checkin station name and checkin time
            details.setCheckInStation(stationName);
            details.setCheckInTime(t);

            //store in customers array
            customers[index++] = details;
        }
    }
    
    public void checkOut(int id, String stationName, int t) {
    	//if the customer is present and it is currently travelling
        if (status.containsKey(id) && status.get(id) != -1)
        {
        	//get the object from customers array
            Travel details = customers[(Integer)status.get(id)];

            //set checkout station name and checkout time
            details.setCheckOutStation(stationName);
            details.setCheckOutTime(t);

            //get the hashkey using the station names
            String hashKey = getKey(details.getCheckInStation(),details.getCheckOutStation());

            //if the hashkey is not already present in travel map, add it with an empty arraylist
            if (!travel.containsKey(hashKey))
                travel.put(hashKey,new ArrayList<Travel>());

            //add the Travel object to the arraylist
            travel.get(hashKey).add(details);

            //set the status of the corresponding it to -1, so that it can travel again
            status.put(id,-1);
        }
    }
    
    public double getAverageTime(String startStation, String endStation) {
        double result = 0.0;
        ArrayList<Travel> list = travel.get(getKey(startStation,endStation));
        int count = 0;
        for (Travel t : list)
        {
            ++count;
            result += t.getCheckOutTime()-t.getCheckInTime();
        }
        return result/count;
    }
    
    private String getKey(String start, String end)
    {
        StringBuffer key = new StringBuffer("");
        key.append(start);
        key.append("#");
        key.append(end);
        return key.toString();
    }
}