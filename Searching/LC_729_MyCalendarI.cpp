/*
https://leetcode.com/problems/my-calendar-i/
*/

class MyCalendar {
public:
    /*
    vector<pair<int,int>> vec;
    MyCalendar() {
    }
    bool book(int start, int end) {
        for(int i=0; i<vec.size(); i++) {
            if(!(start>=vec[i].second or end<=vec[i].first))
                return false;
        }
        vec.push_back({start, end});
        return true;
    }
    */
    map<int,int> mp;
    set<pair<int,int>> s;
    MyCalendar() {
       
    }
    
    bool book(int start, int end) {
        auto next = mp.upper_bound(start);
        if(next != mp.begin() and start < prev(next)->second) return false;
        if(next != mp.end() and end > next->first) return false;  
        mp.insert({start, end});
        return true;
        
        // // {start, end}.....lower_bound={it->first, it->second}
        // auto equb = s.lower_bound({start, end}); //equal or just upper value // lower bound
        // // cout<<"("<<start<<" "<<end<<") "; cout<<"("<<equb->first<<" "<<equb->second<<") "<<int(equb!=s.begin())<<" "<<int(equb!=s.end())<<endl;
        // if(equb!= s.end() and end > it->first) return false; // if end then directly insert
        // if(equb!= s.begin() and start < (--equb)->second) return false; // if not begin then we can shift to begin by sub
        // s.insert({start, end});
        // return true;
    }
};

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar* obj = new MyCalendar();
 * bool param_1 = obj->book(start,end);
 */