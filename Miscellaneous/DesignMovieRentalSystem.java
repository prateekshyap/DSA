/*https://leetcode.com/problems/design-movie-rental-system/*/

class MovieRentingSystem {
    int shops;
    HashMap<Integer,TreeMap<Integer,TreeSet<Integer>>> movieMap; //Movie->Price->Shop, for each movie, list of prices, for each price, list of shops
    HashMap<String,Integer> shopMap; //Shop+" "+Movie->Price, price for each shop and movie combination
    TreeMap<Integer,TreeMap<Integer,TreeSet<Integer>>> rentMap; //Price->Movie->Shop, for each price, list of rented movies, for each movie, list of shops
    public MovieRentingSystem(int n, int[][] entries) {
        movieMap = new HashMap<Integer,TreeMap<Integer,TreeSet<Integer>>>();
        rentMap = new TreeMap<Integer,TreeMap<Integer,TreeSet<Integer>>>();
        shopMap = new HashMap<String,Integer>();
        this.shops = n;
        int shop, movie, price;
        StringBuilder build = new StringBuilder("");
        for (int[] entry : entries) //for each entry
        {
            shop = entry[0]; //get shop number
            movie = entry[1]; //get movie number
            price = entry[2]; //get price
            if (!movieMap.containsKey(movie)) //if movie does not exist
                movieMap.put(movie,new TreeMap<Integer,TreeSet<Integer>>()); //add it
            if (!movieMap.get(movie).containsKey(price)) //if price does not exist
                movieMap.get(movie).put(price,new TreeSet<Integer>()); //add it
            movieMap.get(movie).get(price).add(shop); //add the corresponding shop to movieMap
            build = new StringBuilder("");
            build.append(shop);
            build.append(" ");
            build.append(movie);
            shopMap.put(build.toString(),price); //add the price details to shopMap
        }
    }
    
    public List<Integer> search(int movie) {
        List<Integer> result = new ArrayList<Integer>();
        TreeMap<Integer,TreeSet<Integer>> priceMap = movieMap.getOrDefault(movie,new TreeMap<>()); //get all the prices and shops of the given movie from movieMap
        TreeSet<Integer> shopSet;
        for (Map.Entry entry : priceMap.entrySet()) //for each entry in the priceMap
        {
            shopSet = (TreeSet)entry.getValue(); //get the set of shops for a corresponding price (recall that the prices are sorted in increasing order)
            for (Integer shop : shopSet) //for each shop in the shopSet (recall that the shops are sorted in increasing order)
            {
                result.add(shop); //add the shop number to the result
                if (result.size() == 5) break; //if result is full, break
            }
            if (result.size() == 5) break; //if result is full, break
        }
        return result;
    }
    
    public void rent(int shop, int movie) {
        StringBuilder build = new StringBuilder("");
        build.append(shop);
        build.append(" ");
        build.append(movie);
        int price = shopMap.get(build.toString()); //get the price for the corresponding shop and movie combination
        movieMap.get(movie).get(price).remove(shop); //remove the shop from the movieMap
        if (movieMap.get(movie).get(price).size() == 0) //if price becomes empty
            movieMap.get(movie).remove(price); //remove the price
        if (movieMap.get(movie).size() == 0) //if movie becomes empty
            movieMap.remove(movie); //remove the movie
        if (!rentMap.containsKey(price)) //if price does not exist
            rentMap.put(price,new TreeMap<Integer,TreeSet<Integer>>()); //add it
        if (!rentMap.get(price).containsKey(movie)) //if movie does not exist
            rentMap.get(price).put(movie,new TreeSet<Integer>()); //add it
        rentMap.get(price).get(movie).add(shop); //add the corresponding shop to rentMap
    }
    
    public void drop(int shop, int movie) {
        StringBuilder build = new StringBuilder("");
        build.append(shop);
        build.append(" ");
        build.append(movie);
        int price = shopMap.get(build.toString()); //get the price for the corresponding shop and movie combination
        rentMap.get(price).get(movie).remove(shop); //remove the shop from the rentMap
        if (rentMap.get(price).get(movie).size() == 0) //if movie becomes empty
            rentMap.get(price).remove(movie); //remove the movie
        if (rentMap.get(price).size() == 0) //if price becomes empty
            rentMap.remove(price); //remove the price
        if (!movieMap.containsKey(movie)) //if movie does not exist
            movieMap.put(movie,new TreeMap<Integer,TreeSet<Integer>>()); //add it
        if (!movieMap.get(movie).containsKey(price)) //if price doe not exist
            movieMap.get(movie).put(price,new TreeSet<Integer>()); //add it
        movieMap.get(movie).get(price).add(shop); //add the corresponding shop to movieMap
    }
    
    public List<List<Integer>> report() {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int movie, price;
        TreeMap<Integer,TreeSet<Integer>> movieShop;
        TreeSet<Integer> shops;
        for (Map.Entry priceEntry : rentMap.entrySet()) //for each entry in the rentMap
        {
            price = (Integer)priceEntry.getKey(); //get the price
            movieShop = (TreeMap)priceEntry.getValue(); //get the mappings of movies and shops
            for (Map.Entry movieEntry : movieShop.entrySet()) //for each entry in movieShop
            {
                movie = (Integer)movieEntry.getKey(); //get the movie
                shops = (TreeSet)movieEntry.getValue(); //get the set of shops
                for (Integer shop : shops) //for each shop (recall that the shops are sorted in increasing order)
                {
                    result.add(Arrays.asList(price, shop, movie)); //add price, shop and movie as a list in the result
                    if (result.size() == 5) break; //if result is full, break
                }
                if (result.size() == 5) break; //if result is full, break
            }
            if (result.size() == 5) break; //if result is full, break
        }
        Collections.sort(result,(a,b)->
        								(a.get(0) == b.get(0) ? 
        									(a.get(1) == b.get(1) ? a.get(2)-b.get(2) : a.get(1)-b.get(1)) 
        										: a.get(0)-b.get(0))); //sort by breaking the ties as required
        List<List<Integer>> finalResult = new ArrayList<List<Integer>>();
        for (List<Integer> entry : result) //for the final result
            finalResult.add(Arrays.asList(entry.get(1),entry.get(2))); //add only shop and movie
        return finalResult;
    }
}

/**
 * Your MovieRentingSystem object will be instantiated and called as such:
 * MovieRentingSystem obj = new MovieRentingSystem(n, entries);
 * List<Integer> param_1 = obj.search(movie);
 * obj.rent(shop,movie);
 * obj.drop(shop,movie);
 * List<List<Integer>> param_4 = obj.report();
 */