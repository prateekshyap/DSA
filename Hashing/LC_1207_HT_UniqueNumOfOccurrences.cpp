/* https://leetcode.com/problems/unique-number-of-occurrences/
 * Given an array of integers arr, return true if the number of occurrences of each value in the array is unique, or false otherwise.
 */
class Solution {
public:
    bool uniqueOccurrences(vector<int>& arr) {

        unordered_map<int,int> mp; // int, freq pair
        set<int> s;                // set for storing frequency

        for(int i: arr)
            mp[i]++;

        for(auto it: mp){
            s.insert(it.second);

        }
        if(s.size() == mp.size())
            return true;
        else
            return false;

    }
};
