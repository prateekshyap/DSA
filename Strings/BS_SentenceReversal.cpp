/*
https://binarysearch.com/problems/Sentence-Reversal
Sentence Reversal

*/
vector<string> solve(vector<string>& sentence) {
    
    int n = sentence.size();
    int s11=0, s12=0;

    for(int i=0; i<n; i++)
    {
        if(sentence[i]==" ") // detect space
        {
            s12=i;
            // cout<<s11<<" "<<s12<<endl;
            reverse(sentence.begin()+s11, sentence.begin()+s12); // reverse individual string on detecting space.
            s11=i+1;

        }
    }
    reverse(sentence.begin()+s11, sentence.end()); //reverse last string of sentence

    reverse(sentence.begin(), sentence.end()); // reverse entire string.

    return sentence;
}//end