/*
https://binarysearch.com/problems/Underground-Tunnel
Underground Tunnel

*/
class UndergroundTunnel__ {
    public:
    
    // unordered_map<int, pair<string,int>> chkin, chkout;
    // unordered_map<int, unordered_map<string,int>> chkin, chkout;
    unordered_map<string, unordered_map<int,int>> chkin, chkout;

    UndergroundTunnel() {

    }

    void checkIn(int userId, string station, int timestamp) {
        // chkin[userId][station]=timestamp;
        chkin[station][userId]=timestamp;
    }

    void checkOut(int userId, string station, int timestamp) {
        // chkout[userId][station]=timestamp;
        chkout[station][userId]=timestamp;
    }

    double averageTime(string start, string end) {
        // double at=0;
        // int count=0, t1=0, t2=0;
        // for(auto ci: chkin[start])
        // {
        //     t1=-1, t2=-1;
        //     int id = ci.first;
        //     t1 = ci.second;

        //     t2 = chkout[end][id];

        //     if(t2!=0 && t1<=t2)
        //     {
        //         count++;
        //         at += (double)(t2-t1);
        //         // chkout.erase(id);
        //     }
        //     cout<<id<<" ["<<t1<<","<<t2<<"] "<<" ["<<t1<<","<<t2<<"] "<<at<<endl;
            
        // }
        double time=0;
        int users=0, stime=0, etime=0;
        for(auto &co: chkout[end])
        {
            int id = co.first;
            etime = co.second;

            if(chkin[start].find(id) == chkin[start].end()) continue;

            stime = chkin[start][id];

            users++;
            time += (double)(etime-stime);
        
            // cout<<id<<" ["<<stime<<","<<etime<<"] "<<time<<endl;
            
        }
        // chkout.erase(end);
        // chkin.erase(start);
        return (double)time/users;
    }
};
