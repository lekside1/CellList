/**
 * (Adelekan Faruq Aliu 27064896 and Maria Rizk 40020692).
 * COMP249.
 * Assignment #(4).
 * Due Date (12/1/2018).
 */
import java.util.NoSuchElementException;

//-----------------------------------------------------
//Assignment (4)
//Question: (Part 2: LinkedList)
//Written by: (Adelekan Faruq Aliu 27064896 and Maria Rizk 40020692)
//This is CellList class that contains the CellNode inner class.
//-----------------------------------------------------

/**
 * 
 * @author Adelekan Faruq Aliu & Maria Rizk
 *
 */
public class CellList 
{
	/**
	 *  CellNode INNER CLASS
	 */
	private class CellNode
	{
		// class attributes
		private CellPhone cp;
		private CellNode next; 

		// constructors
		/**
		 * This is the default constructor of CellNode class. 
		 */
		public CellNode()
		{
			cp = null; 
			next = null;
			size++; // increment size of the list each time a node is created
		}

		/**
		 * This is the parameterized constructor of CellNode class. 
		 * @param cp The first parameter of the constructor.
		 * @param next The first parameter of the constructor.
		 */
		public CellNode(CellPhone cp, CellNode next) 
		{
			this.cp = cp; 
			this.next = next;
			size++; // increment size of the list each time a node is created
		}

		/**
		 * This is the copy constructor of CellNode class.
		 * @param copy Takes an object of CellNode as a parameter.
		 */
		public CellNode(CellNode copy)  
		{
			this.cp = copy.cp.clone();
			this.next = copy.next;
			size++; // increment size of the list each time a node is created
		}

		/**
		 * This method creates a clone of CellNode class object.
		 * @return Returns a copy of the class object. 
		 */
		public CellNode clone()
		{
			return new CellNode(this);
		}

		/**
		 * This is the accessor method for Cellphone cp.
		 * @return cp The object in the node.
		 */
		public CellPhone getCp() {
			return cp;
		}

		/**
		 * This is the accessor method for CellNode next.
		 * @return next The pointer to the next node.
		 */
		public CellNode getNext() {
			return next;
		}

		/**
		 * This is the mutator method for Cellphone cp.
		 * @param cp The object in the node.
		 */
		public void setCp(CellPhone cp) {
			this.cp = cp;
		}

		/**
		 * This is the mutator method for CellNode next.
		 * @param next The pointer to the next node.
		 */
		public void setNext(CellNode next) {
			this.next = next;
		}

		/**
		 * Overrides the default toString method.
		 * @return The information of the node.
		 */
		public String toString() 
		{
			return cp + " ---> " + next + "";
		}

	}	// END OF INNER CLASS


	/* BEGIN CellList class */

	// class attributes 
	private CellNode head;
	private int size;

	/**
	 * This is the default constructor of CellList class. 
	 */
	public CellList()
	{
		head = null; 
		size = 0;
	}

	/**
	 * This is the copy constructor of CellList class. 
	 * @param copy Takes an object of CellList as a parameter.
	 */
	public CellList(CellList copy)
	{
		if(copy.head == null)
			head = null;

		else
		{
			head = null; 
			CellNode t1, t2, t3; 

			t1 = copy.head;
			t2 = t3 = null;

			while(t1 != null)
			{
				if(head == null)
				{
					t2 = new CellNode(t1);
					head = t2;
				}
				else 
				{
					t3 = new CellNode(t1);
					t2.next = t3;
					t2 = t3;
				}
				t1 = t1.next;
			} // here, t1 is null
			t2 = t3 = null; // stop privacy leak
		}
	}

	/**
	 * This is the getter method for the head.
	 * @return the head.
	 */
	public CellNode getHead() {
		return head;
	}

	/**
	 * This is the getter method for the size;
	 * @return the size.
	 */
	public int getSize() {
		return size;
	}

	/**
	 * This is the setter method for the head.
	 * @param head the head to set.
	 */
	public void setHead(CellNode head) {
		this.head = head;
	}

	/**
	 * This is the setter method for the size.
	 * @param size the size to set.
	 */
	public void setSize(int size) {
		this.size = size;
	}

	/**
	 * This method adds a node to the start of the list.
	 * @param add The object to be add with the node.
	 */
	public void addToStart(CellPhone add)
	{
		head = new CellNode(add, head); 
	}

	/**
	 * This method inserts a node at an index.
	 * @param in The object to be inserted.
	 * @param index The position of the insertions.
	 * @return boolean true if inserted, false otherwise.
	 * @throws NoSuchElementException throws this exception if invalid index.
	 */
	public boolean insertAtIndex(CellPhone in, int index) throws NoSuchElementException 
	{
		// if invalid index; if list is empty: throw NoSuchElementException and terinate program
		if (index > size-1 || index < 0 || head == null) 
		{	
			System.out.println("The index does not exist. Program will terminate!");
			throw new NoSuchElementException(); 
		}
		// VALID index (betwee 0 and size-1)
		// index at zero
		if(index == 0) 
		{
			// call method to add new node to start
			addToStart(in);
			return true;
		}
		CellNode t = head; 
		int i = 0; // i is the index before where to insert the new node
		while(t != null)
		{
			// index before where to assign
			if (i == index-1) 
			{
				break;
			}
			t = t.next;
			i++;
		}
		CellNode temp = new CellNode(in, t.next); // create new node with and insert it a index
		t.next = temp;
		temp = null; // stop privacy leak

		return true; 	
	}

