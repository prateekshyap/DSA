/*https://practice.geeksforgeeks.org/problems/implement-stack-using-linked-list/1*/

#include<iostream>
using namespace std;
// #define MAX 1000

template<typename T>
class sNode
{
public:
	T data;
	sNode<T>* next;
	sNode(int item)
	{
		data = item;
	}
};

template<typename T>
class MYStack{
	sNode<T>* top;

public:
	MYStack()
	{
		top = nullptr;
	}

	T pop();
	T peek();
	bool isEmpty();
	void push(T);

	int size(){ return top+1;}

	void Display_St_Lnk()
	{
		sNode<T> *np = top;
	 while(np!=nullptr)
	 {
	 	cout<<endl;
	  cout<<" "<<np->data<<" -> ";
	  np=np->next;
	 }
	 cout<<"!!!\n";
	}

};


template<typename T>
bool MYStack<T>::isEmpty()
{
	return (top == nullptr);
}

template<typename T>
T MYStack<T>::peek()
{
	if(top == nullptr)
	{
		cout<<"\nPEEK: Stack Empty";
		exit(1);
	}
	return top->data;
}

template<typename T>
T MYStack<T>::pop()
{
	if(top == nullptr)
	{
		cout<<"\nPOP: Underflow Condition.";
		exit(1);
		// return -top;
	}
	sNode<T> *ptr = top;
	T item = top->data;
	 	top = top->next;
	
	delete ptr;

	cout<<"\nPOP: Item:"<<item<<" popped from Stack";
	return item;
}

template<typename T>
void MYStack<T>::push(T item)
{
	// if capacity full then increase capacity
	sNode<T> *newptr = new sNode<T>(item);
	 if(newptr==nullptr)
  	 {
	   cout<<"\n Cannot Create New Node !!!! Aborting \n";   system("pause"); 	exit(1);
	  }
	newptr->data = item;
	newptr->next = nullptr;


		newptr->next = top;
		top = newptr;

	cout<<"\nPUSH: Item:"<<item<<" pushed into Stack";
}


int main()
{

 MYStack<int> *st = new MYStack<int>();
 int ITEM ;
 char choice;
 
 do
  {
  	char ch; 
   system("pause") ;
   system("cls");
   cout<<"\n   Stack Menu LinkedList";
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
  			    st->push(ITEM);
			    st->Display_St_Lnk(); 
			break;
    case '2' :  st->Display_St_Lnk();  st->pop();   st->Display_St_Lnk();  
    		break;
    case '3' :  st->Display_St_Lnk();       
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