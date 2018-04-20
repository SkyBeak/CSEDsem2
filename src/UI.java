import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;


public class UI	{

	CSVReader reader;
	CSVWriter writer;
	User u;
	Calories c;

	public static void main(String[] args){
		UI textInterface = new UI();
		textInterface.startUI();
	}
	/**
	 * constructor, currently just sets up an entry reader and runs any test methods.
	 */
	public UI(){

		c = new Calories();
		reader  = new CSVReader();
		writer = new CSVWriter();

	}

	private void startUI(){

		u = reader.readUser("src/users.csv");

		BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));

		if(u.getName().equals("")){
			createUserProfile(userInput);
		}

		System.out.println("Calories consumed so far this week:\n");
		displayDays(7,"Food");

		System.out.println("\nCalories burned so far this week:\n");
		displayDays(7,"Exercise");

		System.out.println("Please input either breakfast, lunch, dinner or snack using the commands:\n\"addBreakfast\", \"addLunch\", \"addDinner\"\nOr add exercise with the command \"exercise\"\nOr view entries using the \"viewEntries\" command.");

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
					printSearchResults(field,value);
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
		ArrayList<Entry> allEntries = reader.readEntries("src/entries.csv");
		for(int i = 0; i<allEntries.size();i++){
			allEntries.get(i).print();
		}
	}
	//test method to check CSVReader search works
	private void printSearchResults(String field, String value){
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

			case "EXERCISE": value = "5";
			break;
			}
		}
		ArrayList<Entry> results = searchFor(field,value);
		for(int i = 0; i<results.size();i++){
			results.get(i).print();
		}
		if(results.size()==0){
			System.out.println("No results found.");
		}
	}
	/**
	 * Adds a new user if one does not already exist
	 * @param br: buffered reader to read input from
	 */
	private void createUserProfile(BufferedReader br){

		String name;
		String gender;
		int height;
		int weight;
		int age;
		int goal;
		int targetWeight;

		try {
			System.out.println("Please input user name");
			name = br.readLine();
			System.out.println("Please input gender");
			gender = br.readLine();
			System.out.println("Please input height");
			height = Integer.parseInt(br.readLine());
			System.out.println("Please input weight");
			weight = Integer.parseInt(br.readLine());
			System.out.println("Please input age");
			age = Integer.parseInt(br.readLine());
			System.out.println("Please input goal");
			goal = Integer.parseInt(br.readLine());
			System.out.println("Please input target weight");
			targetWeight = Integer.parseInt(br.readLine());

			writer.addUser(name, gender, height, weight, age, goal, targetWeight);
			u = reader.readUser("src/users.csv");

		} catch (IOException e) {
			e.printStackTrace();
		}


	}

	/**
	 * 
	 * @param field: the name of the field to be searched for
	 * @param value: a string representing the value of the field to be searched for
	 * @return: an ArrayList of entries retrieved from the csv file containing the correct field values.
	 */
	private ArrayList<Entry> searchFor(String field, String value){
		ArrayList<Entry> found = reader.SearchFor(field.toUpperCase(), value);
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
				writer.addEntry(type,cal);
			}else{
				addEntry(br,type);
			}
		}else{
			addExercise(br);
		}



	}

	private void displayDays(int days, String field){
		Calendar c = Calendar.getInstance();
		Date current;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
		for(int i = 0; i<days;i++){
			current = c.getTime();
			showDayStars(sdf.format(current), field.toUpperCase());
			c.add(c.DAY_OF_MONTH, -1);
		}
	}

	private void showDayStars(String date, String type){
		int starTotal = 0;

		int dailyCalories = c.maintain(u);

		if(type.equals("WEIGHT")){

		}else{
			ArrayList<Entry> dayEntries = searchFor("DATE",date);
			for(int i = 0;i<dayEntries.size();i++){
				int current = Integer.parseInt(dayEntries.get(i).getValue());
				if(current>0 && type.equals("FOOD")){
					starTotal += current;
				}else if(current<0 && type.equals("EXERCISE")){
					starTotal += -current;
				}
			}
		}
		System.out.print(date+": ");

		//compares calories with dailyRecommended
		System.out.print(Integer.toString(starTotal) + "/" + Integer.toString(dailyCalories) + " ");
		starTotal = starTotal/20;

		for(int i = 0;i<starTotal;i++){
			System.out.print('*');
		}
		System.out.println();


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
			writer.addEntry(5, Integer.parseInt(caloriesBurnt));
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
	
	    //for GUI to be able to add food
    	private void addFood(int calories, String foodType){
      		writer.addEntry(3, calories);
    	}



}
