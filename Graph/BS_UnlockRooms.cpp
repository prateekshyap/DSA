/*
https://binarysearch.com/problems/Unlock-Rooms
Unlock-Rooms
*/
/*
bool solveBFS(vector<vector<int>>& rooms) {

   int NumOfRooms = rooms.size();
   int countVisited = 0;
   int roomIndex=0;
   vector<bool> visitedRooms(NumOfRooms, false);

   queue<int> q;
   q.push(0); 

   while(!q.empty())
   {
        roomIndex =  q.front(); q.pop();
       if(visitedRooms[roomIndex]) continue;

        visitedRooms[roomIndex]= true;
       countVisited++;
       for(int i=0; i<rooms[roomIndex].size(); i++)
       {
                q.push(rooms[roomIndex][i]);
       }
   }

   return countVisited==NumOfRooms;
   
}//
*/

int countVisited = 0;
vector<int> visitedRooms;
void recur(int, vector<vector<int>>&);

bool solve(vector<vector<int>>& rooms) {
   countVisited=0;
   int NumOfRooms = rooms.size();
   visitedRooms.clear();
   visitedRooms.resize(NumOfRooms, 0);

   recur(0, rooms);  
    // cout<<countVisited<<"- ";
    // cout<<NumOfRooms;
   return countVisited==NumOfRooms; 
}//

void recur(int src, vector<vector<int>>& rooms)
{
    
// cout<<countVisited<<"fubk "<<visitedRooms[src]<<"cc";
    if(visitedRooms[src]) return;

    visitedRooms[src]= 1;
    countVisited++;
// cout<<countVisited<<"-- ";
    for(int r: rooms[src])
            recur(r, rooms);   
    
}