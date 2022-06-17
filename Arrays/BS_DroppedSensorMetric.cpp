/*
https://binarysearch.com/problems/Dropped-Sensor-Metric
Dropped Sensor Metric

*/

int solve__(vector<int>& a, vector<int>& b) {
    
    int n = a.size();
    int i=0, j=0, dropped;
    for(int k=0; k<n-1; k++)
    {
        if(a[i]==b[j])
        {
            i++, j++;
        }
        else if(a[i]<b[j] && a[i+1]==b[j])
        {
            dropped = a[i];
            i++;
        }
        else if(a[i]<b[j] && a[i]==b[j+1])
        {
            dropped = b[j];
            j++;
        }
        else if(a[i]>b[j] && a[i+1]==b[j])
        {
            dropped = a[i];
            i++;
        }
        else if(a[i]>b[j] && a[i]==b[j+1])
        {
            dropped = b[j];
            j++;
        }
    }

    return dropped;
}//end

int solve(vector<int>& a, vector<int>& b) {
    
    int l=0, mid;
    int h=a.size()-1;

    while(l<h)
    {
        mid = l + (h-l)/2;
        if(a[mid]==b[mid])
            l = mid+1;
        else
            h = mid;
    }

    if(a[l+1]==b[l])
        return a[l] ;
    else
        return b[l];

    // for(int i=0; i<a.size(); i++)
    // {
    //     if(a[i]!=b[i])
    //     {
    //         if(b[i] == a[i+1])
    //             return a[i];
    //         else
    //             return b[i];
    //     }
    // }
    // return 0;
}//end