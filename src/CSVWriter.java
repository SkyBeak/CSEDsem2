import java.io.*;
import java.util.Calendar;
import java.text.SimpleDateFormat;

public class CSVWriter	{
	
	FileWriter entryWriter;
	FileWriter userWriter;
	
	public CSVWriter(){
		
	}
	
	public void addEntry(int type, int calories){
		try {
			entryWriter = new FileWriter(new File("src/entries.csv"),true);
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
			Calendar c = Calendar.getInstance();
			String date = sdf.format(c.getTime());
			entryWriter.write("\n"+type+","+calories+","+date+",");
			System.out.println("entry written to file");
			entryWriter.close();
		} catch (IOException e) {
			System.err.println("Unable to write to file");
			System.exit(1);
		}
	}
	
	/*
	 * adds user to userID csv
	 */
    	public void addUser(String name, String gender, int height, int weight, int age, int targetWeight, int targetTime){
        	try{
            		userWriter = new FileWriter(new File("src/users.csv"), true);
            		userWriter.write("\n"+name+","+gender+","+height+","+weight+","+age+","+targetWeight+","+targetTime+",");
            		System.out.println("New user written to file");
            		userWriter.close();
        	} catch (IOException e) {
            		System.err.println("Unable to write to file");
            		System.exit(1);
        }
    }
	
}
