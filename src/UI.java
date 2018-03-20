import java.io.*;
import java.util.ArrayList;



public class UI	{
	
	CSVReader entryReader;
	CSVWriter entryWriter;
	
	public static void main(String[] args){
		UI textInterface = new UI();
	}
	/**
	 * constructor, currently just sets up an entry reader and runs any test methods.
	 */
	public UI(){
		
		entryReader  = new CSVReader();
		entryWriter = new CSVWriter();
		
		System.out.println("Please input either breakfast, lunch or dinner using the commands:\n\"addBreakfast\", \"addLunch\", \"addDinner\"\nOr view entries using the \"viewEntries\" command.");
		
		BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
		String userCommand;
		try{
			while((userCommand = userInput.readLine().toUpperCase())!=null){
				switch(userCommand){

				case "ADDBREAKFAST": addEntry(userInput,1);
				break;

				case "ADDLUNCH": addEntry(userInput,2);
				break;

				case "ADDDINNER": addEntry(userInput,3);
				break;
				
				case "VIEWENTRIES": printAllEntries();
				
				case "EXIT": System.exit(0);
				
				default: System.out.println("Please input either breakfast, lunch or dinner using the commands:\n\"addBreakfast\", \"addLunch\", \"addDinner\"\nOr view entries using the \"viewEntries\" command.");
				}
			}
		}catch(IOException e){

		}
		
		
	}
	
	//test method to check the CSVReader code actually works
	private void printAllEntries(){
		ArrayList<Entry> allEntries = entryReader.readEntries("src/entries.csv");
		for(int i = 0; i<allEntries.size();i++){
			allEntries.get(i).print();
		}
	}
	//test method to check CSVReader search works
	private void printSearchResults(String field, String value){
		ArrayList<Entry> results = searchFor(field,value);
		for(int i = 0; i<results.size();i++){
			results.get(i).print();
		}
	}
	
	/**
	 * 
	 * @param field: the name of the field to be searched for
	 * @param value: a string representing the value of the field to be searched for
	 * @return: an ArrayList of entries retrieved from the csv file containing the correct field values.
	 */
	private ArrayList<Entry> searchFor(String field, String value){
		ArrayList<Entry> found = entryReader.SearchFor(field.toUpperCase(), value);
		return found;
	}
	
	private void addEntry(BufferedReader br, int type){
		System.out.println("Please input the number of calories consumed");
		String calories = "";
		try{
			calories = br.readLine();
		}catch(IOException e){
			System.err.println("Error getting user input");
			System.exit(1);
		}
		
		if(isNumeric(calories)){
			int cal = Integer.parseInt(calories);
			entryWriter.addEntry(type,1,cal);
		}else{
			addEntry(br,type);
		}
	}
	
	/**
	 * 
	 * @param s: the string to be tested
	 * @return whether the string passed in is a sequence of numerical digits
	 */
	private boolean isNumeric(String s){
		for(int i = 0; i<s.length();i++){
			Character current = s.charAt(i);
			if(!Character.isDigit(current)){
				return false;
			}
		}
		return true;
	}
	
	
}