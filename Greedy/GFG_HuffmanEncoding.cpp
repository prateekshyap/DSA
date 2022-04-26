/*
Huffman Encoding 
https://practice.geeksforgeeks.org/problems/huffman-encoding3345/1
*/
// { Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

 // } Driver Code Ends
// class Solution
class HuffmanNode
{
    public:
    char c; // character
    int f; // frequency
    
    HuffmanNode* leftc;
    HuffmanNode* rightc;
    
        
        HuffmanNode(char ch, int freq)
        {
            c = ch;
            f = freq;
            leftc = nullptr;
            rightc = nullptr;
        }
        
        HuffmanNode(char ch, int freq, HuffmanNode* &lptr, HuffmanNode* &rptr)
        {
            c = ch;
            f = freq;
            leftc = lptr;
            rightc = rptr;
        }
        
        
};

struct compareHuffmanNodes
{
    bool operator()(const HuffmanNode* const &a, const HuffmanNode* const &b )
    {
        return a->f > b->f;
    }
};

class Solution
{
    
	public:
	    vector<string> result;
	    
		vector<string> huffmanCodes(string S,vector<int> f,int N)
		{
		    if(N==0) return {};
		    if(N==1) return {"0"};
		    
		    priority_queue<HuffmanNode*, vector<HuffmanNode*>, compareHuffmanNodes> pq;
		    
		    for(int i=0; i<N; i++)
		        pq.push(new HuffmanNode(S[i], f[i]));
		    
		    while(pq.size() > 1)
		    {
		        HuffmanNode* hn1 = pq.top(); pq.pop();
		        HuffmanNode* hn2 = pq.top(); pq.pop();
		      //  cout<<hn1->f<<" "<<hn2->f<<endl;
		        HuffmanNode* combined = new HuffmanNode('\0',hn1->f + hn2->f );
		        combined->leftc = hn1;
		        combined->rightc = hn2;
		        pq.push(combined);
		      //   pq.push('\0', hn1->f + hn2->f, hn1, hn2);
		        
		    }// while
		    
		    HuffmanNode* root = pq.top(); pq.pop();
		    
		    preorder(root, "");
		    
		    return result;   
		}// end
		
		void preorder(const HuffmanNode* root, string path)
		{
		    if(!root->leftc && !root->rightc)
		    {
		        result.push_back(path);
		        return;
		    }
		    
		  //  path += '0';
		    preorder(root->leftc, path+'0');
		    
		  //  path.pop_back();
		  //  path += '1';
		    preorder(root->rightc, path+'1');
		  //  path.pop_back();
		    
		}// preorder
};

// { Driver Code Starts.
int main(){
    int T;
    cin >> T;
    while(T--)
    {
	    string S;
	    cin >> S;
	    int N = S.length();
	    vector<int> f(N);
	    for(int i=0;i<N;i++){
	        cin>>f[i];
	    }
	    Solution ob;
	    vector<string> ans = ob.huffmanCodes(S,f,N);
	    for(auto i: ans)
	    	cout << i << " ";
	    cout << "\n";
    }
	return 0;
}  // } Driver Code Ends