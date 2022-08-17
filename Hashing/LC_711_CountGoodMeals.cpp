/*
https://leetcode.com/problems/count-good-meals/
1711. Count Good Meals

*/
const int MOD = 1e9+7;
static auto speedup = [](){
    ios_base::sync_with_stdio(false);
    cout.tie(NULL);
    cin.tie(NULL);
    return NULL;
}();
class Solution {
public:
    /*
    int countPairs_1(vector<int>& deliciousness) {
        
        int n = deliciousness.size();
        vector<long long> power2(22);
        unordered_map<int,int> umap;
        int ans=0, need=0, curr=0;
        
        //min pow of 2 = 0
        //max pow of 2 = 2^21;
        for(int i=0; i<22; i++)
            power2[i] = 1<<i;
        
        for(int dl: deliciousness)
        {
            for(int p2: power2)
            {
                need = p2-dl;
                if(umap.find(need)!=umap.end())
                    ans= (ans + umap[need])%MOD;
            }
            umap[dl]++;
        }
        
        return ans;
    }//end
    */
    
    int countPairs(vector<int>& deliciousness) {
        
        unordered_map<int,long long> umap;
        int max_dl=0, need=0;
        int ans=0;
        
        for(int dl: deliciousness)
        {
            umap[dl]++;
            max_dl = max(max_dl, dl);
        }
        if(max_dl == 0) return 0; // if all deliciousness is zero
        
        max_dl<<=1; //how many powers we need one extra than max dl
        int pow2size = ceil(log2(max_dl))+1;
        // int pow2size =0;
        // while(max_dl)
        // { 
        //     pow2size++;
        //     max_dl>>=1;
        // }
        // cout<<max_dl<<endl;
        // cout<<pow2size<<endl;
        
        int *power = new int[pow2size];
        power[0]=1;
        for(int i=1; i<pow2size; i++)
            power[i] = power[i-1]<<1;
        
        for(auto &[dl, dl_freq]: umap)
        {
            for(int p=pow2size-1; p>=0; p--)
            {
                need = power[p]-dl;
                // cout<<dl<<" "<<dl_freq<<"] ->"<<need<<" "<<power[p]<<endl;
                if(need < dl) break; // to avoid duplicates counting
                if(umap.find(need)!=umap.end())
                {
                    if(dl == need)
                        ans = (ans + (dl_freq*(dl_freq-1))/2)%MOD; 
                    else
                        ans = (ans + dl_freq*umap[need])%MOD; 
                }
                // cout<<" ans "<<ans<<endl;
            }
            
        }
        
        return ans;
    }//end
};