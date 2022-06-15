/*
https://binarysearch.com/problems/Zipped-Iterator
Zipped Iterator

*/
// class ZippedIterator {
//     public:
//         vector<int> ab;
//         vector<int>::iterator it;
//     ZippedIterator(vector<int>& a, vector<int>& b) {

//         vector<int>::iterator ita = a.begin();
//         vector<int>::iterator itb = b.begin();

//         while(ita != a.end() && itb != b.end())
//         {
//             ab.push_back(*ita);
//             ab.push_back(*itb);
//             ita++;
//             itb++;
//         }
//         while(ita != a.end() )
//         {
//             ab.push_back(*ita);
//             ita++;
//         }
//         while(itb != b.end())
//         {
//             ab.push_back(*itb);
//             itb++;
//         }
//         it=ab.begin();
//     }

//     int next() {
//         int val = *it;
//         it++;
//         return val;
//     }

//     bool hasnext() {
//         vector<int>::iterator temp = it;
//         if(temp>=ab.end())
//             return false;
//         else
//             return true;
//     }
// };

/*
class ZippedIterator {
    public:
        vector<int> ab;
        int idx=0;

    ZippedIterator(vector<int>& a, vector<int>& b) {

       int m = a.size();
       int n = b.size();
       for(int i=0, j=0; i<m || j<n; i++, j++)
       {
           if(i<m) ab.push_back(a[i]);
           if(j<n) ab.push_back(b[j]);
       }
    }

    int next() {
        return ab[idx++];
    }

    bool hasnext() {
        return idx<ab.size();
    }
};
*/

class ZippedIterator {
    public:
        vector<int> x,y;
        int i=0, j=0;

    ZippedIterator(vector<int>& a, vector<int>& b) {
        x=a;
        y=b;
    }

    int next() {
        if((i<=j && i<x.size()) || j>=y.size())
        {
            return x[i++];
        }
        return y[j++];
    }

    bool hasnext() {
        return (i<x.size())||(j<y.size());
    }
};