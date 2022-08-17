/*
https://practice.geeksforgeeks.org/problems/fractional-knapsack-1587115620/1
Fractional Knapsack 

https://binarysearch.com/problems/Fractional-Knapsack
*/

// { Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

struct Item{
    int value;
    int weight;
};


 // } Driver Code Ends
//class implemented
/*
struct Item{
    int value;
    int weight;
};
*/


class Solution
{
    public:
    static bool compareStruct(const Item &a, const Item &b)
    {
        double ppw1 = (double)a.value/(double)a.weight; // profit per weight
        double ppw2 = (double)b.value/(double)b.weight; // profit per weight
        // if(ppw1 > ppw2) return true;
        // else false;
        return ppw1 > ppw2;
    }
    
    double fractionalKnapsack2(int W, Item arr[], int n)
    {
        sort(arr, arr+n, compareStruct);
    
        double maxSum=0;
        
        
        for(int i=0; i<n; i++)
        {
            int val = arr[i].value;
            int wgt = arr[i].weight;
            
            if(wgt <= W)
            {
                maxSum+= val;
                W-=wgt;
            }
            else
            {
                maxSum+= ((double)val/(double)wgt)*W;
                break;
            }
        }
        
        return maxSum;
    }// end
    
    //Function to get the maximum total value in the knapsack.
    double fractionalKnapsack1(int W, Item arr[], int n)
    {
        auto compare = [](const pair<int,float> &a, const pair<int,float> &b)
        {
            return a.second > b.second;
        };
    
        // sort(arr, arr+n, compareStruct);
        vector<pair<int,float>> itm(n);
        double maxSum=0.0;
        
        for(int i=0; i<n; i++)
        {
          itm[i]={i, arr[i].value/(arr[i].weight*1.0)}; 
        }
        
        sort(itm.begin(), itm.end(), compare);
        
        for(auto x: itm)
        {
            int i = x.first;
            int wgt = arr[i].weight;
            
            if(wgt <= W)
            {
                maxSum+= arr[i].value;
                W-=wgt;
            }
            else if(W>0)
            {
                maxSum+= (double)x.second*W;
                break;
            }
        }
        
        return maxSum;
    }// end
    
    struct cmpPQ
    {
     bool operator()(const Item &a, const Item &b)
        {
            double ppw1 = (double)a.value/(double)a.weight; // profit per weight
            double ppw2 = (double)b.value/(double)b.weight; // profit per weight
            // if(ppw1 > ppw2) return true;
            // else false;
            return ppw1 < ppw2;
        }
    };
    
    double fractionalKnapsack(int W, Item arr[], int n)
    {
        double maxSum=0.0;

        priority_queue<struct Item, vector<struct Item>, cmpPQ> pq(arr, arr+n);
         
        while(!pq.empty() && W)
        {
            int itemWgt = pq.top().weight;
            int itemVal = pq.top().value;
            double ppw = (double)itemVal/(double)itemWgt;
            
            // cout<<itemWgt<<" "<<itemVal<< " "<< W<< " "<<endl;
            int cwgt = min(W, itemWgt);
            maxSum += ppw*cwgt;
            W = W - cwgt;
            pq.pop();
        }
            
        return maxSum;
    }// end
        
};


// { Driver Code Starts.
int main()
{
	int t;
	//taking testcases
	cin>>t;
	cout<<setprecision(2)<<fixed;
	while(t--){
	    //size of array and weight
		int n, W;
		cin>>n>>W;
		
		Item arr[n];
		//value and weight of each item
		for(int i=0;i<n;i++){
			cin>>arr[i].value>>arr[i].weight;
		}
		
		//function call
		Solution ob;
		cout<<ob.fractionalKnapsack(W, arr, n)<<endl;
	}
    return 0;
}  // } Driver Code Ends