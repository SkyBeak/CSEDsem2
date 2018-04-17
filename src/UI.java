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
		
		System.out.println("Please input either breakfast, lunch, dinner or snack using the commands:\n\"addBreakfast\", \"addLunch\", \"addDinner\"\nOr add exercise with the command \"exercise\"\nOr view entries using the \"viewEntries\" command.");
		
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
				
				case "ADDSNACK": addEntry(userInput,4);
				break;
				
				case "VIEWENTRIES": printAllEntries();
				break;
				
				case "SEARCH":
				{
					System.out.println("please enter the header to search under\nType,calorieValue,Date");
					String field = userInput.readLine();
					System.out.println("please enter the value to search for");
					String value = userInput.readLine();
					System.out.println("Input user to search for");
					int user = Integer.parseInt(userInput.readLine());
					printSearchResults(field,value, user);
					break;
				}
				
				case "EXERCISE": addEntry(userInput, 5);
				break;
				
				case "EXIT": System.exit(0);
				
				default: System.out.println("Please input either breakfast, lunch or dinner using the commands:\n\"addBreakfast\", \"addLunch\", \"addDinner\"\nOr view entries using the \"viewEntries\" command.");
				}
			}
		}catch(IOException e){
			System.err.println("Something has gone horribly wrong.");
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
	private void printSearchResults(String field, String value, int user){
		if(field.toUpperCase().equals("TYPE")){
			switch(value.toUpperCase()){
			case "BREAKFAST": value = "1";
			break;
			
			case "LUNCH": value = "2";
			break;
			
			case "DINNER": value = "3";
			break;
			
			case "SNACK": value = "4";
			break;
			}
		}
		ArrayList<Entry> results = searchFor(field,value, user);
		for(int i = 0; i<results.size();i++){
			results.get(i).print();
		}
		if(results.size()==0){
			System.out.println("No results found.");
		}
	}
	
	/**
	 * 
	 * @param field: the name of the field to be searched for
	 * @param value: a string representing the value of the field to be searched for
	 * @return: an ArrayList of entries retrieved from the csv file containing the correct field values.
	 */
	private ArrayList<Entry> searchFor(String field, String value, int user){
		ArrayList<Entry> found = entryReader.SearchFor(field.toUpperCase(), value, user);
		return found;
	}
	
	private void addEntry(BufferedReader br, int type){

		String calories = "";
		if(type !=5){
			System.out.println("Please input the number of calories consumed");
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
		}else{
			addExercise(br);
		}
		
		
		
	}
	
	private void addExercise(BufferedReader br){
		String level = null;
		String caloriesBurnt = "-";
		int mins = 0;

		System.out.println("Please input exercise level: \"light\", \"medium\", \"hard\"");
		try{
			level = br.readLine();
			System.out.println("Please enter the time exercised for to the nearest minute");
			mins = Integer.parseInt(br.readLine());
		}catch(IOException e){
			System.err.println("Error getting input from console.");
			System.exit(1);
		}catch(NumberFormatException n){
			System.err.println("Invalid number for minutes exercised.");
			addExercise(br);
		}
		
		switch(level.toUpperCase()){
		
		case "LIGHT": caloriesBurnt += mins*2;
		break;
		
		case "MEDIUM": caloriesBurnt += mins*5;
		break;
		
		case "HARD": caloriesBurnt += mins*10;
		break;
		
		default: System.err.println("Invalid exercise level input");
		addExercise(br);
		}
		
		try{
			entryWriter.addEntry(5, 1, Integer.parseInt(caloriesBurnt));
		}catch(NumberFormatException e){
			System.err.println("Something has gone horribly wrong");
			System.exit(1);
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