	/**
	 * This method removes a node at an index.
	 * @param index The position of the deletion.
	 * @return boolean true if removed, false otherwise.
	 * @throws NoSuchElementException throws this exception if invalid index.
	 */
	public boolean deleteFromIndex(int index) throws NoSuchElementException 
	{
		// if invalid index; if list is empty: throw NoSuchElementException and terinate program
		if (index > size-1 || index < 0 || head == null)
		{
			System.out.println("The index does not exist. Program will terminate!");
			throw new NoSuchElementException();
		}
		// VALID index (betwee 0 and size-1)
		// index at first node
		if(index == 0) 
		{
			deleteFromStart();
			return true;
		}
		CellNode t = head;
		int i = 0; // i is the index before where to insert the new node
		while(t != null)
		{
			// index before where to assign
			if (i == index-1) 
			{
				break;
			}
			t = t.next;
			i++;
		}
		t.next = t.next.next;
		// t = null; // if here, t is null - stop privacy leak
		size--; // decrement size of the list each time a node is deleted

		return true; 	
	}

	/**
	 * This method deletes the first node in the list.
	 */
	public void deleteFromStart()
	{
		// empty list
		if(head == null) {
			head = null;
		}
		else {
			head = head.next;
			size--; // decrement size of the list each time a node is deleted
		}
	}

	/**
	 * This method replace a node with another at an index.
	 * @param rep The object to replace the node at the index.
	 * @param index The position of the replacement.
	 */
	public void replaceAtIndex(CellPhone rep, int index)
	{
		// if invalid index or list is empty, simply return
		if (index > size-1 || index < 0 || head == null) 
			return; 

		CellNode t = head;
		int i = 0; // i is the index before where to insert the new node
		while(t != null)
		{
			// index at first node
			if(index == 0) 
			{
				head = new CellNode(rep, t.next);
				size--; // decrement size of the list each time a node is deleted
				t = null;
			} 

			if (i == index-1) 
			{
				break;
			}
			t = t.next;
			i++;
		}
		t.next = new CellNode(rep, t.next.next);
		size--; // decrement size of the list each time a node is deleted
		// t = null; // if here, t is null - stop privacy leak
	}

	/**
	 * This method searches for the serial numbder of a CellPhone object.
	 * @param sn The serial number being searched for.
	 * @return t A pointer to the node where the object is if found; null otherwise.
	 * This is a privacy, security leak. It is dangerous to return a pointer because 
	 * it allows indirect manipulation of the list.
	 */
	public CellNode find(long sn)
	{
		if(head == null)
			System.out.println("The list is empty!");

		int counter = 0; // keeps track of how many iteration to find the object
		CellNode t = head;
		while(t != null && t.cp.getSerialNum() != sn)
		{
			t = t.next;
			counter++;
		}
		if(t == null) 
		{
			System.out.println("No such Serial number.");
			return null;
		}
		System.out.println("The number of iteration is: "+counter);
		System.out.println(t.cp.toString());
		return t;
	}

	/**
	 * This method searches for the serial numbder of a CellPhone object.
	 * @param sn The serial number being searched for.
	 * @return true if the object is found; false otherwise.
	 */
	public boolean contains(long sn)
	{
		CellNode t = head;
		while(t != null && t.cp.getSerialNum() != sn)
		{
				t = t.next;
		}
		if(t == null) 
			return false;

		return true;

		/*if(find(sn) == null)
			return false;

		return true;*/
	}

	/**
	 * This method displays the contents of the list.
	 */
	public void showContents()
	{
		if(head == null)
		{
			System.out.println("The list is empty!");
		}

		System.out.println("The current size of the list is " + size + ". Here are the contents of the list");
		System.out.println("=====================================================================");
		CellNode t = head; 
		int count = 0;
		while(t != null)
		{
			count++;
			//System.out.print("[" + t.cp.getSerialNum() + ": " + t.cp.getBrand() + " " + t.cp.getPrice() + "$ " + t.cp.getYear() + "] ---> ");
			System.out.print(t.cp.toString() + " ---> ");
			t = t.next;

			if(count%3 == 0) 
			{
				System.out.println();
			}
		}
		System.out.print("X\n");
	}

	/**
	 * Overrides the default equals method.
	 * @return true if list are same; false otherwise.
	 */
	public boolean equals(CellList c)
	{
		if(head == null || c == null)  
		{
			System.out.println("The list is empty!");
			return false;
		}
		// different size
		if(this.size != c.size)
			return false;

		CellNode t1 = head;
		CellNode t2 = c.head;

		while(t1 != null && t2 != null)
		{
			if(!(t1.cp.equals(t2.cp)))
			{
				return false; 
			}
			t1 = t1.next;
			t2 = t2.next;
		}
		t1 = null; 
		t2 = null;
		return true;
	}

	/**
	 * Overrides the default toString method.
	 * @return The information of the list.
	 */
	public String toString() 
	{
		return "CellList: \n" + head + "\nsize: " + size + "\n";
	}
}
