import java.io.*;
import java.time.LocalDateTime;

public class CSVWriter	{
	
	FileWriter entryWriter;
	/*TODO: *implement a method to add an entry to the entries csv
	 * 		*implement a method to add a new user to the users csv*/
	public CSVWriter(){
		
	}
	
	public void addEntry(int type,int userID, int calories){
		try {
			entryWriter = new FileWriter(new File("src/entries.csv"),true);
			String date = LocalDateTime.now().toString().substring(0, 10);
			entryWriter.write("\n"+type+","+userID+","+calories+","+date+",");
			System.out.println("entry written to file");
			entryWriter.close();
		} catch (IOException e) {
			System.err.println("Unable to write to file");
			System.exit(1);
		}
	}
	
}