import java.util.*;

public class Entry {

	private int type;
	private int userID;
	private String value;
	private String date;
	
	/*
	 * prints the entry to standard out
	 */
	public void print(){
		String toPrint = "";
		switch(this.type){
		
		case 1: toPrint += "Breakfast";
				break;
				
		case 2: toPrint += "Lunch";
				break;
		
		case 3: toPrint += "Dinner";
				break;
		}
		
		toPrint += "\nCalories:" + value + "\nDate:" + date + "\n---------------";
		System.out.println(toPrint);
		
	}
	
	public void setType(int t){
		this.type = t;
	}
	
	public int getType(){
		return this.type;
	}
	
	public void setUserID(int id){
		this.userID = id;
	}
	
	public int getUserID(){
		return this.userID;
	}
	
	public void setValue(String v){
		this.value = v;
	}
	
	public String getValue(){
		return this.value;
	}
	
	public void setDate(String d){
		this.date = d;
	}
	
	public String getDate(){
		return this.date;
	}
	/*
	 * Default constructor used if values aren't known when the entry is created
	 */
	public Entry(){
		this.type = 0;
		this.userID = 0;
		this.value = "";
		this.date = "";
	}
	/**
	 * Constructor
	 * @param: the values to be stored in the entry object
	 */
	public Entry(int t, int id, String v, String d){
		this.type = t;
		this.userID = id;
		this.value = v;
		this.date = d;
	}
	
}
