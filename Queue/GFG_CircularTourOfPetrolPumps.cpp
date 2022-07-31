/*
https://practice.geeksforgeeks.org/problems/circular-tour-1587115620/1#
Circular tour 
*/

// { Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

struct petrolPump
{
    int petrol;
    int distance;
};


 // } Driver Code Ends
/*
The structure of petrolPump is 
struct petrolPump
{
    int petrol;
    int distance;
};*/

/*You are required to complete this method*/
class Solution{
  public:
  
    //Function to find starting point where the truck can start to get through
    //the complete circle without exhausting its petrol in between.
    int tour(petrolPump p[],int n)
    {
        int index = 0;
        int deficit = 0;
        int balance = 0;
        
        for(int i=0; i<n; i++)
        {
            balance += p[i].petrol - p[i].distance;
            
            if(balance < 0) //balance negative to deficit 
            {
               deficit += balance;
               index = i+1;
               balance = 0;
            }
        }//end
        
        if(deficit + balance >=0)
            return index;
        
        return -1;
        
    }//end
    
    //greedy approach
    int tour_(petrolPump p[],int n)
    {
       int index = -1, diff=0;
       int sumPetrol = 0, sumDistance = 0;
      for(int i=0; i<n; i++)
      {
          sumPetrol += p[i].petrol;
          sumDistance += p[i].distance;
      }
       
      if(sumPetrol < sumDistance)
        return -1;
        
      for(int i=0; i<n; i++)
      {
          if(index == -1)
            index = i;
          
          diff += p[i].petrol - p[i].distance;
          if(diff < 0)
          {
            index = -1;
            diff = 0;
          }
      }//
       
       return index;
    }
};



// { Driver Code Starts.

int main()
{
    int t;
    cin>>t;
    while(t--)
    {
        int n;
        cin>>n;
        petrolPump p[n];
        for(int i=0;i<n;i++)
            cin>>p[i].petrol>>p[i].distance;
        Solution obj;
        cout<<obj.tour(p,n)<<endl;
    }
}
  // } Driver Code Ends