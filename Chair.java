package eecs2030.lab5;

import java.util.*;

/**
 * 
 * Abstract base class for simple chair. The Chair is a Furniture item that has
 * some fields (attributes). <strong>This class store the color, manufacturing
 * cost and shape of a chair </strong>.
 * 
 * 
 * <p>
 * <strong> NOTE: In this class, all string comparisons are carried out with
 * case insensitive </strong>
 * </p>
 *
 */

public abstract class Chair implements Comparable<Chair> {

	/**
	 * The total number of Chairs created ( or manufactured) using the Chair Class
	 * numChairs is a static variable that will be incremented each time a new Chair
	 * object is created and keeps track of the total number of Chair objects that
	 * have been created.
	 * 
	 * 
	 */
	private static int numChairs = 0;
	// private, then the subclass cannot modify it directly
	// static, then only one copy in all the subclasses and superclass
	// =0, set the original number

	/**
	 * The Id of chair object
	 * 
	 * All instances of a chair are given a unique int id. These are to be assigned
	 * by the chair constructor. The first instance of a chair that is created is
	 * assigned an id of 0 (zero); the next is assigned 1.
	 * 
	 */
	private int id;
	// subclass cannot access it and modify it

	/**
	 * The Chair manufacturing cost . The manufacturing cost chair is positive value
	 * 
	 * This manufacturing cost does not represent the actual chair cost( or selling
	 * price). The actual chair cost will be determined based on the type of the
	 * chair and other additional factors
	 * 
	 * 
	 * 
	 */
	private double chairManufCost;

	/**
	 * The chair shape. The chair shape can be one of the following shapes {Empty
	 * String (""), Rectangle, Round, Square, Oval}
	 * <p>
	 * <strong>It should be noted that shapes string comparisons are carried out
	 * with case insensitive For example, these strings are equals "Rectangle",
	 * "RECtangle", "RECTANGLE",...</strong>
	 * </p>
	 */
	private String chairShape;

	/**
	 * The chair Color The chair color can be one of the following colors {empty
	 * String (""), black, blue, brown, gray, green, orange, pink, red, white,
	 * yellow}
	 * <p>
	 * <strong>It should be noted that color string comparisons are carried out with
	 * case insensitive For example, these strings are equals "black", "Black",
	 * "BLACK",...</strong>
	 * </p>
	 * 
	 */
	private String chairColor;

	/**
	 * Initializes this chair with color and shape to an empty string. and
	 * initialize the chair initial manufacturing cost to zero dollar.
	 * 
	 * <p>
	 * <strong>Notes: The numChairs field variable is incremented each time a new
	 * chair object created </strong>
	 * </p>
	 */
	public Chair() {
		// COMPLETE THIS
		// default constructor to set the fields to the default value
		this.chairColor = "";
		this.chairManufCost = 0.0;
		this.chairShape = "";
		this.id = Chair.numChairs;
		// get the static field by using the class name directly
		Chair.numChairs++; // one copy
		// every time object created, and constructor used, then the numChairs will be
		// increated
	}

