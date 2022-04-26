/*
690. Employee Importance

https://leetcode.com/problems/employee-importance/
*/

/*
// Definition for Employee.
class Employee {
public:
    int id;
    int importance;
    vector<int> subordinates;
};
*/

class Solution {
public:
    unordered_map<int,int> umap;
    int impSum=0;
    
    void dfsHelper(vector<Employee*> &employees, int id)
    {
        int i = umap[id];
        
        impSum += employees[i]->importance;
        
        for(int subid: employees[i]->subordinates) // all subId are valid.
            dfsHelper(employees, subid);
    }
    
    void bfsHelper(vector<Employee*> &employees, int id)
    {
        queue<int> q;
        q.push(id);
        int i;
            
        while(!q.empty())
        {
            i = umap[q.front()]; q.pop();
            
            impSum += employees[i]->importance;
            
            for(int subid: employees[i]->subordinates) // all subId are valid.
            {
                q.push(subid);
            }
            
        }
    }
    
    int getImportance(vector<Employee*> employees, int id) {
        
        for(int i = 0; i < employees.size(); i++) // unique emp id
            umap[employees[i]->id] = i; // storing in unordered map empid --> i value
        
        // dfsHelper(employees, id);
        
        bfsHelper(employees, id);
        
        return impSum;
    }// end
};