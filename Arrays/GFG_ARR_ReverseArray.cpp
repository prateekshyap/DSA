/* 
 	https://practice.geeksforgeeks.org/problems/reverse-an-array/0
*/
using namespace std;

void ra(int a[], int n) //reverse array function
{
    int s=1, e=n, t;
    while(s<e){
        t=a[s];
        a[s]=a[e];
        a[e]=t;
        
        s++;
        e--;
    }
}

int main() {
	//code
	int t=1, n=0, arr[101], i;
	
	cin>>t;
	
	while(t--)//number of test cases
	{ 
	    cin>>n; //taking size of array 
	    
	    //taking input
	    for(i=1; i<=n; i++){ //given constraint with 1 to 100
	        cin>>arr[i];
	    } 
	    
	    ra(arr,n);
	    //printing
	    for(i=1; i<=n; i++){
	        cout<<arr[i]<<" ";
	    } 
	    cout<<"\n";
	}
	
	
	return 0;
}
