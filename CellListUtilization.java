/**
 * (Adelekan Faruq Aliu 27064896 and Maria Rizk 40020692).
 * COMP249.
 * Assignment #(4).
 * Due Date (12/1/2018).
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

//-----------------------------------------------------
//Assignment (4)
//Question: (Part 2: LinkedList)
//Written by: (Adelekan Faruq Aliu 27064896 and Maria Rizk 40020692)
//This is the Driver class that contains the main method of the program
//-----------------------------------------------------

/**
 * 
 * @author Adelekan Faruq Aliu & Maria Rizk
 *
 */
public class CellListUtilization 
{
	public static void main(String[] args) 
	{
		// creating 2 lists
		CellList list1 = new CellList();
		CellList list2 = new CellList();

		// file
		File myfile = new File("Cell_Info.txt");
		FileInputStream file;
		Scanner sc;

		long serial;
		String brand;
		int year;
		double price;

		try 
		{
			// opens the file for reading
			file = new FileInputStream(myfile);
			sc = new Scanner(file);

			// read the file
			while(sc.hasNext())
			{
				serial = sc.nextLong();
				brand = sc.next();
				price = sc.nextDouble();
				year = sc.nextInt();

				// create new CellPhone object
				CellPhone phone = new CellPhone(serial, brand, year, price);

				if(!list1.contains(serial)) // if th serial doesn't already exist, then add to list
				{
					list1.addToStart(phone); // fill the list with cellphones
				}
			} // Done Reading file

			// display list contents
			list1.showContents();

			// close the file and scanner
			file.close();
			sc.close();
		}
		catch(FileNotFoundException e)
		{
			System.out.println("The file: " + myfile.getName() + " was not found.");
		}
		catch(IOException e)
		{
			System.out.println("An IO Error Occured!");
		}

		/* USER INPUT */
		Scanner cin = new Scanner(System.in);
		long userSN;

		try
		{
			while(true)
			{
				System.out.print("\nPlease enter a serial number to search for (-1 to exit): ");
				userSN = cin.nextLong();

				if(userSN == -1)
					break;	

				list1.find(userSN); 
			}
		}
		catch(InputMismatchException e)
		{
			System.out.println("Invalid Entry! Terminating.");
		}

		
		/* TESTING */
		// CREATING LISTS TO TESTING METHODS
		CellPhone p1 = new CellPhone(15555, "Apple", 2017, 300);
		CellPhone p2 = new CellPhone(); // default
		CellPhone p3 = new CellPhone(19234, "Motorola", 2000, 100);
		CellPhone p4 = new CellPhone(19222, "Lenovo", 2013, 500);
		CellPhone p5 = new CellPhone(p1, 25555); // copy constructor
		CellPhone p6 = new CellPhone(12333, "Huawei", 2018, 500);
		CellPhone p7 = new CellPhone(15321, "Samsung", 2019, 1000);
		CellPhone p8 = new CellPhone(30005, "Nokia", 1999, 50);


		// testing accessors
		System.out.println("\nTesting getter methods of CellPhone class \n" + "[" + p1.getSerialNum() + ": " + p1.getBrand() + " " + p1.getPrice() + "$ " + p1.getYear() + "]");

		// testing mutators
		p2.setBrand("Nokia");
		p2.setPrice(100);
		p2.setSerialNum(15677);
		p2.setYear(2013);

		// testing equals method of CellPhone class
		System.out.println("\ntesting equals method of CellPhone class:");
		if(p1.equals(p3) == true) 
		{
			System.out.println("The Cellphones are equal.");
		}
		else 
		{ 
			System.out.println("The Cellphones aren't equal");

		}

		// testing addToStart 
		System.out.println("\nUsing addToSTart method:");
		list2.addToStart(p7);
		list2.addToStart(p6);
		list2.addToStart(p5);
		list2.addToStart(p4);
		list2.addToStart(p2);
		list2.showContents();

		// testing toString CellList 
		System.out.println("\ntesting toString method of CellList");
		System.out.println(list2);

		// testing insertAtIndex
		System.out.println("\nUsing insertAtIndex method:");
		// valid index
		list2.insertAtIndex(p3,3);

		// invalid index
		try
		{
			list2.insertAtIndex(p1,9);
			list2.insertAtIndex(p1,5);
		}
		catch(NoSuchElementException e) 
		{
			System.out.println("Invalid index");
		}

		list2.showContents();

		// testing find
		System.out.println("\n\nUsing find method:");
		list2.find(25555);
		list2.find(33333);
		list2.find(15677);

		// testing contains
		System.out.println("\nUsing contains method:");
		if(list2.contains(19222) == true) 
		{
			System.out.println("The list contains a cellphone with that serial number.");
		}
		else 
		{
			System.out.println("The list doesn't contain a cellphone with that serial number.");

		}

		// testing copy constructor
		System.out.println("\nCreating another list to check the equals method.");
		System.out.println("Testing the copy constructor of CellList class");

		CellList list3 = new CellList(list2);

		System.out.println("showing contents of list 2\n");
		list2.showContents();
		System.out.println("showing contents of list 3\n");
		list3.showContents();

		// testing equals 
		System.out.println("\nComparing list2 with list3");
		if(list2.equals(list3) == true) 
		{
			System.out.println("The lists are equal.");
		}
		else 
		{
			System.out.println("The lists aren't equal");

		}
		
		System.out.println("\nComparing list1 with list2");
		if(list1.equals(list2) == true)
		{
			System.out.println("The lists are equal");
		}
		else 
		{
			System.out.println("The lists aren't equal");

		}

		// testing deleteFromIndex
		System.out.println("\n\ndeleteFromIndex method");
		list2.showContents();
		// valid index
		list2.deleteFromIndex(3);
		list2.showContents();

		System.out.println();

		// invalid index
		try
		{
			list2.deleteFromIndex(500); 
		}
		catch(NoSuchElementException e1) 
		{
			System.out.print("Invalid index");
		}

		// testing deleteFromStart
		System.out.println("\n\ndeleteFromStart Method");
		list2.deleteFromStart();
		list2.showContents();

		// testing replaceAtIndex
		System.out.println("\n\nreplaceAtIndex Method");
		list2.replaceAtIndex(p8, 3);
		list2.showContents();

		// close scanner - stop resource leak
		cin.close();
	}
}
