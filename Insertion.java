/*
	@author Abhinav	
	A class representing a single node
*/
class Node
{
	int data;
	Node next;
	
	void setData(int data)
	{
		this.data=data;		
	}	

	int getData()
	{
		return this.data;
	}

	void setNext(Node next)
	{
		this.next=next;
	}
		
	Node getNext()
	{
		return this.next;	
	}
}

class Insertion
{
	public static void main(String args[])
	{
		Node a = new Node();
		Node b = new Node();
		Node c = new Node();
		Node d = new Node();
		Node current = new Node();
		Node insert_begin = new Node();
		a.setData(1);
		a.setNext(b);
		b.setData(2);
		b.setNext(c);
		c.setData(3);
		c.setNext(d);
		d.setData(4);
		d.setNext(null);

		insert_begin.setData(0);
		insert_begin.setNext(a);

		current=insert_begin;
		System.out.println("Insert at begining");
		while(current!=null)
		{
			System.out.println(current.getData());
			current= current.getNext();
			
		}
		
		Node insert_middle = new Node();
		insert_middle.setData(0);
		current = a;
		int position= 3;
		int i=1;
		while(i<=2)
		{
			current=current.getNext();
			i++;			
		}
		
		insert_middle.setNext(current.getNext());
		current.setNext(insert_middle);


		current=a;
		while(current!=null)
		{
			System.out.println(current.getData());
			current= current.getNext();
			
		}
		current =a;
		while(current.getNext()!=null)
		{
			current=current.getNext();			
		}
		Node insert_last = new Node();
		insert_last.setData(0);
		insert_last.setNext(null);
		current.setNext(insert_last);
		current=a;
		while(current!=null)
		{	
			System.out.println(current.getData());
			current = current.getNext();
		}	
	}
}
