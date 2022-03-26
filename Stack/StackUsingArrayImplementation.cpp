
/* https://practice.geeksforgeeks.org/problems/implement-stack-using-array/1
 * Implementation of Stack Using Dynamic Array
 *
 */
#include<iostream>
using namespace std;
// #define MAX 1000

template<typename T>
class MYStack{
	int top;
	int capacity;
	T *storage;

public:
	MYStack()
	{
		top = -1;
		capacity = 1;
		storage = new T[capacity];
	}

	T pop();
	T peek();
	bool isEmpty();
	void push(T);

	int size(){ return top+1;}

	void Display_St_A()
	{
		cout<<endl;
	 cout<<"	"<<storage[top]<<" <--"<<endl;
	 for(int i=top-1 ; i>=0 ; i--)
	  cout<<"	"<<storage[i]<<endl;
	}

	// to increase or decrease the size of stack
	void resize(int new_capacity)
	{
		T* temp = new(nothrow) T[new_capacity];

		if (!temp)
        {	cout << "\nAllocation of Memory Failed. Exiting\n";
    		exit(1);
    	}

		for(int i=0; i<=top; ++i)
		{
			temp[i] = storage[i];
		}
		delete[] storage;
		storage = temp;
		capacity = new_capacity;
	}

	~MYStack()
	{
		delete[] storage;
	}

};

template<typename T>
bool MYStack<T>::isEmpty()
{
	return (top == -1);
}

template<typename T>
T MYStack<T>::peek()
{
	if(top == -1)
	{
		cout<<"\nPEEK: Stack Empty";
		exit(1);
	}
	return storage[top];
}

template<typename T>
T MYStack<T>::pop()
{
	if(top == -1)
	{
		cout<<"\nPOP: Underflow Condition.";
		exit(1);
		// return -top;
	}
	T item = storage[top];
	 	--top;

	if(top>0 && top+1 == capacity/4)
	{
		resize(capacity/2);
		cout<<"\n\tPOP: decreasing array size | capacity: "<<capacity;
	}	
	cout<<"\nPOP: Item:"<<item<<" popped from Stack | TOP: "<<top;
	return item;
}

template<typename T>
void MYStack<T>::push(T item)
{
	// if capacity full then increase capacity
	if(top+1 == capacity)
	{
		resize(capacity*2);
		cout<<"\n\tPUSH: Trying to insert "<<item<<". Stack Full, Increasing Array Size | capacity: "<<capacity;
	}
	// top++;
	// storage[top] = item;
	storage[++top] = item;
	cout<<"\nPUSH: Item:"<<item<<" pushed into Stack | TOP: "<<top;
}

// int main()
// {
// 	MYStack<char> st;
// 	st.push('A');
// 	st.push('B');
// 	st.push('C');
// 	st.push('D');
// 	st.push('E');
// 	st.push('F');
// 	st.push('G');
// 	st.push('H');

// 	cout<<"\nElements present in stack : ";
//     while(!st.isEmpty())
//     {
//         // print top element in stack
//         cout<<" "<< st.peek()<<" ";
//         // remove top element in stack
//         st.pop();
//     }
//     return 0;
// }

int main()
{
 MYStack<int> st;
 int ITEM ;
 char choice;
 
 do
  {
  	char ch; 
   system("pause") ;
   system("cls");
   cout<<"\n   Stack Menu Array";
   cout<<"\n 1. Push";
   cout<<"\n 2. Pop";
   cout<<"\n 3. Display";
   cout<<"\n 4. Quit";
   cout<<"\n\n Enter choice : ";
   cin>>ch;

   switch(ch)
   {
    case '1' :  cout<<"\nEnter ITEM for insertion : ";
  				  cin>>ITEM;
  			    st.push(ITEM);
			    st.Display_St_A(); 
			break;
    case '2' :  st.Display_St_A();  st.pop();   st.Display_St_A();  
    		break;
    case '3' :  st.Display_St_A();       
    		break;
	default: cout<<"\n BYE BYE!";
		break;
   }
   choice=ch;
  }while(choice!='4');
  
 cin.get();
  cin.get();
 return 0;
}