	/**
	 * Initializes this chair to the specified fields
	 * 
	 * 
	 * @param chairManufCost the chair manufacturing cost
	 * @param chairShape     the chair shape
	 * @param chairColor     the chair color
	 * 
	 * 						@pre.
	 *                       <p>
	 *                       <strong> Precondition </strong>
	 *                       </p>
	 *                       <p>
	 *                       The chair color should be one of the following choices
	 *                       ,
	 *                       <strong><code>{empty String (""), black,  blue,  brown,  gray,  green,  
	 * 			orange,  pink,  red,  white, yellow} </code></strong>,
	 *                       </p>
	 *                       <p>
	 *                       <strong>It should be noted that colors string
	 *                       comparisons are carried out with case insensitive For
	 *                       example, these strings are equals "black", "Black",
	 *                       "BLACK",...</strong>
	 *                       </p>
	 * 
	 *                       <p>
	 *                       The chair shape should be one of the following choices
	 *                       <strong><code>{Empty String (""), Rectangle, Round, Square, Oval} </code></strong>,
	 *                       </p>
	 *                       <p>
	 *                       <strong>It should be noted that shapes string
	 *                       comparisons are carried out with case insensitive For
	 *                       example, these strings are equals "Rectangle",
	 *                       "RECtangle", "RECTANGLE",...</strong>
	 *                       </p>
	 *                       <p>
	 *                       and, the chair manufacturing cost should be positive
	 *                       real number
	 *                       </p>
	 * 
	 * @throws IllegalArgumentException
	 *                                  <p>
	 *                                  if the manufacturing Cost of chair is
	 *                                  negative value
	 *                                  </p>
	 * 
	 * 
	 * @throws ChairColorNotValid
	 *                                  <p>
	 *                                  if the chair color is not one of possible
	 *                                  chair colors
	 *                                  </p>
	 *                                  .
	 * 
	 * @throws ChairShapeNotValid
	 *                                  <p>
	 *                                  if the chair shape is not one of the
	 *                                  possible chair shapes
	 *                                  </p>
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	public Chair(double chairManufCost, String chairShape, String chairColor) {

		// COMPLETE THIS
		// customer constructor using the arguments
		// all five fields must be initialized to a value

		if (chairManufCost < 0) {
			throw new IllegalArgumentException("Invalid chair manufacturing cost.");
		}

		this.set(chairColor, chairShape);
		/*
		 * equal to the following this.chairColor = chairColor; this.chairShape =
		 * chairShape;
		 */
		this.chairManufCost = chairManufCost;
		this.id = Chair.numChairs;
		// initialize the id to 0
		Chair.numChairs++; // one copy
		// every time the constructor created, the numChairs will be increted

	}

	/**
	 * Return the number of chairs that have been created
	 * 
	 * @return numChairs The total number of Chair created so far
	 */
	public static int getNumberofChairCreated() {

		// COMPLETE THIS
		// this is get method exactly, dont be confused by the different method name
		// static method cannot be overridden in the subclass
		// but can be hidden in the subclass by using the same signature in the subclass
		return Chair.numChairs;
		// static field, access it by using the class name directly

	}

	/**
	 * This method decrement ( reduce ) the number of chairs that have been created
	 * by 1
	 * 
	 * 
	 */
	public static void decrementNumberofChairCreated() {

		// COMPLETE THIS
		// static method cannot be overridden in the subclass but can be overhidden
		// similar to get method, this method just return the decreated number
		Chair.numChairs--;
		// static field by using the class name directly
		// used in the subclass for constructor
	}

	/**
	 * getId method
	 * 
	 * @return id The ID of created Chair object
	 */
	public final int getId() {
		// COMPLETE THIS
		// final method cannot be overridden in the subclass
		// just regular get method
		return this.id;

	}

	/**
	 * This method calculate/compute the price of the chair
	 * 
	 * @return the chair price
	 */
	// these abstract methods will be orveride or defined in the subclasses
	public abstract double getChairPrice();
	// abstract method only exsts in abstract class.
	// all the subclass of abstract class need to implement all the abstract method
	// in the abstract class

	/**
	 * This method calculate/compute the delivery cost of the chair
	 * 
	 * @return the delivery cost of the chair
	 */
	public abstract double getDeliveryCost(String nameofCity);

	/**
	 * Get the chair category The returned string contains all capital letter
	 * 
	 * @return the chair category
	 */
	public abstract String getChairCategory();

	/**
	 * get the number of wheels of this chair
	 * 
	 * @return the number of wheels of this chair
	 */
	public abstract int getNumberofWheels();

	/**
	 * This method set chair color
	 * 
	 * @param chairColor the chair color
	 * 
	 * @throws ChairColorNotValid
	 *                            <p>
	 *                            if the chair color is not one of possible chair
	 *                            colors
	 *                            </p>
	 *                            .
	 */
	protected void setChairColor(String chairColor) throws ChairColorNotValid {

		// COMPLETE THIS
		// protected method the subclass can directively access it
		// constructor in the subclass can use it
		// this is the set method
       
		Set<String> chaircolorset = new HashSet<String>(Arrays.asList("", "black", "blue", "brown", "gray", "green",
				"orange", "pink", "red", "white", "yellow"));
		if (!chaircolorset.contains(chairColor.toLowerCase())) {
			throw new ChairColorNotValid("Invalid chair color.");
		}
		this.chairColor = chairColor.toUpperCase();
	}

	/**
	 * This method set chair Shape
	 * 
	 * @param chairShape the chair shape
	 * 
	 * @throws ChairShapeNotValid
	 *                            <p>
	 *                            if the chair shape is not one of the possible
	 *                            chair shapes
	 *                            </p>
	 * 
	 */
	protected void setChairShape(String chairShape) throws ChairShapeNotValid {

		// COMPLETE THIS
		// constructor in the subclass can use it
		Set<String> chairshapeset = new HashSet<String>(Arrays.asList("", "rectangle", "round", "square", "oval"));
		if (!chairshapeset.contains(chairShape.toLowerCase())) {
			throw new ChairShapeNotValid("Invalid chair shape.");
		}
		this.chairShape = chairShape.toUpperCase();
	}

	/**
	 * 
	 * @param chairManufCost the chair manufacturing cost
	 * 
	 * @throws IllegalArgumentException
	 *                                  <p>
	 *                                  if the manufacturing Cost of chair is
	 *                                  negative value
	 *                                  </p>
	 * 
	 * 
	 */
	protected void setChairManufCost(double chairManufCost) {

		// COMPLETE THIS
		// constructor in the subclass can use it
		if (chairManufCost < 0) {
			throw new IllegalArgumentException("Invalid chair manufacturing cost.");
		}
		this.chairManufCost = chairManufCost;

	}

	/**
	 * Set the chair color and shape to the given values
	 * 
	 * @param chairColor the chair color
	 * @param chairShape the chair shape
	 * 
	 * 
	 * @throws ChairColorNotValid
	 *                            <p>
	 *                            if the chair color is not one of possible chair
	 *                            colors
	 *                            </p>
	 *                            .
	 * @throws ChairShapeNotValid
	 *                            <p>
	 *                            if the chair shape is not one of the possible
	 *                            chair shapes
	 *                            </p>
	 */
	private void set(String chairColor, String chairShape) {

		// COMPLETE THIS
		Set<String> chairshapeset = new HashSet<String>(Arrays.asList("", "rectangle", "round", "square", "oval"));
		if (!chairshapeset.contains(chairShape.toLowerCase())) {
			throw new ChairShapeNotValid("Invalid chair shape.");
		}
		Set<String> chaircolorset = new HashSet<String>(Arrays.asList("", "black", "blue", "brown", "gray", "green",
				"orange", "pink", "red", "white", "yellow"));
		if (!chaircolorset.contains(chairColor.toLowerCase())) {
			throw new ChairColorNotValid("Invalid chair color.");
		}
		this.chairColor = chairColor.toUpperCase();
		this.chairShape = chairShape.toUpperCase();

	}

	/**
	 * Get the chair initial cost
	 * 
	 * @return the chair initial cost
	 */
	public final double getChairManufCost() {
		// ALREADY IMPLEMENTED; DO NOT MODIFY
		// public method can be used to get the chairManufCost in the subclass coz they are private
		return this.chairManufCost;
	}

	/**
	 * Get the chair shape
	 * 
	 * @return the chair shape, the String converted to uppercase
	 */
	public final String getChairShape() {
		// ALREADY IMPLEMENTED; DO NOT MODIFY
		return this.chairShape.toUpperCase();
	}

	/**
	 * Get the chair color
	 * 
	 * @return the chair color, the String converted to uppercase
	 */
	public final String getChairColor() {
		// ALREADY IMPLEMENTED; DO NOT MODIFY
		return this.chairColor.toUpperCase();
	}

	/**
	 * Get the string representation of the chair. The string is chair Shape, chair
	 * shape, chair initial cost .
	 * 
	 * The return string contains only capital letters
	 * 
	 * @return the string representation of the chair
	 */
	public String toString() {
		// COMPLETE THIS

		return (this.chairShape + ", " + this.chairColor + ", " + this.chairManufCost).toUpperCase();
        // in the same class, no need to use this.getChairShape() method, 
		// use this.charShape directly
	}

	/**
	 * compareTo method this method compares the current object with passed object.
	 * If price of current chair less than price of passed object return -1. If
	 * price of current chair greater than price of passed object return 1.
	 * 
	 * If price of current chair equals price of passed object then the number of
	 * wheels of the object compared. If number of wheels of current object less
	 * than number of wheels of passed object return -1. If number of wheels of
	 * current object greater than number of wheels of passed object return 1. If
	 * number of wheels of current object equals number of wheels of passed object
	 * return 0.
	 * 
	 * @param other Object of type Chair, to be compared with this Chair object
	 * @return -1 if this comes before other , 0 if they are equal or 1 otherwise
	 */
	public int compareTo(Chair other) {
		// COMPLETE THIS

		if (Double.compare(this.getChairPrice(), other.getChairPrice()) == 0) {
			return Integer.compare(this.getNumberofWheels(), other.getNumberofWheels());
		} else
			return Double.compare(this.getChairPrice(), other.getChairPrice());

	}

	/**
	 * 
	 * Generate the Hash code
	 * 
	 * 
	 */
	@Override
	public int hashCode() {

		// ALREADY IMPLEMENTED; DO NOT MODIFY

		final int prime = 31;
		int result = 1;
		result = prime * result + ((chairColor == null) ? 0 : chairColor.hashCode());
		long temp;
		temp = Double.doubleToLongBits(chairManufCost);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((chairShape == null) ? 0 : chairShape.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {

		// ALREADY IMPLEMENTED; DO NOT MODIFY
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Chair other = (Chair) obj;
		if (chairColor == null) {
			if (other.chairColor != null)
				return false;
		} else if (!chairColor.equals(other.chairColor))
			return false;
		if (Double.doubleToLongBits(chairManufCost) != Double.doubleToLongBits(other.chairManufCost))
			return false;
		if (chairShape == null) {
			if (other.chairShape != null)
				return false;
		} else if (!chairShape.equals(other.chairShape))
			return false;
		return true;
	}

}
