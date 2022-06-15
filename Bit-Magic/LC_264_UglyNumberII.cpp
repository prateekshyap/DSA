/*
https://leetcode.com/problems/ugly-number-ii/
264. Ugly Number II

*/
class Solution {
public:
    int nthUglyNumber(int n) {
        
        if(n==1) return 1;
        
        vector<int> seq(n);
        int i=0, j=0, k=0; //pointers to list for 2, 3 , 5
        int l2=2, l3=3 ,l5=5; // actual values of the list
        
        seq[0] = 1;
        for(int s=1; s<n; s++)
        {
            seq[s] = min({l2, l3, l5}); // sabse chota konsa he taki ham sorted list nikal sake
            
            // increment the pointer whose value we found min so that next time we need to calculate from that point
            if(seq[s]==l2)
            {
                i++;  // tera yanh ka kaam khatam ab next point se shuru kar
                l2 = seq[i]*2;
            }
            if(seq[s]==l3)
            {
                j++;
                l3 = seq[j]*3;
            }
            if(seq[s]==l5) 
            {
                k++;
                 l5 = seq[k]*5;
            }
        }
        
        return seq[n-1];
    }//end
    
    // precomputation for multiple testcases
    int nthUglyNumber1(int n) {
        
        if(n==1) return 1;
        
        vector<long long> seq;
        
        int i=0, j=0, k=0;
        
        long long pow2=pow(2,i);
        long long pow3=pow(3,j);
        long long pow5=pow(5,k);
        
        while(pow2<INT_MAX)
        {
            j=0;
            pow3=pow(5,j);
            while(pow3*pow2<INT_MAX)
            {
                k=0;
                pow5=pow(5,k);
                while(pow5*pow3*pow2<INT_MAX)
                {
                    seq.push_back(pow2*pow3*pow5);
                    k++;
                    pow5=pow(5, k);
                }
                j++;
                pow3=pow(3, j);
            }
            i++;
            pow2=pow(2, i);
        }
       
        sort(seq.begin(), seq.end());
        
        return seq[n-1];
    }//end
};