/**
 * (Adelekan Faruq Aliu 27064896 and Maria Rizk 40020692).
 * COMP249.
 * Assignment #(4).
 * Due Date (12/1/2018).
 */

import java.util.Scanner;
//-----------------------------------------------------
//Assignment (4)
//Question: (Part 2: LinkedList)
//Written by: (Adelekan Faruq Aliu 27064896 and Maria Rizk 40020692)
//This is the CellPhone class.
//-----------------------------------------------------

/**
 * 
 * @author Adelekan Faruq Aliu & Maria Rizk
 *
 */
public class CellPhone 
{
	// attributes 
	private long serialNum;
	private String brand;
	private int year;
	private double price;

	/**
	 * This is the default constructor of the class.
	 */
	public CellPhone() 
	{
		serialNum = 0;
		brand = "";
		year = 0;
		price = 0.0;
	}

	/**
	 * This is the parameterized constructor of the class.
	 * @param serialNum The serial number.
	 * @param brand The brand.
	 * @param year The year.
	 * @param price The price.
	 */
	public CellPhone(long serialNum, String brand, int year, double price) 
	{ 
		this.serialNum = serialNum;
		this.brand = brand;
		this.year = year;
		this.price = price;
	}

	/**
	 * This is the copy constructor of the class.
	 * @param copy The object to be copied.
	 * @param serialNum The serial number of the object.
	 */
	public CellPhone(CellPhone copy, long serialNum)
	{
		this.serialNum = serialNum;
		this.brand = copy.brand;
		this.year = copy.year;
		this.price = copy.price;
	}

	/**
	 * This is the clone method.
	 * This method ask the user to input a serial number for the obejct.
	 * @return Returns sa new CellPhone object with the serial number.
	 */
	public CellPhone clone() 
	{
		Scanner cin = new Scanner(System.in); // not closed - resource leak
		System.out.print("Please enter serial number: ");
		long sn = cin.nextLong();
		return new CellPhone(this, sn); 
	}

	/**
	 * This is the getter method for the serial number.
	 * @return the serialNum.
	 */
	public long getSerialNum() {
		return serialNum;
	}

	/**
	 * This is the getter method for the brand.
	 * @return the brand.
	 */
	public String getBrand() {
		return brand;
	}

	/**
	 * This is the getter method for the year.
	 * @return the year.
	 */
	public int getYear() {
		return year;
	}

	/**
	 * This is the gtter method for the price.
	 * @return the price.
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * This is the setter method for the price.
	 * @param serialNum the serialNum to set.
	 */
	public void setSerialNum(long serialNum) {
		this.serialNum = serialNum;
	}

	/**
	 * This is the setter method for the brand.
	 * @param brand the brand to set.
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}

	/**
	 * This is the setter method for the year.
	 * @param year the year to set.
	 */
	public void setYear(int year) {
		this.year = year;
	}

	/**
	 * This is the setter method for the price.
	 * @param price the price to set.
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * Overrides the default tostring method.
	 */
	public String toString() 
	{
		return "[" + serialNum + ": " + brand + " " + price + "$ " + year + "]";
	}

	/**
	 * Overrides the default equals method.
	 */
	public boolean equals(Object obj) 
	{
		if((obj == null) || (this.getClass() != obj.getClass()))
			return false;

		CellPhone other = (CellPhone) obj;

		if((brand != other.brand) && (year != other.year) && (price != other.price))
			return false;

		return true;
	}
}
