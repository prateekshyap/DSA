/*
https://leetcode.com/problems/course-schedule-iii/
*/

// Idea is first sort the courses on the basis of course-deadline and then keep track of added courses C
// while processing each course.

// In case, we want to enrol into new course, check if enrolling is possible without removing any course in C.
//     If yes,
//         then add the course in C
//     otherwise
//         check if its duration is less than duration of any course in C,

//         if yes,
//             it means we can remove earlier added course with highest duration and add the current course.
//             In doing so, we are also saving some time which can be used for future course. In doing so,
//             objective function (maximizing the number of courses in which to enrol) will not change
//             but we have get more flexibility in choosing future courses
// :param courses:

class Solution {
public:
    static bool compare(vector<int> &a, vector<int>& b){
        return a[1] < b[1];
    }
    
    int scheduleCourse(vector<vector<int>>& courses) {
        int n = courses.size();
        priority_queue<int> pq; // a priority queue to maintain the course duration that are taken
        int time=0; // total duration of course till current time
        //sort according to deadline
        // sort(courses.begin(),courses.end(), [&](vector<int> &a, vector<int>& b){ return a[1] < b[1]; }); 
        sort(courses.begin(),courses.end(), compare);

        for(const auto &subj: courses)
        {
            // time += subj[0]; // add current duration
            // pq.push(subj[0]); 
            // if(time > subj[1])
            // {
            //     time -= pq.top();
            //     pq.pop();
            // }
            
            if(time + subj[0] <= subj[1])
            {
                time += subj[0];
                pq.push(subj[0]);
            }
            else if(!pq.empty() and pq.top()>subj[0])
            {
                time += subj[0] - pq.top();
                pq.pop();
                pq.push(subj[0]);
            }
        }
        return pq.size();
    }
};