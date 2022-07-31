/*https://leetcode.com/problems/design-a-food-rating-system/*/

class Pair implements Comparable<Pair>
{
    String cuisine;
    int rating;
    Pair(String cuisine, int rating)
    {
        this.cuisine = cuisine;
        this.rating = rating;
    }

    @Override
    public int compareTo(Pair p)
    {
        return 0;
    }

    @Override
    public String toString()
    {
        return "("+this.cuisine+","+this.rating+")";
    }
}
class FoodRatings {
    Map<String,Pair> foodData; //food, (cuisine, rating)
    Map<String,TreeMap<Integer,TreeSet<String>>> cuisineData; //cuisine, rating, names
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        foodData = new HashMap<String,Pair>();
        cuisineData = new HashMap<String,TreeMap<Integer,TreeSet<String>>>();
        for (int i = 0; i < foods.length; ++i)
        {
            foodData.put(foods[i],new Pair(cuisines[i],ratings[i])); //add to foodData
            //add to cuisineData
            if (!cuisineData.containsKey(cuisines[i]))
            {
                cuisineData.put(cuisines[i],new TreeMap<Integer,TreeSet<String>>());
                cuisineData.get(cuisines[i]).put(ratings[i],new TreeSet<String>());
            }
            else if (!cuisineData.get(cuisines[i]).containsKey(ratings[i]))
                cuisineData.get(cuisines[i]).put(ratings[i],new TreeSet<String>());
            cuisineData.get(cuisines[i]).get(ratings[i]).add(foods[i]);
        }
    }
    
    public void changeRating(String food, int newRating) {
        Pair p = null;
        if (foodData.containsKey(food))
        {
            p = foodData.get(food);  //get old name and rating
            foodData.put(food,new Pair(p.cuisine,newRating)); // add the new rating with the old name
            if (!cuisineData.containsKey(p.cuisine)) // if cuisine name not already exists
            {
                cuisineData.put(p.cuisine,new TreeMap<Integer,TreeSet<String>>()); // add cuisine name
                cuisineData.get(p.cuisine).put(newRating,new TreeSet<String>()); // add new rating
                cuisineData.get(p.cuisine).get(newRating).add(food); // add food name
            }
            else
            {
                TreeSet<String> oldRatings = cuisineData.get(p.cuisine).get(p.rating); //get the list of names with old rating value
                TreeSet<String> newRatings = cuisineData.get(p.cuisine).containsKey(newRating) ? cuisineData.get(p.cuisine).get(newRating) : new TreeSet<String>(); //get the list of names with new rating value
                oldRatings.remove(food); //remove the food name from old list
                newRatings.add(food); //add to the new rating list
                //add both to cuisineData
                cuisineData.get(p.cuisine).put(p.rating,oldRatings);
                cuisineData.get(p.cuisine).put(newRating,newRatings);
                if (oldRatings.size() == 0) cuisineData.get(p.cuisine).remove(p.rating);
            }
        }
    }
    
    public String highestRated(String cuisine) {
        if (cuisineData.containsKey(cuisine))
        {
            TreeMap<Integer,TreeSet<String>> temp = cuisineData.get(cuisine); //get the list of ratings along with the food names
            Map.Entry lastEntry = (Map.Entry)temp.lastEntry(); //get the last list of food names along with the rating since that is the highest rating
            TreeSet<String> foods = (TreeSet)lastEntry.getValue(); //get the last list of food names
            return foods.first(); //return the lexicographically sorted name
        }
        return "";
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */