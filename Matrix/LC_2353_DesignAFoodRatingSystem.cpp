/*
https://leetcode.com/problems/design-a-food-rating-system/
2353. Design a Food Rating System

*/

class FoodRatings {
public:
    /*
    struct cmpStruct {
      bool operator() (pair<int, string> const & lhs, pair<int, string> const & rhs) const
      {
         if(lhs.first == rhs.first)
             return lhs.second<rhs.second;
         return lhs.first > rhs.first;
      }
    };
    int n;
    unordered_map<string, set<pair<int, string>, cmpStruct>> foodrated;
    unordered_map<string, string> foodcus;
    unordered_map<string, int> foodrat;
    
    FoodRatings(vector<string>& foods, vector<string>& cuisines, vector<int>& ratings) {
        n = foods.size();
        for(int i=0; i<n; i++)
        {
            foodcus[foods[i]] = cuisines[i];
            foodrat[foods[i]] = ratings[i];
            foodrated[cuisines[i]].insert({ratings[i], foods[i]});
            // cout<<foods[i]<<" "<<cuisines[i]<<" "<<ratings[i]<<endl;
        }
    }
    
    void changeRating(string food, int newRating) {
        string custype = foodcus[food];
        int oldrating = foodrat[food];
        foodrated[custype].erase({oldrating, food});
        foodrat[food] = newRating;
        foodrated[custype].insert({newRating, food});                 
    }
    
    string highestRated(string cuisine) {
        auto [rating, food] = *foodrated[cuisine].begin();
        return food;
    }
    */
    
    unordered_map<string, int> fdratting;
    unordered_map<string, string> fdcuisines;
    unordered_map<string, set<pair<int, string>>> cuisrated;
    
    FoodRatings(vector<string>& foods, vector<string>& cuisines, vector<int>& ratings) {
        int n = foods.size();
        for(int i=0; i<n; i++)
        {
            fdratting[foods[i]] = ratings[i];
            fdcuisines[foods[i]] = cuisines[i];
            cuisrated[cuisines[i]].insert({-ratings[i], foods[i]});
        }
    }
    
    void changeRating(string food, int newRating) {
        int oldrating = fdratting[food];
        string cuisinestype = fdcuisines[food];
        fdratting[food] = newRating;
        cuisrated[cuisinestype].erase({-oldrating, food});
        cuisrated[cuisinestype].insert({-newRating, food});  
    }
    
    string highestRated(string cuisine) {
        auto [rating, food] = *cuisrated[cuisine].begin();
        return food;
    }
};

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings* obj = new FoodRatings(foods, cuisines, ratings);
 * obj->changeRating(food,newRating);
 * string param_2 = obj->highestRated(cuisine);
 */