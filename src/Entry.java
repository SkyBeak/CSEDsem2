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
		String toPrint = "---------------\n";
		switch(this.type){
		
		case 1: toPrint += "Breakfast";
				break;
				
		case 2: toPrint += "Lunch";
				break;
		
		case 3: toPrint += "Dinner";
				break;
				
		case 4: toPrint += "Snack";
				break;
		case 5: toPrint += "Exercise";
		}
		
		toPrint += "\nCalories:" + value + "\nDate:" + date + "\n---------------";
		System.out.println(toPrint);
		
	}
	//I'm not commenting all of these they're pretty self-explanatory.
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
	 * 
	 * @param t: the type of the entry to be stored
	 * @param id: the userID of the person adding the entry
	 * @param v: the value of the entry
	 * @param d: the date the entry was made on
	 */
	public Entry(int t, int id, String v, String d){
		this.type = t;
		this.userID = id;
		this.value = v;
		this.date = d;
	}
	
}
